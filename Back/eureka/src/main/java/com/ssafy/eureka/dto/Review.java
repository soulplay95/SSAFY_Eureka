package com.ssafy.eureka.dto;

public class Review {
	
	int review_id;
	String review_title;
	String review_content;
	String review_rating;
	String review_date;
	String review_liked;
	String review_img;
	String member_userid;
	String product_id;
	
	public Review(int review_id, String review_title, String review_content, String review_rating, String review_date,
			String review_liked, String review_img, String member_userid, String product_id) {
		super();
		this.review_id = review_id;
		this.review_title = review_title;
		this.review_content = review_content;
		this.review_rating = review_rating;
		this.review_date = review_date;
		this.review_liked = review_liked;
		this.review_img = review_img;
		this.member_userid = member_userid;
		this.product_id = product_id;
	}
	
	public Review() {
		super();
	}
	
	public int getReview_id() {
		return review_id;
	}
	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}
	public String getReview_title() {
		return review_title;
	}
	public void setReview_title(String review_title) {
		this.review_title = review_title;
	}
	public String getReview_content() {
		return review_content;
	}
	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}
	public String getReview_rating() {
		return review_rating;
	}
	public void setReview_rating(String review_rating) {
		this.review_rating = review_rating;
	}
	public String getReview_date() {
		return review_date;
	}
	public void setReview_date(String review_date) {
		this.review_date = review_date;
	}
	public String getReview_liked() {
		return review_liked;
	}
	public void setReview_liked(String review_liked) {
		this.review_liked = review_liked;
	}
	public String getReview_img() {
		return review_img;
	}
	public void setReview_img(String review_img) {
		this.review_img = review_img;
	}
	public String getMember_userid() {
		return member_userid;
	}
	public void setMember_userid(String member_userid) {
		this.member_userid = member_userid;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	@Override
	public String toString() {
		return "Review [review_id=" + review_id + ", review_title=" + review_title + ", review_content="
				+ review_content + ", review_rating=" + review_rating + ", review_date=" + review_date
				+ ", review_liked=" + review_liked + ", review_img=" + review_img + ", member_userid=" + member_userid
				+ ", product_id=" + product_id + "]";
	}

	

}
