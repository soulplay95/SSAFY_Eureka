package com.ssafy.eureka.dto;

public class Productqna {
	
	int pqna_id;
	String pqna_qtitle;
	String pqna_qcontent;
	String pqna_acontent;
	String pqna_qdate;
	String pqna_adate;
	String member_userid;
	String product_id;
	
	public Productqna(int pqna_id, String pqna_qtitle, String pqna_qcontent, String pqna_acontent, String pqna_qdate,
			String pqna_adate, String member_userid, String product_id) {
		super();
		this.pqna_id = pqna_id;
		this.pqna_qtitle = pqna_qtitle;
		this.pqna_qcontent = pqna_qcontent;
		this.pqna_acontent = pqna_acontent;
		this.pqna_qdate = pqna_qdate;
		this.pqna_adate = pqna_adate;
		this.member_userid = member_userid;
		this.product_id = product_id;
	}
	public Productqna() {
		super();
	}
	
	public int getPqna_id() {
		return pqna_id;
	}
	public void setPqna_id(int pqna_id) {
		this.pqna_id = pqna_id;
	}
	public String getPqna_qtitle() {
		return pqna_qtitle;
	}
	public void setPqna_qtitle(String pqna_qtitle) {
		this.pqna_qtitle = pqna_qtitle;
	}
	public String getPqna_qcontent() {
		return pqna_qcontent;
	}
	public void setPqna_qcontent(String pqna_qcontent) {
		this.pqna_qcontent = pqna_qcontent;
	}
	public String getPqna_acontent() {
		return pqna_acontent;
	}
	public void setPqna_acontent(String pqna_acontent) {
		this.pqna_acontent = pqna_acontent;
	}
	public String getPqna_qdate() {
		return pqna_qdate;
	}
	public void setPqna_qdate(String pqna_qdate) {
		this.pqna_qdate = pqna_qdate;
	}
	public String getPqna_adate() {
		return pqna_adate;
	}
	public void setPqna_adate(String pqna_adate) {
		this.pqna_adate = pqna_adate;
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
		return "Productqna [pqna_id=" + pqna_id + ", pqna_qtitle=" + pqna_qtitle + ", pqna_qcontent=" + pqna_qcontent
				+ ", pqna_acontent=" + pqna_acontent + ", pqna_qdate=" + pqna_qdate + ", pqna_adate=" + pqna_adate
				+ ", member_userid=" + member_userid + ", product_id=" + product_id + "]";
	}
	
	
}
