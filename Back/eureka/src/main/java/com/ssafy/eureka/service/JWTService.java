package com.ssafy.eureka.service;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ssafy.eureka.dao.MemberDao;
import com.ssafy.eureka.dto.Member;
import com.ssafy.eureka.dto.Token;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JWTService {

	private static final Logger log = LoggerFactory.getLogger(JWTService.class);
	
	@Value("${jwt.salt}")
	private String salt;
	
	@Value("${jwt.expmin}")
	private Long expireMin;
	
	@Autowired
	private MemberDao dao;
	
	
public Token create(Member userInfo) {
		
		// Create Access Token
		String accessJws = createJws(salt, expireMin, userInfo);
		
		// Create Refresh Token
		String refreshJws = createJws("MYSALT", (long)10080, null);
		
		Token tokens = new Token();
		tokens.setAccessJws(accessJws);
		tokens.setRefreshJws(refreshJws);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("member_refreshtoken", refreshJws);
		map.put("member_userid", userInfo.getMember_userid());
		dao.setRefreshToken(map);
		
		return tokens;
        
	}
	
	public String createJws(String encodekey, Long expMin, final Member member) {
		log.trace("time:{}", expMin);
		JwtBuilder builder = Jwts.builder();
		
		builder.setHeaderParam("typ","JWT");
		
		builder.setSubject("로그인토큰")
		.setExpiration(new Date(System.currentTimeMillis() + 1000*60*expMin))
		.claim("Member", member);
		
		builder.signWith(SignatureAlgorithm.HS256, salt.getBytes());
		
		final String jwt = builder.compact();
		log.debug("토큰 발행:{}",jwt);
		
		return jwt;
	}
	
	public boolean checkValid(final String jwt) {
		log.trace("토큰 점검:{}", jwt);
		try {
		      Jws<Claims> claims = Jwts.parser().setSigningKey(salt.getBytes()).parseClaimsJws(jwt);
		      System.out.println(claims.getBody().get("Member"));
		      return !claims.getBody().getExpiration().before(new Date());
		    } catch (Exception e) {
		      return false;
		    }
	}
	
	public Map<String, Object> get(final String jwt){
		Jws<Claims> claims = null;
		try {
			claims = Jwts.parser().setSigningKey(salt.getBytes()).parseClaimsJws(jwt);
		}catch(final Exception e) {
			throw new RuntimeException();
		}
		
		log.trace("claims:{}", claims);
		return claims.getBody();
	}

	public Member getMemberByToken(String refreshtoken) {
		return dao.getMemberByToken(refreshtoken);
	}
}
