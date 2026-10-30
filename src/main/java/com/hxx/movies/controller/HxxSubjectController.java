package com.hxx.movies.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hxx.common.util.R;
import com.hxx.movies.entity.HxxSubjectEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hxx.movies.service.HxxSubjectService;
import org.springframework.web.multipart.MultipartFile;

/**
 * 影视类别表
 *
 * @author siming
 * @email hxx@gmail.com
 * @date 2024-11-24 10:58:28
 */
@Tag(name = "影视类别表", description = "影视类别表")
@RestController
@RequestMapping("/movies/hxxsubject")
public class HxxSubjectController {
    @Autowired
    private HxxSubjectService hxxSubjectService;

    //添加影片分类
    @Operation(summary = "添加影片分类", description = "添加影片分类")
    @PostMapping(value = "addSubject", consumes = "multipart/form-data")
    public R addSubject(@RequestPart("file") MultipartFile file){
        //1 获取上传的excel文件 MultipartFile
        //返回错误提示信息
        hxxSubjectService.batchImport(file,hxxSubjectService);
        //判断返回集合是否为空
        return R.ok();
    }

    /**
     * 获取所有一级分类
     */
    @Operation(summary = "获取所有一级分类", description = "获取所有一级分类")
    @GetMapping("getFirstSubject")
    public R getFirstSubject(){
        QueryWrapper<HxxSubjectEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id",0);
        return R.ok().data("items",hxxSubjectService.list(wrapper));
    }

    @Operation(summary = "获取二级分类", description = "获取二级分类")
    @GetMapping("getSecondSubject/{id}")
    public R getSecondSubject(@Parameter(description = "一级分类id")
                                 @PathVariable long id){
        QueryWrapper<HxxSubjectEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id",id);
        return R.ok().data("items",hxxSubjectService.list(wrapper));
    }
}
