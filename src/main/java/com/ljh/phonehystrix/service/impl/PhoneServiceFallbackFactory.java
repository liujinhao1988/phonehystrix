package com.ljh.phonehystrix.service.impl;

import com.ljh.phonehystrix.entity.PhoneInfo;
import com.ljh.phonehystrix.service.PhoneService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class PhoneServiceFallbackFactory implements FallbackFactory {
    @Override
    public PhoneService create(Throwable throwable) {
        return new PhoneService() {
            @Override
            public PhoneInfo findSpecsByPhoneId(Integer phoneId) {
                PhoneInfo specsByPhoneId = new PhoneInfo();
                specsByPhoneId.setPhoneId(phoneId);
                specsByPhoneId.setPhoneName("没有这个手机");
                specsByPhoneId.setCategoryType(0000);


                return specsByPhoneId;
            }
        };
    }
}
