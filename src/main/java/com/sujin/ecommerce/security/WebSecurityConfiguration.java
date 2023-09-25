package com.sujin.ecommerce.security;

import com.sujin.ecommerce.security.jwt.AuthTokenFilter;
import com.sujin.ecommerce.security.services.LoginFailureHandler;
import com.sujin.ecommerce.security.services.LoginSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.RequestCacheConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {

	@Autowired
	private LoginSuccessHandler loginSuccessHandler;
	@Autowired
	private LoginFailureHandler loginFailureHandler;

	// 비밀번호 인코딩을 위한 빈 등록
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// JWT 토큰 필터 빈 등록
	@Bean
	public AuthTokenFilter authenticationJwtTokenFilter() {
		return new AuthTokenFilter();
	}

	// 보안 필터 체인 설정
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
				.csrf().disable() // CSRF 보호 비활성화
				.httpBasic().disable() // HTTP Basic 인증 비활성화
//				.requestCache(RequestCacheConfigurer::disable) // 요청 캐시 비활성화
				//.exceptionHandling().accessDeniedPage("/error"); // 접근 거부 페이지 설정
		;

		http
				.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

		// Form 로그인 관련 설정
		http
				.formLogin()
				.loginPage("/member/login") // 로그인 페이지 지정
				.usernameParameter("id") // 사용자명 파라미터 지정
				.passwordParameter("password") // 비밀번호 파라미터 지정
				.loginProcessingUrl("/member/login") // 로그인 처리 URL 지정
				.successHandler(loginSuccessHandler) // 로그인 성공 핸들러 지정
				.failureHandler(loginFailureHandler); // 로그인 실패 핸들러 지정

		// Form 로그아웃 설정
		http
				.logout()
//				.logoutUrl("") // 로그아웃 URL 지정
				.logoutSuccessUrl("/member/login"); // 로그아웃 후 이동할 페이지 지정

		// 세션 관리 설정
		http
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.NEVER) // 세션 생성 정책
				.sessionFixation().migrateSession()
				.maximumSessions(1) // 최대 동시 세션 수
				.expiredUrl("/member/login"); // 세션 만료 후 이동할 페이지

		// URL 경로별 권한 설정
//		http
//				.authorizeRequests()
//				.antMatchers("/js/member/**", "/js/common/**", "/css/**", "/favicon.ico")
//				.permitAll()
//				.mvcMatchers("/member/login", "/member/create")
//				.permitAll()
//				.anyRequest().authenticated(); // 모든 요청에 대해 인증 필요
	http.authorizeRequests().anyRequest().permitAll();

		return http.build();
	}
}
