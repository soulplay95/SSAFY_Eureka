package com.ssafy.eureka.service;

import java.util.List;

import com.ssafy.eureka.dto.QnA;

public interface QnAService {

	public List<QnA> retrieveQnA();
	public QnA QnADetail();
	public int writeQnA();
	public int modifyQnA();
	public int deleteQnA();
	
	public int writeComment();
	public int updateComment();
	public int deleteComment();
}
