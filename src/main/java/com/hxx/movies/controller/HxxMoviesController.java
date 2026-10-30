package com.hxx.movies.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hxx.common.util.R;
import com.hxx.movies.domain.CourseInfoVo;
import com.hxx.movies.domain.CoursePublishVo;
import com.hxx.movies.entity.HxxMoviesEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hxx.movies.service.HxxMoviesService;

/**
 * 影片表
 *
 * @author siming
 * @email hxx@gmail.com
 * @date 2024-11-24 10:58:28
 */
@Tag(name = "影片表", description = "影片表")
@RestController
@RequestMapping("/movies/hxxmovies")
public class HxxMoviesController {
    @Autowired
    private HxxMoviesService hxxMoviesService;


    /**
     * 分页数据
     */
    @Operation(summary = "分页数据", description = "分页数据")
    @GetMapping("/pageMovies")
    public R list(Page<HxxMoviesEntity> page) {
        hxxMoviesService.getCourseInfoList(page);
        return R.ok().data("total", page.getTotal()).data("rows", page.getRecords());
    }
    /**
     * 条件分页
     */
    @Operation(summary = "条件分页", description = "条件分页")
    @GetMapping("/pageMoviesByCondition")
    public R list(Page<HxxMoviesEntity> page,String title) {
        hxxMoviesService.getCourseInfoList(page, title);
        return R.ok().data("total", page.getTotal()).data("rows", page.getRecords());
    }

    /**
     * 添加影片基本信息
     */
    @Operation(summary = "添加影片基本信息", description = "添加影片基本信息")
    @PostMapping("/addMoviesInfo")
    public R addMoviesInfo(@RequestBody CourseInfoVo courseInfoVo) {
        String moviesId = hxxMoviesService.saveCourseInfo(courseInfoVo);
        return R.ok().data("moviesId", moviesId);
    }

    /**
     根据影片id获取影片信息
     */
    @Parameter(name = "moviesId", description = "", in = ParameterIn.PATH, required = true)
    @Operation(summary = "根据影片id获取影片信息", description = "根据影片id获取影片信息")
    @GetMapping("/getMoviesInfo/{moviesId}")
    public R getMoviesInfo(@PathVariable String moviesId) {
        CourseInfoVo courseInfoVo = hxxMoviesService.getCourseInfo(moviesId);
        return R.ok().data("courseInfoVo", courseInfoVo);
    }

    /**
     * 更新影片信息
     */
    @Operation(summary = "更新影片信息", description = "更新影片信息")
    @PutMapping("/updateMoviesInfo")
    public R updateMoviesInfo(@RequestBody CourseInfoVo courseInfoVo) {
        hxxMoviesService.updateCourseInfo(courseInfoVo);
        return R.ok();
    }
    /**
     * 根据id获取发布影片信息
     */
    @Parameter(name = "moviesId", description = "", in = ParameterIn.PATH, required = true)
    @Operation(summary = "根据id获取发布影片信息", description = "根据id获取发布影片信息")
    @GetMapping("/publishMoviesInfo/{moviesId}")
    public R publishMoviesInfo(@PathVariable String moviesId) {
        CoursePublishVo coursePublishVo = hxxMoviesService.publishCourseInfo(moviesId);
        return R.ok().data("coursePublishVo", coursePublishVo);
    }

    /**
     确认影片信息
     */
    @Parameter(name = "moviesId", description = "", in = ParameterIn.PATH, required = true)
    @Operation(summary = "确认影片信息", description = "确认影片信息")
    @GetMapping("/publishMovies/{moviesId}")
    public R publishMovies(@PathVariable String moviesId) {
        HxxMoviesEntity hxxMovies = hxxMoviesService.getById(moviesId);
        hxxMovies.setStatus(1);
        hxxMoviesService.updateById(hxxMovies);
        return R.ok();
    }

    /**
     * 删除影片信息
     */
    @Parameter(name = "moviesId", description = "", in = ParameterIn.PATH, required = true)
    @Operation(summary = "删除影片信息", description = "删除影片信息")
    @DeleteMapping("/deleteMovies/{moviesId}")
    public R deleteMovies(@PathVariable String moviesId) {
        hxxMoviesService.removeById(moviesId);
        return R.ok();
    }
}




































