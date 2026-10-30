package com.hxx.movies.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hxx.common.util.R;
import com.hxx.movies.entity.HxxChapterEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hxx.movies.service.HxxChapterService;



/**
 * 影视片段表
 *
 * @author siming
 * @email hxx@gmail.com
 * @date 2024-11-24 10:58:28
 */

@RestController
@RequestMapping("/movies/hxxchapter")
@Tag(name = "影视片段表", description = "影视片段表")
public class HxxChapterController {
    @Autowired
    private HxxChapterService hxxChapterService;

    /**
     * 列表
     */
    @Parameter(name = "movieId", description = "", in = ParameterIn.PATH, required = true)
    @Operation(summary = "列表", description = "列表")
    @GetMapping("/getChapterVideo/{movieId}")
    public R list(@PathVariable long movieId){
        return R.ok().data("allChapterVideo",hxxChapterService.queryPage(movieId));
    }

    /**
     * 添加
     */
    @Operation(summary = "添加", description = "添加")
    @PostMapping("/addChapter")
    public R add(@RequestBody HxxChapterEntity hxxChapter){
        hxxChapterService.save(hxxChapter);
        return R.ok();
    }

    /**
     * 删除
     */
    @Parameter(name = "id", description = "", in = ParameterIn.PATH, required = true)
    @Operation(summary = "删除", description = "删除")
    @DeleteMapping("/deleteChapter/{id}")
    public R delete(@PathVariable long id){
        hxxChapterService.removeById(id);
        return R.ok();
    }
    /**
     * 修改
     */
    @Operation(summary = "修改", description = "修改")
    @PutMapping("/updateChapter")
    public R update(@RequestBody HxxChapterEntity hxxChapter){
        hxxChapterService.updateById(hxxChapter);
        return R.ok();
    }
}






























