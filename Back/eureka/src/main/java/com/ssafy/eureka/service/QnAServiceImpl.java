package com.ssafy.eureka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.eureka.dao.QnADao;
import com.ssafy.eureka.dto.QnA;

@Service
public class QnAServiceImpl implements QnAService {
	
	@Autowired
	QnADao dao;

	@Override
	public List<QnA> retrieveQnA() {
		return null;
	}

	@Override
	public QnA QnADetail() {
		return null;
	}

	@Override
	public int writeQnA() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyQnA() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteQnA() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int writeComment() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateComment() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteComment() {
		// TODO Auto-generated method stub
		return 0;
	}

}
