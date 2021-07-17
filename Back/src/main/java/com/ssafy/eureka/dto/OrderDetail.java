package com.ssafy.eureka.dto;

public class OrderDetail {

	int orderdetail_id;
	String orderdetail_count;
	String orderdetail_state;
	String orderdetail_price;
	int product_id;
	int order_id;
	
	public int getOrderdetail_id() {
		return orderdetail_id;
	}
	public void setOrderdetail_id(int orderdetail_id) {
		this.orderdetail_id = orderdetail_id;
	}
	public String getOrderdetail_count() {
		return orderdetail_count;
	}
	public void setOrderdetail_count(String orderdetail_count) {
		this.orderdetail_count = orderdetail_count;
	}
	public String getOrderdetail_price() {
		return orderdetail_price;
	}
	public void setOrderdetail_price(String orderdetail_price) {
		this.orderdetail_price = orderdetail_price;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getOrderdetail_state() {
		return orderdetail_state;
	}
	public void setOrderdetail_state(String orderdetail_state) {
		this.orderdetail_state = orderdetail_state;
	}
	
	
}
