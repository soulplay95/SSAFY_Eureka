package com.ssafy.eureka.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.eureka.dto.QnA;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/")
@Api(value = "eureka")
public class HomeController {

	 @ApiOperation(value ="판매순 추천 리스트", notes = "판매량이 높은 상품을 n개 반환", response = List.class)
		@GetMapping
		public ResponseEntity<List<Object>> topN() throws Exception {
			return null;
		}
}
