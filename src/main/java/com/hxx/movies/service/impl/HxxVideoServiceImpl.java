package com.hxx.movies.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hxx.movies.dao.HxxVideoDao;
import com.hxx.movies.entity.HxxVideoEntity;
import com.hxx.movies.service.HxxVideoService;


@Service("hxxVideoService")
public class HxxVideoServiceImpl extends ServiceImpl<HxxVideoDao, HxxVideoEntity> implements HxxVideoService {

}