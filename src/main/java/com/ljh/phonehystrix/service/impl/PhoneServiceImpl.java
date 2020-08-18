package com.ljh.phonehystrix.service.impl;

import com.alibaba.fastjson.JSON;
import com.ljh.phonehystrix.entity.PhoneInfo;
import com.ljh.phonehystrix.repository.PhoneInfoRepository;
import com.ljh.phonehystrix.service.PhoneService;
import com.ljh.phonehystrix.util.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

@Service
public class PhoneServiceImpl implements PhoneService {


    @Autowired
    RedisUtil redisUtil;
    @Autowired
    PhoneInfoRepository phoneInfoRepository;






    @Override
    public PhoneInfo findSpecsByPhoneId(Integer phoneId) {
        PhoneInfo phoneInfo=new PhoneInfo();
        Jedis jedis = redisUtil.getJedis();
        String phoneKey = "sku:" + phoneId + ":info";
        String phoneInfoJson = jedis.get(phoneKey);
        if (StringUtils.isNotBlank(phoneInfoJson)) {
            System.out.println(phoneId+"redis");

            phoneInfo = JSON.parseObject(phoneInfoJson, PhoneInfo.class);
            return phoneInfo;

        }else{
            //若没有该缓存
            phoneInfo= phoneInfoRepository.findByPhoneId(phoneId);
            jedis.set("sku:" + phoneId + ":info", JSON.toJSONString(phoneInfo));
            System.out.println(phoneId+"DB");

            return phoneInfo;



        }





    }




}