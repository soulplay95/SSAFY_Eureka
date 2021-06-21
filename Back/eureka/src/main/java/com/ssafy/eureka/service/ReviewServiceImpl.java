package com.ssafy.eureka.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.eureka.dao.ReviewDao;
import com.ssafy.eureka.dto.Review;

@Service
public class ReviewServiceImpl implements ReviewService {

	private static final Logger logger = LoggerFactory.getLogger(ReviewServiceImpl.class);
	@Autowired
	ReviewDao dao;
	
	@Override
	public int registReview(Review review) {
		logger.debug("registReview service - 호출 ");
		return dao.registReview(review);
	}

	@Override
	public Review getReview(String review_id) {
		logger.debug("getReview service - 호출 ");
		return dao.getReviewDetail(review_id);
	}

	@Override
	public List<Review> getReviewList(Map<String,String> map) {
		logger.debug("getReviewList service - 호출 ");
		return dao.getReviewList(map);
	}

	@Override
	public int deleteReview(String review_id) {
		logger.debug("deleteReview service - 호출 ");
		return dao.deleteReview(review_id);
	}

	@Override
	public int modifyReview(Review review) {
		logger.debug("modifyReview service - 호출 ");
		return dao.modifyReview(review);
	}

	@Override
	public int likedReview(String review_id) {
		logger.debug("likedReview service - 호출 ");
		return dao.likedReview(review_id);
	}


}
