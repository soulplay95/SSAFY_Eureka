package com.ssafy.eureka.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.eureka.dto.QnA;

@Service
public interface QnAService {

	public List<QnA> retrieveQnA();
	public QnA QnADetail(int no);
	public int writeQnA(QnA qna);
	public int modifyQnA(QnA qna);
	public int deleteQnA(int no);
	public int writeComment(QnA qna);
	public int modifyComment(QnA qna);
	public int deleteComment(int no);
}
