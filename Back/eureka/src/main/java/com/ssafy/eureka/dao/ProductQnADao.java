package com.ssafy.eureka.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.eureka.dto.Productqna;
import com.ssafy.eureka.dto.QnA;


@Mapper
public interface ProductQnADao {

	public List<Productqna> retrieveQnA();
	public Productqna QnADetail(int pqna_id);
	public int writeQnA(Productqna productqna);
	public int modifyQnA(Productqna productqna);
	public int deleteQnA(int pqna_id);
	public int writeComment(Productqna productqna);
	public int modifyComment(Productqna productqna);
	public int deleteComment(int pqna_id);
}
