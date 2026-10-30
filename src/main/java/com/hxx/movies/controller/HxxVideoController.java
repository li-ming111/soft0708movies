package com.hxx.movies.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hxx.common.util.R;
import com.hxx.movies.entity.HxxVideoEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hxx.movies.service.HxxVideoService;

import java.util.List;

/**
 * 电影视频表
 *
 * @author siming
 * @email hxx@gmail.com
 * @date 2024-11-24 10:58:28
 */
@Tag(name = "电影视频表", description = "电影视频表")
@RestController
@RequestMapping("/movies/hxxvideo")
public class HxxVideoController {
    @Autowired
    private HxxVideoService hxxVideoService;

    /**
     * 根据电影片段id查询电影视频信息
     */
    @Parameter(name = "chapterId", description = "", in = ParameterIn.PATH, required = true)
    @Operation(summary = "根据电影片段id查询电影视频信息", description = "根据电影片段id查询电影视频信息")
    @GetMapping("/getVideoInfo/{chapterId}")
    public R getVideoInfo(@PathVariable Long chapterId){
        QueryWrapper<HxxVideoEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("chapter_id",chapterId);
        List<HxxVideoEntity> list = hxxVideoService.list(queryWrapper);
        return R.ok().data("rows",list);
    }
    /**
     * 添加电影视频信息
     */
    @Operation(summary = "添加电影视频信息", description = "添加电影视频信息")
    @PostMapping("/addVideoInfo")
    public R addVideoInfo(@RequestBody HxxVideoEntity hxxVideoEntity){
        hxxVideoService.save(hxxVideoEntity);
        return R.ok();
    }
    /**
     * 修改电影视频信息
     */
    @Operation(summary = "修改电影视频信息", description = "修改电影视频信息")
    @PutMapping("/updateVideoInfo")
    public R updateVideoInfo(@RequestBody HxxVideoEntity hxxVideoEntity){
        hxxVideoService.updateById(hxxVideoEntity);
        return R.ok();
    }
    /**
     * 删除电影视频信息
     */
    @Parameter(name = "id", description = "", in = ParameterIn.PATH, required = true)
    @Operation(summary = "删除电影视频信息", description = "删除电影视频信息")
    @DeleteMapping("/deleteVideoInfo/{id}")
    public R deleteVideoInfo(@PathVariable Long id){
        hxxVideoService.removeById(id);
        return R.ok();
    }
}





























