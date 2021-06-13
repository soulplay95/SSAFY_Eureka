package com.ssafy.eureka.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.eureka.dto.Member;

public interface MemberService {

	public Member login(Map<String, String> map);
	public String getServerInfo();
	public String findPwd(Map<String, String> map);
	public int joinMember(Member member);
	public int deleteMember(String member_userid);
	public Member modifyMember(Member member);
}
