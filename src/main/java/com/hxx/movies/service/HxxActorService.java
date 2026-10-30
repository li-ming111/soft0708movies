package com.hxx.movies.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hxx.movies.entity.HxxActorEntity;

import java.util.Map;

/**
 * 演员表
 *
 * @author siming
 * @email hxx@gmail.com
 * @date 2024-11-24 10:58:28
 */
public interface HxxActorService extends IService<HxxActorEntity> {
    Page queryPage(Page<HxxActorEntity> params);
}

