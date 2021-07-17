package com.ssafy.eureka.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.eureka.dao.QnADao;
import com.ssafy.eureka.dto.QnA;

@Service
public class QnAServiceImpl implements QnAService {
	
	private static final Logger logger = LoggerFactory.getLogger(QnAServiceImpl.class);
	
	@Autowired
	QnADao dao;

	@Override
	public List<QnA> retrieveQnA() {
		logger.debug("retrieveQnA service - 호출 ");
		return dao.retrieveQnA();
	}

	@Override
	public QnA QnADetail(int no) {
		logger.debug("QnADetail service - 호출 ");
		return dao.QnADetail(no);
	}

	@Override
	public int writeQnA(QnA qna) {
		logger.debug("writeQnA service - 호출 ");
		return dao.writeQnA(qna);
	}

	@Override
	public int modifyQnA(QnA qna) {
		logger.debug("modifyQnA service - 호출 ");
		return dao.modifyQnA(qna);
	}

	@Override
	public int deleteQnA(int no) {
		logger.debug("modifyQnA service - 호출 ");
		return dao.deleteQnA(no);
	}

	@Override
	public int writeComment(QnA qna) {
		return dao.writeComment(qna);
	}

	@Override
	public int modifyComment(QnA qna) {
		return dao.modifyComment(qna);
	}

	@Override
	public int deleteComment(int no) {
		return dao.deleteComment(no);
	}

}
