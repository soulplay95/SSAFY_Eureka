package com.ssafy.eureka.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.eureka.dto.Product;
import com.ssafy.eureka.dto.Review;
import com.ssafy.eureka.service.ReviewService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@RequestMapping(value="/review")
public class ReviewController {

	private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);
	//logger.debug("join - 호출");
	
	@Autowired
	private ReviewService service;
	
	@PostMapping
	@ApiOperation(value = "리뷰등록", notes = "리뷰 객체 전달 받아 저장한다.")
	private ResponseEntity<String> registReview(@RequestBody Review review){
		logger.debug("regist Review - 호출  : " + review.toString());
		
		if(service.registReview(review) == 1) {
			return new ResponseEntity<String>(HttpStatus.OK);
		};
		
		return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("{review_id}")
	@ApiOperation(value = "상세리뷰", notes = "review_id 전달받아 해당하는 review 객체를 반환한다.")
	private ResponseEntity<Review> getReview(@PathVariable String review_id){
		logger.debug("getReview 호출 : " + review_id);
		
		Review review = service.getReview(review_id);
		return new ResponseEntity<Review>(review, HttpStatus.OK);
		
	}
	
	@PostMapping("/list")
	@ApiOperation(value = "리뷰 리스트", notes = "product_id, orderbycol, isAsc를  Map 형태로 전달받아 해당 product_id의 review객체들을 리스트 형식으로 반환한다.")
	private ResponseEntity<List<Review>> getReviewList(@RequestBody Map<String, String> map){
		logger.debug("getReviewList 호출 : ");
		List<Review> list = service.getReviewList(map);
		return new ResponseEntity<List<Review>>(list, HttpStatus.OK);
		
	}
	
	@PutMapping
	@ApiOperation(value = "리뷰수정", notes = "리뷰 객체 전달 받아 해당 review_id의 review를 수정한다.")
	private ResponseEntity<String> modifyReview(@RequestBody Review review){
		logger.debug("modifyReview - 호출  : " + review.toString());
		
		if(service.modifyReview(review) == 1) {
			return new ResponseEntity<String>(HttpStatus.OK);
		};
		
		return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
	@DeleteMapping("/{review_id}")
	@ApiOperation(value = "리뷰 삭제", notes = "review_id 전달받아 해당 review객체를 삭제한다.")
	private ResponseEntity<String> deleteReview(@PathVariable String review_id){
		logger.debug("deleteReivew 호출 : " + review_id);
		
		if(service.deleteReview(review_id) == 1) {
			return new ResponseEntity<String>(HttpStatus.OK);
		};
		return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@PutMapping("{review_id}")
	@ApiOperation(value = "리뷰수정", notes = "review_id 전달받아 해당 review의 liked를 1 올린다.")
	private ResponseEntity<String> likedReview(@PathVariable String review_id){
		logger.debug("likedReview - 호출  : " + review_id);
		
		if(service.likedReview(review_id) == 1) {
			return new ResponseEntity<String>(HttpStatus.OK);
		};
		
		return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
