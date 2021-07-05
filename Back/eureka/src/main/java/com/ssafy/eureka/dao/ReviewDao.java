package com.ssafy.eureka.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.eureka.dto.Review;

@Mapper
public interface ReviewDao {

	int registReview(Review review);

	Review getReviewDetail(String review_id);

	List<Review> getReviewList(Map<String,String> map);

	int deleteReview(String review_id);

	int modifyReview(Review review);

	int likedReview(String review_id);

	int setProduct_rating(Review review);

}
