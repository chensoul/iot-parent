package com.atguigu.iot.controller.app;

import com.atguigu.iot.common.result.Result;
import com.atguigu.iot.lock.pojo.LockOptionLog;
import com.atguigu.iot.lock.service.LockAttrDataService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/iot-api/lock")
public class AppController {

    @Autowired
    private LockAttrDataService lockAttrDataService;

    /**
     * 查询设备的属性信息
     * @param clientId
     * @return
     */
    @GetMapping(value = "/getIndexData/{clientId}")
    public Result getIndexData(@PathVariable(value = "clientId") String clientId){
        return Result.ok(lockAttrDataService.getIndexData(clientId));
    }

    /**
     * 分页条件查询操作列表数据
     * @param clientId
     * @param page
     * @param size
     * @return
     */
    @GetMapping(value = "/lockOptionLog/list/{clientId}/{page}/{size}")
    public Result list(@PathVariable(value = "clientId") String clientId,
                       @PathVariable(value = "page") Integer page,
                       @PathVariable(value = "size") Integer size){
        return Result.ok(lockAttrDataService.getLockOptionLogList(new Page<LockOptionLog>(page, size), clientId));
    }
}
