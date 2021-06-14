package com.ssafy.eureka.dto;

public class Wish {
	int wish_id;
	int product_id;
	String member_userid;
	
	public Wish(int wish_id, int product_id, String member_userid) {
		super();
		this.wish_id = wish_id;
		this.product_id = product_id;
		this.member_userid = member_userid;
	}
	
	public Wish() {
		super();
	}
	
	public int getWish_id() {
		return wish_id;
	}
	public void setWish_id(int wish_id) {
		this.wish_id = wish_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getMember_userid() {
		return member_userid;
	}
	public void setMember_userid(String member_userid) {
		this.member_userid = member_userid;
	}

	@Override
	public String toString() {
		return "Wish [wish_id=" + wish_id + ", product_id=" + product_id + ", member_userid=" + member_userid + "]";
	}
	
}
