package com.test.springboot.controller;

import com.test.springboot.dao.ImageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.test.springboot.entity.Image;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ImageController {
    // 注入
    @Autowired
    private ImageDao imageDao;

    private final String pro_path = "E:\\image";
    // private final String dev_path = "\\root";

    @PostMapping("post_image")
    public String postImage(MultipartFile file){
        //判断是否有文件
        if (file == null) {
            return "图片不可以为空.";
        }
        //判断文件类型，我们只支持图片上传，比如说：png，jpg，gif
        String contentType = file.getContentType();
        if (contentType == null) {
            return "图片格式错误.";
        }
        contentType = contentType.replace("image/","");
        //获取相关数据，比如说文件类型，文件名称
        String originalFilename = file.getOriginalFilename();
        if (originalFilename == null) {
            return "不支持此图片类型";
        }
        //限制文件的大小
        long size = file.getSize();
        long maxSize = 5*1024*1024;
        if (size > maxSize) {
            return "图片最大仅支持" + (maxSize / 1024 / 1024) + "Mb";
        }
        //创建图片的保存目录
        //规则：配置目录/日期/类型/ID.类型
        int year = new Date().getYear()+2000-100;
        int mouth = new Date().getMonth()+1;
        int day = new Date().getDay();
        String date = year+"-"+mouth+"-"+day;
        String dayPath = pro_path + File.separator + date;
        File dayPathFile = new File(dayPath);
        //判断日期文件夹是否存在//2021-07-12
        if (!dayPathFile.exists()) {
            dayPathFile.mkdirs();
        }
        String targetPath = dayPath +
                File.separator + contentType + File.separator + originalFilename;
        System.out.println("targetPath ==> "+targetPath);
        File targetFile = new File(targetPath);
        //判断类型文件夹是否存在//gif
        if (!targetFile.getParentFile().exists()) {
            targetFile.getParentFile().mkdirs();
        }
        try {
            if (!targetFile.exists()) {
                targetFile.createNewFile();
            }
            //保存文件
            file.transferTo(targetFile);
            //返回结果：包含这个图片的名称和访问路径
            Image image = new Image();
            image.setId(dayPath+":"+originalFilename);
            image.setName(originalFilename);
            image.setSize(size+"KB");
            image.setType(contentType);
            image.setCreateTime(new Date());
            image.setPath(targetPath);
            //记录文件
            //保存记录到数据里
            imageDao.save(image);
            //返回结果
            System.out.println("文件上传成功");
            return "文件上传成功";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "图片上传失败，请稍后重试";
    }
}
