package com.sujin.ecommerce.member.service;

import com.sujin.ecommerce.member.mapper.MemberMapper;
import com.sujin.ecommerce.member.vo.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MemberService {
// 비지니스로직
    @Autowired MemberMapper memberMapper;

    // member create 생성
    public int create(Member param){

        log.info("MemberService Create 진입 >>> " + param);
        return memberMapper.create(param);
    }


}
