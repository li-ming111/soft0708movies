package com.hxx.common;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hxx.movies.domain.ReadData;
import com.hxx.movies.entity.HxxSubjectEntity;
import com.hxx.movies.service.HxxSubjectService;

import java.util.Map;

//创建读取excel监听器
public class ExcelLisener extends AnalysisEventListener<ReadData> {

    private HxxSubjectService hxxSubjectService;

    public ExcelLisener() {}

    //创建有参数构造，传递subjectService用于操作数据库
    public ExcelLisener(HxxSubjectService hxxSubjectService) {
        this.hxxSubjectService = hxxSubjectService;
    }

    //判断一级分类是否重复
    private HxxSubjectEntity existOneSubject(HxxSubjectService hxxSubjectService, String name){
        QueryWrapper<HxxSubjectEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("title",name);
        wrapper.eq("parent_id","0");
        HxxSubjectEntity subject = hxxSubjectService.getOne(wrapper);
        return subject;
    }

    //判断二级分类是否重复
    private HxxSubjectEntity existTwoSubject(HxxSubjectService hxxSubjectService,String name,long pid){
        QueryWrapper<HxxSubjectEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("title",name);
        wrapper.eq("parent_id",pid);
        HxxSubjectEntity subject = hxxSubjectService.getOne(wrapper);
        return subject;
    }

    @Override//读取Excel数据
    public void invoke(ReadData readData, AnalysisContext analysisContext) {
        if (readData==null) {
            throw new RuntimeException("添加失败");
        }
        //添加一级分类
        HxxSubjectEntity existOneSubject = existOneSubject(hxxSubjectService, readData.getOneSubjectName());
        if (existOneSubject==null) {//没有相同的
            existOneSubject = new HxxSubjectEntity();
            existOneSubject.setTitle(readData.getOneSubjectName());
            existOneSubject.setParentId(0L);
            hxxSubjectService.save(existOneSubject);
        }

        //获取一级分类id值
        Long pid = existOneSubject.getId();

        //添加二级分类
        HxxSubjectEntity existTwoSubject = existTwoSubject(hxxSubjectService, readData.getTwoSubjectName(), pid);
        if (existTwoSubject==null) {
            existTwoSubject = new HxxSubjectEntity();
            existTwoSubject.setTitle(readData.getTwoSubjectName());
            existTwoSubject.setParentId(pid);
            hxxSubjectService.save(existTwoSubject);
        }
    }


    @Override//读取Excel表头信息
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        System.out.println("表头信息:"+headMap);
    }

    @Override//读取后的操作
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
    }
}