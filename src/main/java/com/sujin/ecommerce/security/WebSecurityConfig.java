package com.sujin.ecommerce.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // 1. HTTP 요청에 대한 권한 설정
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/member/join").permitAll() // 루트 ("/")와 "/home" 경로에 대한 모든 사용자의 접근을 허용
                        .anyRequest().authenticated() // 그 외 모든 요청에 대해 인증을 필요로 함
                )
                // 2. 로그인 설정
                .formLogin((form) -> form
                        .loginPage("/login") // 로그인 페이지를 "/login"으로 설정
                        .permitAll() // 로그인 페이지에 대한 접근을 모든 사용자에게 허용
                )
                // 3. 로그아웃 설정
                .logout((logout) -> logout.permitAll()); // 로그아웃을 모든 사용자에게 허용

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // 4. 사용자 정보를 메모리에 저장하는 InMemoryUserDetailsManager 생성
        UserDetails user =
                User.withDefaultPasswordEncoder() // 패스워드 인코딩 방식을 사용하여 사용자 생성
                        .username("user") // 사용자 이름 설정
                        .password("password") // 사용자 비밀번호 설정
                        .roles("USER") // 사용자 역할 설정 (여기서는 "USER")
                        .build();

        return new InMemoryUserDetailsManager(user); // 사용자 정보를 메모리에 저장하고 관리하는 서비스 반환
    }

}
