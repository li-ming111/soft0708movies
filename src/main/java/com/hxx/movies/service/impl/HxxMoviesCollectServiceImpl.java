package com.hxx.movies.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hxx.movies.dao.HxxMoviesCollectDao;
import com.hxx.movies.entity.HxxMoviesCollectEntity;
import com.hxx.movies.service.HxxMoviesCollectService;


@Service("hxxMoviesCollectService")
public class HxxMoviesCollectServiceImpl extends ServiceImpl<HxxMoviesCollectDao, HxxMoviesCollectEntity> implements HxxMoviesCollectService {

}