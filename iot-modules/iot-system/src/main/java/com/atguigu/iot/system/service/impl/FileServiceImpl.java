package com.atguigu.iot.system.service.impl;

import com.atguigu.iot.system.config.MinioConfig;
import com.atguigu.iot.system.service.FileService;
import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

/***
 * 文件操作的接口类的实现类
 */
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private MinioConfig minioConfig;

    /**
     * 文件上传: 使用minio进行文件上传操作
     *
     * @param file
     * @return
     */
    @SneakyThrows
    @Override
    public String upload(MultipartFile file) {
        //客户端对象初始化: 连接上minio
        MinioClient minioClient = MinioClient.builder()
                .endpoint(minioConfig.getEndpointUrl())//minio的地址
                .credentials(minioConfig.getAccessKey(), minioConfig.getSecretKey())//用户名和密码
                .build();
        //桶必须存在,若不存在则需要创建桶(创建一个文件,必须先保证文件目录存在的)
        if(!minioClient.bucketExists(BucketExistsArgs
                .builder()
                .bucket(minioConfig.getBucketName())
                .build())){
            //桶不存在,创建桶
            minioClient.makeBucket(
                    MakeBucketArgs.builder()
                            .bucket(minioConfig.getBucketName())
                            .build());
        }
        //文件的名字: 随机串
        String flieName = UUID.randomUUID().toString().replace("-", "");
        //文件上传操作:上传到指定的桶里面去(指定的文件夹目录中去保存)
        minioClient.putObject(
                PutObjectArgs
                        .builder()
                        .object(flieName)//文件名字
                        .contentType(file.getContentType())//文件的类型
                        .stream(file.getInputStream(), file.getSize(), -1)//文件内容
                        .bucket(minioConfig.getBucketName())//桶的名字
                        .build()
        );
        //获取文件的访问地址,返回: minio地址+ /+ 桶名字 + /+文件名
        return minioConfig.getEndpointUrl() + "/" + minioConfig.getBucketName() + "/" + flieName;
    }
}
