package com.example.schoolmicroservice.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "student-micro-service")
@RibbonClient(name = "student-micro-service")
public interface StudentMicroServiceProxy {

    @GetMapping("/doRibbonTest")
    String doRibbonTest();
}
