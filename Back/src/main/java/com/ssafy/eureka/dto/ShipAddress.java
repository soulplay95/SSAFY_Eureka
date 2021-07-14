package com.ssafy.eureka.dto;

public class ShipAddress {
	int shipaddress_id;
	String shipaddress_nickname;
	String shipaddress_addr;
	String shipaddress_phone;
	String shipaddress_request;
	int shipaddress_type;
	String member_userid;
	public int getShipaddress_id() {
		return shipaddress_id;
	}
	public void setShipaddress_id(int shipaddress_id) {
		this.shipaddress_id = shipaddress_id;
	}
	public String getShipaddress_nickname() {
		return shipaddress_nickname;
	}
	public void setShipaddress_nickname(String shipaddress_nickname) {
		this.shipaddress_nickname = shipaddress_nickname;
	}
	public String getShipaddress_addr() {
		return shipaddress_addr;
	}
	public void setShipaddress_addr(String shipaddress_addr) {
		this.shipaddress_addr = shipaddress_addr;
	}
	public String getShipaddress_phone() {
		return shipaddress_phone;
	}
	public void setShipaddress_phone(String shipaddress_phone) {
		this.shipaddress_phone = shipaddress_phone;
	}
	public String getShipaddress_request() {
		return shipaddress_request;
	}
	public void setShipaddress_request(String shipaddress_request) {
		this.shipaddress_request = shipaddress_request;
	}
	public int getShipaddress_type() {
		return shipaddress_type;
	}
	public void setShipaddress_type(int shipaddress_type) {
		this.shipaddress_type = shipaddress_type;
	}
	public String getMember_userid() {
		return member_userid;
	}
	public void setMember_userid(String member_userid) {
		this.member_userid = member_userid;
	}
	@Override
	public String toString() {
		return "ShipAddress [shipaddress_id=" + shipaddress_id + ", shipaddress_nickname=" + shipaddress_nickname
				+ ", shipaddress_addr=" + shipaddress_addr + ", shipaddress_phone=" + shipaddress_phone
				+ ", shipaddress_request=" + shipaddress_request + ", shipaddress_type=" + shipaddress_type
				+ ", member_userid=" + member_userid + "]";
	}
	
}
