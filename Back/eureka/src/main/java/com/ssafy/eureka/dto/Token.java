package com.ssafy.eureka.dto;

public class Token {
	private String accessJws;
	private String refreshJws;
	public String getAccessJws() {
		return accessJws;
	}
	public void setAccessJws(String accessJws) {
		this.accessJws = accessJws;
	}
	public String getRefreshJws() {
		return refreshJws;
	}
	public void setRefreshJws(String refreshJws) {
		this.refreshJws = refreshJws;
	}
	
	
}
