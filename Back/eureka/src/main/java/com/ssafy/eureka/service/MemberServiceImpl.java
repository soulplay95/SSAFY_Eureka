package com.ssafy.eureka.service;

import java.util.Map;

import org.apache.commons.mail.HtmlEmail;
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
	public int joinMember(Member member) {
		return dao.joinMember(member);
	}

	@Override
	public int deleteMember(String member_userid) {
		return dao.deleteMember(member_userid);
	}

	@Override
	public int modifyMember(Member member) {

		return dao.modifyMember(member);
	}

	// 비밀번호 찾기 이메일발송
	@Override
	public void sendEmail(Member member, String div) {
		// Mail Server 설정
		String charSet = "utf-8";
		String hostSMTP = "smtp.gmail.com"; // 네이버 이용시 smtp.naver.com
		String hostSMTPid = "서버 이메일 주소(보내는 사람 이메일 주소)";
		String hostSMTPpwd = "서버 이메일 비번(보내는 사람 이메일 비번)";

		// 보내는 사람 EMail, 제목, 내용
		String fromEmail = "보내는 사람 이메일주소(받는 사람 이메일에 표시됨)";
		String fromName = "프로젝트이름 또는 보내는 사람 이름";
		String subject = "";
		String msg = "";

		if (div.equals("findpw")) {
			subject = "유레카 임시 비밀번호 입니다.";
			msg += "<div align='center' style='border:1px solid black; font-family:verdana'>";
			msg += "<h3 style='color: blue;'>";
			msg += member.getMember_name() + "님의 임시 비밀번호 입니다. 비밀번호를 변경하여 사용하세요.</h3>";
			msg += "<p>임시 비밀번호 : ";
			msg += member.getMember_userpwd() + "</p></div>";
		}

		// 받는 사람 E-Mail 주소
		String mail = member.getMember_userid();
		try {
			HtmlEmail email = new HtmlEmail();
			email.setDebug(true);
			email.setCharset(charSet);
			email.setSSL(true);
			email.setHostName(hostSMTP);
			email.setSmtpPort(465); // 네이버 이용시 587

			email.setAuthentication(hostSMTPid, hostSMTPpwd);
			email.setTLS(true);
			email.addTo(mail, charSet);
			email.setFrom(fromEmail, fromName, charSet);
			email.setSubject(subject);
			email.setHtmlMsg(msg);
			email.send();
		} catch (Exception e) {
			System.out.println("메일발송 실패 : " + e);
		}
	}

	// 비밀번호찾기
	@Override
	public int findPwd(Member member) {
		// 임시 비밀번호 생성
		String pw = "";
		for (int i = 0; i < 12; i++) {
			pw += (char) ((Math.random() * 26) + 97);
		}
		member.setMember_userpwd(pw);
		// 비밀번호 변경
		int cnt = dao.updatePwd(member);
		// 비밀번호 변경 메일 발송
		if(cnt == 1)
			sendEmail(member, "findpw");
		return cnt;
	}

}
