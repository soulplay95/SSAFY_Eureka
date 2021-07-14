package com.ssafy.eureka.dto;

public class Product {
	int product_id;
	String product_name;
	String product_category;
	String product_price;
	String product_discount;
	String product_img;
	String product_rating;
	String product_brand;
	String product_deliveryprice;
	String product_detailimg;
	String product_count;
	String seller_name;
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_category() {
		return product_category;
	}
	public void setProduct_category(String product_category) {
		this.product_category = product_category;
	}
	public String getProduct_price() {
		return product_price;
	}
	public void setProduct_price(String product_price) {
		this.product_price = product_price;
	}
	public String getProduct_discount() {
		return product_discount;
	}
	public void setProduct_discount(String product_discount) {
		this.product_discount = product_discount;
	}
	public String getProduct_img() {
		return product_img;
	}
	public void setProduct_img(String product_img) {
		this.product_img = product_img;
	}
	public String getProduct_rating() {
		return product_rating;
	}
	public void setProduct_rating(String product_rating) {
		this.product_rating = product_rating;
	}
	public String getProduct_brand() {
		return product_brand;
	}
	public void setProduct_brand(String product_brand) {
		this.product_brand = product_brand;
	}
	public String getProduct_deliveryprice() {
		return product_deliveryprice;
	}
	public void setProduct_deliveryprice(String product_deliveryprice) {
		this.product_deliveryprice = product_deliveryprice;
	}
	public String getProduct_detailimg() {
		return product_detailimg;
	}
	public void setProduct_detailimg(String product_detailimg) {
		this.product_detailimg = product_detailimg;
	}
	public String getProduct_count() {
		return product_count;
	}
	public void setProduct_count(String product_count) {
		this.product_count = product_count;
	}
	public String getSeller_name() {
		return seller_name;
	}
	public void setSeller_name(String seller_name) {
		this.seller_name = seller_name;
	}
	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", product_name=" + product_name + ", product_category="
				+ product_category + ", product_price=" + product_price + ", product_discount=" + product_discount
				+ ", product_img=" + product_img + ", product_rating=" + product_rating + ", product_brand="
				+ product_brand + ", product_deliveryprice=" + product_deliveryprice + ", product_detailimg="
				+ product_detailimg + ", product_count=" + product_count + ", seller_name=" + seller_name + "]";
	}
	
	
	
	
}
