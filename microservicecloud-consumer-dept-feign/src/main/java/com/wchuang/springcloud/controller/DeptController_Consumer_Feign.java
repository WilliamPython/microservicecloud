package com.wchuang.springcloud.controller;

import com.wchuang.springcloud.entities.Dept;
import com.wchuang.springcloud.entities.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptController_Consumer_Feign
{
    //private static final String REST_URL_PREFIX = "http://localhost:8001";
    /*private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";//Ribbon和整合Eureka后Consumer可以直接调用服务而不用关心地址和端口号

    @Autowired
    private RestTemplate restTemplate;*/

    @Autowired
    private DeptClientService service = null;

    @RequestMapping(value="/consumer/dept/add")
    public boolean add(Dept dept)
    {
        return this.service.add(dept);
    }

    @RequestMapping(value="/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id)
    {
        return this.service.get(id);
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value="/consumer/dept/list")
    public List<Dept> list()
    {
        return this.service.list();
    }

}





