package com.ssafy.eureka.service;

import java.util.Map;


import com.ssafy.eureka.dto.Member;

public interface MemberService {

	public Member login(Map<String, String> map);
	public String getMemberInfo();
	public int joinMember(Member member);
	public int deleteMember(String member_userid);
	public int logout(String member_userid);
	public int modifyMember(Member member);
	//이메일발송
	public void sendEmail(Member member, String div);
	//비밀번호찾기
	public int findPwd(Member member);
	public boolean checkInfo(Member member);
	public int modifyPwd(Map<String, String> map);
}
