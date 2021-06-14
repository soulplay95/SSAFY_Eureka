package com.ssafy.eureka.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.eureka.dto.Product;
import com.ssafy.eureka.service.ProductService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@RequestMapping(value="/product")
public class ProductController {
	
	@Autowired
	ProductService service;
	
	@GetMapping("/search")
	@ApiOperation(value = "검색정보", notes = "미정", response = List.class)
	private ResponseEntity<List<Product>> showSearchResult(@RequestParam String keyword) {
		
		List<Product> list = service.showSearchResult(keyword);
		
		return null;
	}
	
	@GetMapping("/listview/{category}")
	@ApiOperation(value = "카테고리별 상품정보", notes = "미정", response = List.class)
	private ResponseEntity<List<Product>> showItemList(@PathVariable String category) {
		
		List<Product> list = service.showItemList(category);
		
		return null;
	}
	
	@GetMapping("/detailview/{product_id}")
	@ApiOperation(value = "상품상세정보", notes = "상품클릭시 product_id를 전달받아 해당product_id의 ProductDto, Review, Qna반환", response = Map.class)
	private ResponseEntity<Map<String, Object>> showDetail(@PathVariable String product_id) {
		
		Map<String, Object> map = service.showDetail(product_id);
		
		return null;
	}
	
//	판매자 메뉴
	@PostMapping("/regist")
	@ApiOperation(value = "상품등록", notes = "상품등록시 ProductDto를 전달받아 DB에 ProductDto 저장. 리턴값 없음")
	private ResponseEntity<String> registProduct(@RequestBody Product product) {
		
		if(service.registProduct(product) == 1) {};
		
		return null;
	}
	
	@PutMapping("/modify")
	@ApiOperation(value = "상품수정", notes = "상품수정시 ProductDto를 전달받아 해당 product_id의 상품정보를 DB에서 수정. 리턴값 없음")
	private ResponseEntity<String> modifyProduct(@RequestBody Product product) {
		
		if(service.modifyProduct(product) == 1) {};
		
		return null;
	}
	
	@DeleteMapping("/delete/{product_id}")
	@ApiOperation(value = "상품삭제", notes = "상품삭제시 product_id를 전달받아 해당 product_id의 상품정보를 DB에서 삭제. 리턴값 없음")
	private ResponseEntity<String> deleteProduct(@PathVariable String product_id) {
		
		if(service.deleteProduct(product_id) == 1) {};
		
		return null;
	}
	
}
