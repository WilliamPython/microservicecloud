package com.wchuang.springcloud.entities.service;

import com.wchuang.springcloud.entities.service.FallbackFactory.DeptClientServiceFallbackFactory;
import com.wchuang.springcloud.entities.service.serviceApi.DeptClientServiceApi;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "MICROSERVICECLOUD-DEPT",fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService extends DeptClientServiceApi
{

}
