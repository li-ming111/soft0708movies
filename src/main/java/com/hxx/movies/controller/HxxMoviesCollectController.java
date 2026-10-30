package com.hxx.movies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hxx.movies.service.HxxMoviesCollectService;

/**
 * 影视收藏表
 *
 * @author siming
 * @email hxx@gmail.com
 * @date 2024-11-24 10:58:28
 */
@RestController
@RequestMapping("/movies/hxxmoviescollect")
public class HxxMoviesCollectController {
    @Autowired
    private HxxMoviesCollectService hxxMoviesCollectService;

}
