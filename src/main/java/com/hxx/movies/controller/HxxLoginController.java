package com.hxx.movies.controller;

import com.hxx.common.util.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class HxxLoginController {

     //登录方法
    @GetMapping("/login/{code}")
    public R login(@PathVariable String code){
        if ("8888".equals(code)) {
            return R.ok().data("mobile","13936439780");
        }
        return R.error();
    }

    //登录信息
    @GetMapping("/send")
    public R send(){
        return R.ok().data("msg","8888");
    }
}
