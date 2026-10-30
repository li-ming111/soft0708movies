package com.hxx.movies.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.hxx.movies.dao.HxxActorDao;
import com.hxx.movies.entity.HxxActorEntity;
import com.hxx.movies.service.HxxActorService;


@Service("hxxActorService")
public class HxxActorServiceImpl extends ServiceImpl<HxxActorDao, HxxActorEntity> implements HxxActorService {
    @Autowired
    private HxxActorDao hxxActorDao;
    @Override
    public Page queryPage(Page<HxxActorEntity> params) {
        return hxxActorDao.selectPage(params, null);
    }
}