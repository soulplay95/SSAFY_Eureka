package com.ssafy.eureka.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.eureka.dto.Review;

@Service
public interface ReviewService {

	int registReview(Review review);

	List<Review> getReviewList(Map<String,String> map);

	int deleteReview(String review_id);

	int modifyReview(Review review);

	Review getReview(String review_id);

	int likedReview(String review_id);

}
