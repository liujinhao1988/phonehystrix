package com.ljh.phonehystrix.controller;

import com.ljh.phonehystrix.entity.PhoneInfo;
import com.ljh.phonehystrix.service.PhoneService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/phone")
public class PhoneController {
    @Autowired
    PhoneService phoneService;



    @GetMapping("/findSpecsByPhoneId/{phoneId}")
//熔断
    @HystrixCommand(fallbackMethod = "HystrixFindSpecsByPhoneId")

    public PhoneInfo findSpecsByPhoneId(@PathVariable("phoneId") Integer phoneId){
        PhoneInfo specsByPhoneId = phoneService.findSpecsByPhoneId(phoneId);


        if(specsByPhoneId==null){
            throw new RuntimeException("aaa:"+phoneId);
        }
        return specsByPhoneId;
    }

    public PhoneInfo HystrixFindSpecsByPhoneId(@PathVariable("phoneId") Integer phoneId){
        PhoneInfo specsByPhoneId = new PhoneInfo();
        specsByPhoneId.setPhoneId(phoneId);
        specsByPhoneId.setPhoneName("没有这个手机");
        specsByPhoneId.setCategoryType(0000);


        return specsByPhoneId;
    }

}