package com.hxx.movies.controller;

import java.io.File;
import java.net.URI;
import java.net.URLEncoder;
import java.util.List;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hxx.common.util.R;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hxx.movies.entity.HxxActorEntity;
import com.hxx.movies.service.HxxActorService;

/**
 * 演员表
 *
 * @author siming
 * @email hxx@gmail.com
 * @date 2024-11-24 10:58:28
 */

@RestController
@RequestMapping("/movies/hxxactor")
public class HxxActorController {
    @Autowired
    private HxxActorService hxxActorService;

    /**
     * 列表
     */
    @GetMapping("/pageList")
    public R list(Page<HxxActorEntity> page){
        hxxActorService.queryPage(page);
        List<HxxActorEntity> list = page.getRecords();
        long total = page.getTotal();
        return R.ok().data("rows", list).data("total", total);
    }
    /**
     * 列表
     */
    @Operation(summary = "列表", description = "列表")
    @GetMapping("/list")
    public R list(){
        List<HxxActorEntity> list = hxxActorService.list();
        return R.ok().data("items", list);
    }

    /**
     * 删除
     */
    @Parameter(name = "id", description = "", in = ParameterIn.PATH, required = true)
    @Operation(summary = "删除", description = "删除")
    @DeleteMapping("/delete/{id}")
    public R delete(@PathVariable long id){
        hxxActorService.removeById(id);
        return R.ok();
    }

    /**
     * 保存
     */
    @Operation(summary = "保存", description = "保存")
    @PostMapping("/save")
    public R save(@RequestBody HxxActorEntity hxxActor){
        hxxActorService.save(hxxActor);
        return R.ok();
    }

    /**
     * 修改
     */
    @Operation(summary = "修改", description = "修改")
    @PutMapping("/update")
    public R update(@RequestBody HxxActorEntity hxxActor){
        hxxActorService.updateById(hxxActor);
        return R.ok();
    }
}



































