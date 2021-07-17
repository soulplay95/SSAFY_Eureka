package com.ssafy.eureka.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.eureka.dao.ProductQnADao;
import com.ssafy.eureka.dao.QnADao;
import com.ssafy.eureka.dto.Productqna;
import com.ssafy.eureka.dto.QnA;

@Service
public class ProductQnAServiceImpl implements ProductQnAService {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductQnAServiceImpl.class);
	
	@Autowired
	ProductQnADao dao;

	@Override
	public List<Productqna> retrieveQnA() {
		logger.debug("retrieveQnA service - 호출 ");
		return dao.retrieveQnA();
	}

	@Override
	public Productqna QnADetail(int no) {
		logger.debug("QnADetail service - 호출 ");
		return dao.QnADetail(no);
	}

	@Override
	public int writeQnA(Productqna qna) {
		logger.debug("writeQnA service - 호출 ");
		return dao.writeQnA(qna);
	}

	@Override
	public int modifyQnA(Productqna qna) {
		logger.debug("modifyQnA service - 호출 ");
		return dao.modifyQnA(qna);
	}

	@Override
	public int deleteQnA(int no) {
		logger.debug("modifyQnA service - 호출 ");
		return dao.deleteQnA(no);
	}

	@Override
	public int writeComment(Productqna qna) {
		return dao.writeComment(qna);
	}

	@Override
	public int modifyComment(Productqna qna) {
		return dao.modifyComment(qna);
	}

	@Override
	public int deleteComment(int no) {
		return dao.deleteComment(no);
	}

}
