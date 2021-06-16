package com.ssafy.eureka.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.eureka.dto.Member;

@Mapper
public interface MemberDao {

	public Member login(Map<String,String> map);
	public int joinMember(Member member);
	public int deleteMember(String member_userid);
	public int modifyMember(Member member);
	public int updatePwd(Member member);
	public Member checkInfo(Member member);
	public int setRefreshToken(Map<String,String> map);
	public Member getMemberByToken(String member_refreshtoken);
	public int logout(String member_userid);
}
