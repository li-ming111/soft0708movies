package com.hxx.movies.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hxx.movies.dao.HxxMoviesDescriptionDao;
import com.hxx.movies.entity.HxxMoviesDescriptionEntity;
import com.hxx.movies.service.HxxMoviesDescriptionService;


@Service("hxxMoviesDescriptionService")
public class HxxMoviesDescriptionServiceImpl extends ServiceImpl<HxxMoviesDescriptionDao, HxxMoviesDescriptionEntity> implements HxxMoviesDescriptionService {

}