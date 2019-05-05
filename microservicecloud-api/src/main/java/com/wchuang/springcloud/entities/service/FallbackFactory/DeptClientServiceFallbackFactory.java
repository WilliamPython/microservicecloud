package com.wchuang.springcloud.entities.service.FallbackFactory;

import com.wchuang.springcloud.entities.Dept;
import com.wchuang.springcloud.entities.service.DeptClientService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * DeptClientServiceFallbackFactory类<br/>
 * Created by William Edwards on 2019/5/4.
 */
@Component//不要忘记添加
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService(){

            @Override
            public Dept get(Long id) {
                return new Dept().setDeptno(id)
                        .setDname("该ID："+id+"没有没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭")
                        .setDb_source("no this database in MySQL");
            }

            @Override
            public List<Dept> list() {
                return null;
            }

            @Override
            public boolean add(Dept dept) {
                return false;
            }
        };
    }
}
