package com.hxx.movies.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hxx.movies.entity.HxxChapterEntity;

import java.util.List;
import java.util.Map;

/**
 * 影视片段表
 *
 * @author siming
 * @email hxx@gmail.com
 * @date 2024-11-24 10:58:28
 */
public interface HxxChapterService extends IService<HxxChapterEntity> {

    List<HxxChapterEntity> queryPage(long movieId);
}

