package com.sujin.ecommerce.security.services;


import com.google.gson.JsonObject;
import com.sujin.ecommerce.member.service.MemberService;
import com.sujin.ecommerce.member.vo.Member;
import com.sujin.ecommerce.security.jwt.JwtProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;

@Slf4j
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired JwtProvider jwtProvider;
    @Autowired MemberService memberService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest req,
                                        HttpServletResponse res,
                                        Authentication auth) throws IOException, ServletException {
        HttpSession session = req.getSession();

        Member member = memberService.getId(auth.getName());

        if(req.getParameter("loginRememberMe") != null && "on".equals(req.getParameter("loginRememberMe"))){
            log.info("자동로그인 해줘야됨.");
        }else{
            log.info("자동로그인 안해줘야됨.");
        }

        String jwtToken = jwtProvider.generateJwtToken(auth);

        session.setAttribute("member", member);

        JsonObject json = new JsonObject();

        json.addProperty("result", true);
        json.addProperty("token", jwtToken);

        OutputStream out = res.getOutputStream();

        try {
            out.write(json.toString().getBytes());
        }finally {
            if(out != null){
                out.close();
            }
        }

    }
}
