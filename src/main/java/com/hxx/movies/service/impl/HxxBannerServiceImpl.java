package com.hxx.movies.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hxx.movies.dao.HxxBannerDao;
import com.hxx.movies.entity.HxxBannerEntity;
import com.hxx.movies.service.HxxBannerService;


@Service("hxxBannerService")
public class HxxBannerServiceImpl extends ServiceImpl<HxxBannerDao, HxxBannerEntity> implements HxxBannerService {


}