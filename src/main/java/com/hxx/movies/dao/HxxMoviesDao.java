package com.hxx.movies.dao;

import com.hxx.movies.domain.CoursePublishVo;
import com.hxx.movies.entity.HxxMoviesEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 影片表
 * 
 * @author siming
 * @email hxx@gmail.com
 * @date 2024-11-24 10:58:28
 */
@Mapper
public interface HxxMoviesDao extends BaseMapper<HxxMoviesEntity> {
    String sql = """                
            SELECT ec.id,ec.movie_title,ec.sale_price,ec.total_chapters ASvideoNum,ec.cover_image_url,
                       et.name AS actorName,es1.title AS subjectLevelOne,
                       es2.title AS subjectLevelTwo
                FROM hxx_movies ec\s
                LEFT OUTER JOIN hxx_movies_description ecd ON ec.id=ecd.id
                LEFT OUTER JOIN hxx_actor et ON ec.actor_id=et.id
                LEFT OUTER JOIN hxx_subject es1 ON ec.subject_parent_id=es1.id
                LEFT OUTER JOIN hxx_subject es2 ON ec.subject_id=es2.id
                WHERE ec.id=#{courseId}
                """;
    //影片发布信息
    @Select(sql)
    public CoursePublishVo getPublishCourseInfo(String courseId);
}
