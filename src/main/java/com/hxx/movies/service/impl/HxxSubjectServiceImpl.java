package com.hxx.movies.service.impl;

import com.alibaba.excel.EasyExcel;
import com.hxx.common.ExcelLisener;
import com.hxx.movies.domain.ReadData;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hxx.movies.dao.HxxSubjectDao;
import com.hxx.movies.entity.HxxSubjectEntity;
import com.hxx.movies.service.HxxSubjectService;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;


@Service("hxxSubjectService")
public class HxxSubjectServiceImpl extends ServiceImpl<HxxSubjectDao, HxxSubjectEntity> implements HxxSubjectService {

    @Override
    public void batchImport(MultipartFile file, HxxSubjectService hxxSubjectService) {
         try {
            InputStream inputStream = file.getInputStream();
            //需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
            EasyExcel.read(inputStream, ReadData.class,new ExcelLisener(hxxSubjectService))
                    .sheet().doRead();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}