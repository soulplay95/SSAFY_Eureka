package com.ssafy.eureka.dto;

public class Cart {
	
	int cart_id;
	int product_id;
	String member_userid;
	int quantity;
	
	public Cart(int cart_id, int product_id, String member_userid,int quantity) {
		super();
		this.cart_id = cart_id;
		this.product_id = product_id;
		this.member_userid = member_userid;
		this.quantity = quantity;
	}
	
	public Cart() {
		super();
	}
	
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Cart [cart_id=" + cart_id + ", product_id=" + product_id + ", member_userid=" + member_userid + "]";
	}
	
	
}
