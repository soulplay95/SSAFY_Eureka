package com.ssafy.eureka.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.eureka.dao.MemberDao;
import com.ssafy.eureka.dto.Member;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao dao;
	
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
		return dao.joinMember(member);
	}

	@Override
	public int deleteMember(String member_userid) {
		return dao.deleteMember(member_userid);
	}

	@Override
	public Member modifyMember(Member member) {
		// TODO Auto-generated method stub
		return null;
	}

}
