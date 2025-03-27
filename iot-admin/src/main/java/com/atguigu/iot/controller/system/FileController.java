package com.atguigu.iot.controller.system;

import com.atguigu.iot.common.result.Result;
import com.atguigu.iot.system.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/***
 * 文件管理操作的控制层
 */
@RestController
@RequestMapping(value = "/system/file")
public class FileController {

    @Autowired
    private FileService fileService;

    /**
     * 文件上传
     * @return
     */
    @PostMapping(value = "/upload")
    public Result upload(@RequestParam MultipartFile file){
        return Result.ok(fileService.upload(file));
    }
}
