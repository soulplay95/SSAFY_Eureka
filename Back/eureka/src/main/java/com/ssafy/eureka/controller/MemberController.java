package com.ssafy.eureka.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.eureka.dto.Member;
import com.ssafy.eureka.dto.Token;
import com.ssafy.eureka.service.JWTService;
import com.ssafy.eureka.service.MemberService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@Slf4j
@RestController
@RequestMapping("/member")
@Api(value = "eureka")
public class MemberController {
	
	@Autowired
	MemberService service;
	
	@Autowired
	private JWTService jwtService;
	
	@ApiOperation(value = "로그인", notes = "로그인 합니다.")
	@PostMapping("/login")
	public ResponseEntity<Map<String,Object>> memberLogin(@RequestBody Member member, HttpServletResponse res){
		Map<String,Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		Map<String, String> map = new HashMap<String, String>();
		map.put("member_userid", member.getMember_userid());
		map.put("member_userpwd", member.getMember_userpwd());
		try {
			
			Member loginUser = service.login(map);
			Token token = jwtService.create(loginUser);
			res.setHeader("jwt-auth-access-token", token.getAccessJws());
			res.setHeader("jwt-auth-refresh-token", token.getRefreshJws());
			resultMap.put("auth_token", token);
			System.out.println(token);
			
			resultMap.put("status", true);
			resultMap.put("data", loginUser);
			status = HttpStatus.ACCEPTED;
		}catch(RuntimeException e) {
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String,Object>>(resultMap, status);
	}
	
	@ApiOperation(value = "로그아웃", notes = "해당 아이디의 정보로 로그아웃 합니다.")
	@GetMapping("/{userid}")
	private ResponseEntity<String> logout(@PathVariable("userid") String userid) {
		if(service.logout(userid) == 1) {
			return new ResponseEntity<String>(HttpStatus.OK);
		}else {
			return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		}
	}
	
//	@ApiOperation(value = "회원 조회", notes = "해당 회원의 정보를 반환합니다.")
//	@PostMapping("/info")
//	public ResponseEntity<Map<String,Object>> memberInfo(HttpServletRequest req, @RequestBody Member member){
//		Map<String,Object> resultMap = new HashMap<>();
//		HttpStatus status = null;
//		try {
//			String info = service.getServerInfo();
//			resultMap.putAll(jwtService.get(req.getHeader("jwt-auth-token")));
//			
//			resultMap.put("status", true);
//			resultMap.put("info", info);
//			resultMap.put("request_body", member);
//			status = HttpStatus.ACCEPTED;
//		}catch(RuntimeException e) {
//			resultMap.put("message", e.getMessage());
//			status = HttpStatus.INTERNAL_SERVER_ERROR;
//		}
//		return new ResponseEntity<Map<String,Object>>(resultMap, status);
//	}


//	@ApiOperation(value = "회원 조회", notes = "해당 회원의 정보를 반환합니다.")
//	@GetMapping("/{userid}")
//	private ResponseEntity<Member> memberInfo(@PathVariable("userid") Member member) {
//		return null;
//	
//	}
	
	
	
	@ApiOperation(value = "비밀번호 찾기", notes = "이메일로 비밀번호를 찾습니다.")
	@PostMapping("/findpwd")
	private ResponseEntity<Object> findPwd(@RequestBody Member member) {
		
		if(service.checkInfo(member)) {
			if(service.findPwd(member) == 1) {
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		} else {
			return new ResponseEntity<Object>("회원정보가 존재하지 않습니다.", HttpStatus.NO_CONTENT);
		}
		
	}

	@ApiOperation(value = "회원 등록", notes = "입력한 회원 정보를 등록합니다.")
	@PostMapping
	private ResponseEntity<String> memberJoin(@RequestBody Member member) {
		if(service.joinMember(member) == 1) {
			return new ResponseEntity<String>(HttpStatus.OK);
		}else {
			return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		}
	}

	@ApiOperation(value = "회원 삭제", notes = "해당 회원의 정보를 삭제합니다.")
	@DeleteMapping("/{userid}")
	private ResponseEntity<String> memberDelete(@PathVariable("userid") String userid) {
		if(service.deleteMember(userid) == 1) {
			return new ResponseEntity<String>(HttpStatus.OK);
		}else {
			return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		}
	}

	@ApiOperation(value = "회원 수정", notes = "입력된 회원 정보로 수정합니다.", response = Member.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "회원 수정 OK"), @ApiResponse(code = 500, message = "서버 에러"),
			@ApiResponse(code = 404, message = "페이지 없어") })
	@PutMapping
	private ResponseEntity<Member> memberModify(@RequestBody Member member) {
		
		if(service.modifyMember(member) == 1) {
			return new ResponseEntity<Member>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Member>(HttpStatus.NO_CONTENT);
		}
		
	}
	

}
