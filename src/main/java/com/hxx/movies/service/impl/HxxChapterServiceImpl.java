package com.hxx.movies.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hxx.movies.entity.HxxVideoEntity;
import com.hxx.movies.service.HxxVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hxx.movies.dao.HxxChapterDao;
import com.hxx.movies.entity.HxxChapterEntity;
import com.hxx.movies.service.HxxChapterService;

import java.util.List;
import java.util.stream.Collectors;


@Service("hxxChapterService")
public class HxxChapterServiceImpl extends ServiceImpl<HxxChapterDao, HxxChapterEntity> implements HxxChapterService {

    @Autowired
    private HxxChapterDao hxxChapterDao;
    @Autowired
    private HxxVideoService hxxVideoService;

    @Override
    public List<HxxChapterEntity> queryPage(long movieId) {
        QueryWrapper<HxxChapterEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("movie_id",movieId);
        return hxxChapterDao.selectList(queryWrapper).stream()
                .map(item->{
                    QueryWrapper<HxxVideoEntity> wrapper = new QueryWrapper<>();
                    wrapper.eq("chapter_id",item.getId());
                    List<HxxVideoEntity> list = hxxVideoService.list(wrapper);
                    item.setChildren(list);
                    return item;
                }).collect(Collectors.toList());
    }
}


