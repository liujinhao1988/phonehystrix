package com.ljh.phonehystrix.service;

import com.ljh.phonehystrix.entity.PhoneInfo;
import com.ljh.phonehystrix.service.impl.PhoneServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

//降级
@Component
@FeignClient(fallbackFactory = PhoneServiceFallbackFactory.class)
public interface PhoneService {
    public PhoneInfo findSpecsByPhoneId(Integer phoneId);


}