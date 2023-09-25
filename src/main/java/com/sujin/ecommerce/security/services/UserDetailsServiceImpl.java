package com.sujin.ecommerce.security.services;

import com.sujin.ecommerce.member.mapper.MemberMapper;
import com.sujin.ecommerce.member.vo.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    MemberMapper memberMapper;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        // username == email WebSecurityConfiguration에서 설정 매핑되어있음.
        Member member = memberMapper.getId(id);

        return UserDetail
                .builder()
                .member(member)
                .build();
    }
}
