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

    /**
    * MemberAction
    *
    * @author sujin
    * @version 1.0.0
    * @dtae 2023-09-14
    *
    **/
    @Autowired MemberService memberService;

    /**
    *
    * method : login
    *
    * @param : -
    * @result : login.htnl
    *
    * @author sujin
    * @version 1.0.0
    * @dtae 2023-09-19
    *
    **/
    @GetMapping(value ="/member/login")
    public String login() {
        return "/member/login.html";
    }

    /**
    *
    * method : login
    *
    * @param : id,pwd
    * @result : seq
    *
    * @author sujin
    * @version 1.0.0
    * @dtae 2023-09-14
    *
    **/
    @PostMapping(value = "member/login")
    @ResponseBody public int login(@RequestBody Member member) {
        //1. 로그인 입력  id, pwd
        log.info("Member.{}}", member);
        //2.(ID중복이 없다느 가정) 같은 아이디를 찾고 , pwd가 일치하는지 확인한다.
        member = memberService.findById(member);

        //3. 일치하면 로그인이 member.seq를 반환, 틀리면 로그인 다시하라고 알람.
        if(member == null){
            log.info("memberAction login 실패! 진입 >>> , {}", member);
            return -1;
        }

        log.info("memberAction login 성공! 진입 >>> , {}", member);

        int seq = member.getSeq();

        return seq;
    }

    /**
    *
    * method : join
    *
    * @param : -
    * @result : join.html
    *
    * @author sujin
    * @version 1.0.0
    * @dtae 2023-09-09
    *
    **/
    @GetMapping(value ="/member/join")
    public String join() {

        return "/member/join.html";
    }

    /**
    *
    * method : join
    *
    * @param : member
    * @result : inNum
    *
    * @author sujin
    * @version 1.0.0
    * @dtae 2023-09-09
    *
    **/
    @PostMapping(value ="/member/join")
    @ResponseBody public int join(@RequestBody Member member) {
        log.info("memberAction join 진입 >>> , {}", member);

         int idNum = memberService.create(member);

        return idNum;
    }
}
