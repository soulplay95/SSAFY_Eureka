package com.ssafy.eureka.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.eureka.dto.Product;
import com.ssafy.eureka.service.HomeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/home")
@Api(value = "eureka")
public class HomeController {

	@Autowired
	HomeService service;

	@ApiOperation(value = "랜덤 카테고리 판매순 추천 리스트", notes = "2depth 카테고리중 판매량이 높은 상품을 n개 반환", response = List.class)
	@GetMapping("/recommend/{n}")
	public ResponseEntity<List<Product>> topN(@PathVariable String n) throws Exception {

		double dValue = Math.random();
//		int randValue = (int)dValue*10;
		int randValue = 41;
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("n", Integer.parseInt(n));
		map.put("randValue", randValue);
		
		try {
			List<Product> list = service.getRandomTopProductsByCategory(map);
			return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
}
