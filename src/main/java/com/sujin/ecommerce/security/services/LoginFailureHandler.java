package com.sujin.ecommerce.security.services;

import com.google.gson.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.io.OutputStream;


@Slf4j
@Component
public class LoginFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest req,
                                        HttpServletResponse res,
                                        AuthenticationException execption) throws IOException, ServletException {
        JsonObject json = new JsonObject();

        log.info("req >> {} , {}" , req.getParameter("id"), req.getParameter("password") );

        json.addProperty("result", false);
        json.addProperty("message", "아이디 및 패스워드 확인해주세요!");

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
