package com.atguigu.iot.system.service;

import org.springframework.web.multipart.MultipartFile;

/***
 * 文件操作的接口类
 */
public interface FileService {

    /**
     * 文件上传
     * @param file
     * @return
     */
    public String upload(MultipartFile file);
}
