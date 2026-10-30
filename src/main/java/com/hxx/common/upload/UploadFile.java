package com.hxx.common.upload;

import com.hxx.common.util.R;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/upload")
public class UploadFile {

    @PostMapping
    public R upload(MultipartFile file) throws IOException {
        //把文件的内容存储到本地磁盘上
        String originFileName = file.getOriginalFilename();
        //需要保证文件名字唯一，防止文件被覆盖
        String fileName = UUID.randomUUID().toString().replace("-","")
                +originFileName.substring(originFileName.lastIndexOf("."));
        String path = "D:/SpringBoot3/files/";
        File dest = new File(path);
        //创建文件夹
        if (!dest.exists()){
            dest.mkdirs();
        }
        file.transferTo(new File(path+fileName));
        return R.ok().data("url",path+fileName);
    }
}
