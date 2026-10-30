package com.hxx.movies.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hxx.common.exception.HxxException;
import com.hxx.movies.domain.CourseInfoVo;
import com.hxx.movies.domain.CoursePublishVo;
import com.hxx.movies.entity.HxxMoviesDescriptionEntity;
import com.hxx.movies.service.HxxMoviesDescriptionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hxx.movies.dao.HxxMoviesDao;
import com.hxx.movies.entity.HxxMoviesEntity;
import com.hxx.movies.service.HxxMoviesService;


@Service("hxxMoviesService")
public class HxxMoviesServiceImpl extends ServiceImpl<HxxMoviesDao, HxxMoviesEntity> implements HxxMoviesService {
    @Autowired
    private HxxMoviesDao moviesDao;
    @Autowired
    private HxxMoviesDescriptionService hxxMoviesDescriptionService;
    //添加影片基本信息
    @Override
    public String saveCourseInfo(CourseInfoVo courseInfoVo) {
        //1 封装数据到HxxMoviesEntity对象
        HxxMoviesEntity moviesEntity = new HxxMoviesEntity();
        //2 将courseInfoVo对象中的数据复制到moviesEntity对象中
        BeanUtils.copyProperties(courseInfoVo, moviesEntity);
        //3 调用HxxMoviesDao将moviesEntity对象保存到数据库中
        int insert = baseMapper.insert(moviesEntity);
        //4 返回添加结果
        if (insert == 0) {
            throw new HxxException(201,"添加失败");
        }
        //5 返回影片id
        Long moviesEntityId = moviesEntity.getId();
        //添加影片描述信息
        HxxMoviesDescriptionEntity moviesDescription = new HxxMoviesDescriptionEntity();
        moviesDescription.setDescription(courseInfoVo.getDescription());
        //影片的描述和影片应该是one-to-one的关系
        moviesDescription.setId(moviesEntityId);
        moviesDescription.setMovieId(moviesEntityId);
        hxxMoviesDescriptionService.save(moviesDescription);
        //返回影片id
        return moviesEntityId.toString();
    }

    //根据课程id查询影片基本信息
    @Override
    public CourseInfoVo getCourseInfo(String courseId) {
        //1 根据课程id查询影片信息
        HxxMoviesEntity moviesEntity = baseMapper.selectById(courseId);
        if (moviesEntity == null) {
            throw new HxxException(201,"查询失败");
        }
        //2 把信息转给vo载体
        CourseInfoVo courseInfoVo = new CourseInfoVo();
        //3 将moviesEntity对象中的数据复制到courseInfoVo对象中
        BeanUtils.copyProperties(moviesEntity, courseInfoVo);
        //3 根据课程id查询描述信息
        HxxMoviesDescriptionEntity moviesDescription = hxxMoviesDescriptionService.getById(courseId);
        //4 把描述信息添加到vo载体中
        courseInfoVo.setDescription(moviesDescription.getDescription());
        return courseInfoVo;
    }

    //更新影片信息
    @Override
    public void updateCourseInfo(CourseInfoVo courseInfoVo) {
        //1 封装数据到HxxMoviesEntity对象
        HxxMoviesEntity moviesEntity = new HxxMoviesEntity();
        //2 将courseInfoVo对象中的数据复制到moviesEntity对象中
        BeanUtils.copyProperties(courseInfoVo, moviesEntity);
        //3 调用HxxMoviesDao将moviesEntity对象保存到数据库中
        int update = baseMapper.updateById(moviesEntity);
        //4 返回添加结果
        if (update == 0) {
            throw new HxxException(201,"添加失败");
        }
        //5 影片描述信息
        HxxMoviesDescriptionEntity moviesDescription = new HxxMoviesDescriptionEntity();
        moviesDescription.setDescription(courseInfoVo.getDescription());
        //影片的描述和影片应该是one-to-one的关系
        moviesDescription.setId(moviesEntity.getId());
        hxxMoviesDescriptionService.updateById(moviesDescription);
    }

    //确认影片信息
    @Override
    public CoursePublishVo publishCourseInfo(String id) {
        CoursePublishVo coursePublishVo = baseMapper.getPublishCourseInfo(id);
        if (coursePublishVo == null) {
            throw new HxxException(201,"查询失败");
        }
        return coursePublishVo;
    }

    @Override
    public Page getCourseInfoList(Page<HxxMoviesEntity> page) {
        QueryWrapper<HxxMoviesEntity> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");
        return moviesDao.selectPage(page, wrapper);
    }

    @Override
    public Page getCourseInfoList(Page<HxxMoviesEntity> page, String title) {
        LambdaQueryWrapper<HxxMoviesEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(HxxMoviesEntity::getMovieTitle, title).orderByDesc(HxxMoviesEntity::getId);
        return moviesDao.selectPage(page, wrapper);
    }
}