package com.ssafy.eureka.dto;

public class Order {

	int order_id;
	String order_date;
	String order_totalprice;
	String member_userid;
	
	public Order(String order_totalprice, String member_userid) {
		this.order_totalprice = order_totalprice;
		this.member_userid = member_userid;
	}
	
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public String getOrder_totalprice() {
		return order_totalprice;
	}
	public void setOrder_totalprice(String order_totalprice) {
		this.order_totalprice = order_totalprice;
	}
	public String getMember_userid() {
		return member_userid;
	}
	public void setMember_userid(String member_userid) {
		this.member_userid = member_userid;
	}
	
	
}
