package com.ssafy.eureka.service;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssafy.eureka.dto.Member;

public class MemberServiceImpl implements MemberService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public Member login(Map<String, String> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServerInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findPwd(Map<String, String> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int joinMember(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(String member_userid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Member modifyMember(Member member) {
		// TODO Auto-generated method stub
		return null;
	}

}
