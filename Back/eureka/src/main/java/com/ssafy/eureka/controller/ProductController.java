package com.ssafy.eureka.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@RequestMapping(value="/product")
public class ProductController {
	
	@GetMapping("/search")
	@ApiOperation(value = "검색정보", notes = "미정", response = Object.class)
	private ResponseEntity<Object> showSearchResult(@RequestParam String keyword) {
		
		return null;
	}
	
	@GetMapping("/listview")
	@ApiOperation(value = "카테고리별 상품정보", notes = "미정", response = Object.class)
	private ResponseEntity<Object> showItemList() {
		
		return null;
	}
	
	@GetMapping("/detailview")
	@ApiOperation(value = "상품상세정보", notes = "상품클릭시 product_id를 전달받아 해당product_id의 ProductDto, Review, Qna반환", response = Object.class)
	private ResponseEntity<Object> showDetail(@RequestParam String product_id) {
		
		return null;
	}
	
//	판매자 메뉴
	@PostMapping("/regist")
	@ApiOperation(value = "상품등록", notes = "상품등록시 ProductDto를 전달받아 DB에 ProductDto 저장. 리턴값 없음", response = Object.class)
	private ResponseEntity<Object> registProduct(@RequestBody Object obj) {
		
		return null;
	}
	
	@PutMapping("/modify")
	@ApiOperation(value = "상품수정", notes = "상품수정시 ProductDto를 전달받아 해당 product_id의 상품정보를 DB에서 수정. 리턴값 없음", response = Object.class)
	private ResponseEntity<Object> modifyProduct(@RequestBody Object obj) {
		
		return null;
	}
	
	@DeleteMapping("/delete")
	@ApiOperation(value = "상품삭제", notes = "상품삭제시 product_id를 전달받아 해당 product_id의 상품정보를 DB에서 삭제. 리턴값 없음", response = Object.class)
	private ResponseEntity<Object> deleteProduct(@RequestParam String product_id) {
		
		return null;
	}
	
}
