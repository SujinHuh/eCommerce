package com.sujin.ecommerce.member.action;

import com.sujin.ecommerce.member.service.MemberService;
import com.sujin.ecommerce.member.vo.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class MemberAction {

    @Autowired MemberService memberService;

    @GetMapping(value ="/member/login")
    public String login() {
        return "/member/login.html";
    }

    @GetMapping(value ="/member/join")
    public String join() {

        return "/member/join.html";
    }

    @PostMapping(value ="/member/join")
    @ResponseBody public int join(@RequestBody Member member) {
        log.info("memberAction join 진입 >>> , {}", member);

         int idNum = memberService.create(member);

        return idNum;
    }
}
