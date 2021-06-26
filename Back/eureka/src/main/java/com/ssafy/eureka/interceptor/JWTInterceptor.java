package com.ssafy.eureka.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ssafy.eureka.dto.Member;
import com.ssafy.eureka.service.JWTService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JWTInterceptor implements HandlerInterceptor {
	
	private static final Logger log = LoggerFactory.getLogger(JWTInterceptor.class);
	
	@Autowired
	private JWTService jwtService;
	
	@Value("${jwt.salt}")
	private String salt;
	
	@Value("${jwt.expmin}")
	private Long expireMin;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println(request.getMethod() + ":" + request.getServletPath());
		
		if(request.getMethod().equals("OPTIONS")) {
			return true;
		}
		else {
			String token = request.getHeader("jwt-auth-access-token");
			System.out.println(token);
			String refreshtoken = request.getHeader("jwt-auth-refresh-token");
			if ((token != null && token.length() > 0)||(refreshtoken != null && refreshtoken.length() > 0)) {
				
				if(jwtService.checkValid(token)) {
					log.trace("토큰 사용 가능:{}", token);
//					response.setHeader("jwt-auth-access-token", token);
					if(!jwtService.checkValid(refreshtoken)) {
						String newtoken = jwtService.createJws(salt, (long)10080, null);
						response.setHeader("jwt-auth-refresh-token", newtoken);
						
					}
					return true;
				}else {
					if(jwtService.checkValid(refreshtoken)) {
						log.trace("토큰 사용 가능:{}", refreshtoken);
//						response.setHeader("jwt-auth-refresh-token", refreshtoken);						
						Member member = jwtService.getMemberByToken(refreshtoken);
						String newtoken = jwtService.createJws(salt, expireMin, member);
						response.setHeader("jwt-auth-access-token", newtoken);
						return true;
					}else {
						throw new RuntimeException("인증토큰이 만료되었습니다.");									
					}
				}
			} else {
				throw new RuntimeException("인증토큰이 없습니다.");
			}
		}
	}
	
	
}
