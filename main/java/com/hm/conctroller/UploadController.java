package com.hm.conctroller;

import com.hm.pojo.Result;
import com.hm.utils.AliOSSUtils;
import com.hm.utils.AliOSSUtilsV2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {

    @Autowired
    private AliOSSUtils aliOSSUtils;

    @Autowired
    private AliOSSUtilsV2 aliOSSUtilsV2;

    /**
     * 本地文件上传
     * @param username
     * @param age
     * @param image
     * @return
     * @throws IOException
     */
//    @PostMapping("/upload")
//    public Result upload(String username, Integer age, MultipartFile image) throws IOException {
//        log.info("文件上传：{},{},{}",username,age,image);
//
//        // v1：获取文件原始名 并本地保存文件
////        String filename = image.getOriginalFilename();
////        image.transferTo(new File("D:/Files/000inbox/upload_test/" + filename));
//
//        // 构造唯一的文件名
//        String filename = image.getOriginalFilename();
//        int index = filename.lastIndexOf(".");
//        String extname = filename.substring(index);
//        String newFileName = UUID.randomUUID().toString() + extname;
//
//        log.info("新的文件名：{}",newFileName);
//
//        // 把文件保存到  "D:/Files/000inbox/upload_test/" 文件夹下
//        image.transferTo(new File("D:/Files/000inbox/upload_test/" + newFileName));
//
//        return Result.success();
//    }

    /**
     * OSS 文件上传
     * @param image
     * @return
     * @throws IOException
     */
    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException {
        log.info("文件上传，文件名：{}", image.getOriginalFilename());
        
        // 调用阿里云 OSS 将图片上传
        String url = aliOSSUtilsV2.upload(image);
//        String url = aliOSSUtils.upload(image);
        log.info("文件上传完成，url：{}", url);

        return Result.success(url);
    }

}
