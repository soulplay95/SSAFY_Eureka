package com.ssafy.eureka.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.eureka.dto.Productqna;
import com.ssafy.eureka.dto.QnA;

@Service
public interface ProductQnAService {

	public List<Productqna> retrieveQnA();
	public Productqna QnADetail(int no);
	public int writeQnA(Productqna qna);
	public int modifyQnA(Productqna qna);
	public int deleteQnA(int no);
	public int writeComment(Productqna qna);
	public int modifyComment(Productqna qna);
	public int deleteComment(int no);
}
