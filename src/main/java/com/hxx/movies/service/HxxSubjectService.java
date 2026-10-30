package com.hxx.movies.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hxx.movies.entity.HxxSubjectEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * 影视类别表
 *
 * @author siming
 * @email hxx@gmail.com
 * @date 2024-11-24 10:58:28
 */
public interface HxxSubjectService extends IService<HxxSubjectEntity> {
    void batchImport(MultipartFile file, HxxSubjectService hxxSubjectService);
}

