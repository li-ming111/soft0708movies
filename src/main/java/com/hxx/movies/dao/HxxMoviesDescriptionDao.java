package com.hxx.movies.dao;

import com.hxx.movies.entity.HxxMoviesDescriptionEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 影视简介表
 * 
 * @author siming
 * @email hxx@gmail.com
 * @date 2024-11-24 10:58:28
 */
@Mapper
public interface HxxMoviesDescriptionDao extends BaseMapper<HxxMoviesDescriptionEntity> {
	
}
