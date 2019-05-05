package com.wchuang.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wchuang.springcloud.entities.Dept;
import com.wchuang.springcloud.entities.service.serviceApi.DeptClientServiceApi;
import com.wchuang.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 对DeptController进行改造成DeptApiController，专门对外服务的controller
 */
@RestController
public class DeptApiController implements DeptClientServiceApi
{
    @Autowired
    private DeptService service;

    @Override
    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    //一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept get(@PathVariable("id") Long id) {
        Dept dept =  this.service.get(id);
        //模拟抛出错误信息
        if(null == dept)
        {
            throw new RuntimeException("该ID："+id+"没有没有对应的信息");
        }
        return dept;
    }

    /**
     * get方法熔断处理
     * @param id
     * @return
     */
    public Dept processHystrix_Get(@PathVariable("id") Long id)
    {
        return new Dept().setDeptno(id)
                .setDname("该ID："+id+"没有没有对应的信息,null--@HystrixCommand")
                .setDb_source("no this database in MySQL");
    }


    @Override
    public List<Dept> list() {
        return service.list();
    }

    @Override
    public boolean add(Dept dept) {
        return service.add(dept);
    }

}

