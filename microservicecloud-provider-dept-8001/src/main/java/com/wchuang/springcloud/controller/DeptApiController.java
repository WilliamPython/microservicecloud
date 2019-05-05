package com.wchuang.springcloud.controller;

import java.util.List;

import com.wchuang.springcloud.entities.service.serviceApi.DeptClientServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wchuang.springcloud.entities.Dept;
import com.wchuang.springcloud.service.DeptService;

/**
 * 对DeptController进行改造成DeptApiController，专门对外服务的controller
 */
@RestController
public class DeptApiController implements DeptClientServiceApi
{
    @Autowired
    private DeptService service;

    @Override
    public Dept get(Long id) {
        return service.get(id);
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

