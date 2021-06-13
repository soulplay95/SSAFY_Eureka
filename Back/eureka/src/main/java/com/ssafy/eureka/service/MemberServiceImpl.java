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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(String member_userid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyMember(Member member) {
		
		return 0;
	}

	@Override
	public boolean checkInfo(Member member) {
		
		Member checked = dao.checkInfo(member);
		
		if(checked == null) {
			return false;
		} else {
			return true;
		}
		
	}

}
