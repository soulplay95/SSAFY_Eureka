package com.ssafy.eureka.dao;

import java.util.List;

import com.ssafy.eureka.dto.QnA;

public interface QnADao {

	public QnA retrieveQnA();
	public QnA QnADetail();
	public int writeQnA();
	public int modifyQnA();
	public int deleteQnA();
	
	public int writeComment();
	public int updateComment();
	public int deleteComment();
}
