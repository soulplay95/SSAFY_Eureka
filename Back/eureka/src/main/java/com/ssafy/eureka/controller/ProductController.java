package com.ssafy.eureka.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@RequestMapping(value="/product")
public class ProductController {
	
	@GetMapping("/detailview")
	@ApiOperation(value = "상품상세정보 페이지", notes = "상품클릭시 상세정보를 보여줌", response = Object.class)
	private ResponseEntity<Object> showDetail(@RequestParam String product_id) {
		
		Object obj = null;
		int a= 0;
		if(a == 1) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		
		return new ResponseEntity<Object>(obj, HttpStatus.OK);
	}
	
}
