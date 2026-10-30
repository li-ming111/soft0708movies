package com.hxx.movies.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hxx.movies.domain.CourseInfoVo;
import com.hxx.movies.domain.CoursePublishVo;
import com.hxx.movies.entity.HxxMoviesEntity;

import java.util.Map;

/**
 * 影片表
 *
 * @author siming
 * @email hxx@gmail.com
 * @date 2024-11-24 10:58:28
 */
public interface HxxMoviesService extends IService<HxxMoviesEntity> {

    //添加影片的基本信息
    String saveCourseInfo(CourseInfoVo courseInfoVo);

    //根据影片id查询
    CourseInfoVo getCourseInfo(String courseId);

    //修改影片信息
    void updateCourseInfo(CourseInfoVo courseInfoVo);

    //根据影片id确认影片信息
    CoursePublishVo publishCourseInfo(String id);

    //分页
    Page getCourseInfoList(Page<HxxMoviesEntity> page);

    //分页,条件查询
    Page getCourseInfoList(Page<HxxMoviesEntity> page,String title);
}

