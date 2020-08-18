package com.ljh.phonehystrix.repository;

import com.ljh.phonehystrix.entity.PhoneInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneInfoRepository extends JpaRepository<PhoneInfo,Integer> {


    PhoneInfo findByPhoneId(Integer phoneId);
}