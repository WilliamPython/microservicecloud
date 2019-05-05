package com.wchuang.springcloud.service;

import com.wchuang.springcloud.entities.Dept;

import java.util.List;

public interface DeptService
{
    public boolean add(Dept dept);
    public Dept    get(Long id);
    public List<Dept> list();
}


