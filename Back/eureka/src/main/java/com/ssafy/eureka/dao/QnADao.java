package com.ssafy.eureka.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.eureka.dto.QnA;


@Mapper
public interface QnADao {

	public List<QnA> retrieveQnA();
	public QnA QnADetail(int qna_id);
	public int writeQnA(QnA qna);
	public int modifyQnA(QnA qna);
	public int deleteQnA(int qna_id);
	public int writeComment(QnA qna);
	public int modifyComment(QnA qna);
	public int deleteComment(int qna_id);
}
