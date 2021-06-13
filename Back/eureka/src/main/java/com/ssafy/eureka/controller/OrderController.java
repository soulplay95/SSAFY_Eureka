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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.eureka.dto.Order;
import com.ssafy.eureka.service.OrderService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
public class OrderController {
	
	@Autowired
	OrderService service;
	
	@GetMapping("/order/list/{Member_userid}")
	@ApiOperation(value = "주문목록 조회", notes = "Member_userid를 전달받아 주문 목록을 반환", response = List.class)
	private ResponseEntity<List<Order>> showOrderList(@PathVariable String member_userid) {
		
		List<Order> list = service.showOrderList(member_userid);
		
		return null;
	}
	
	@PostMapping("/order")
	@ApiOperation(value = "주문 추가", notes = "Member_userid, List<ProductDto>를 전달받아 주문 추가. 리턴값 없음")
	private ResponseEntity<String> addOrder(@RequestBody Map<String, Object> map) {
		
		if(service.addOrder(map) == 1) {}
		
		return null;
	}
	
	@DeleteMapping("/order/cancle")
	@ApiOperation(value = "주문목록 삭제", notes = "Member_userid, product_id를 전달받아 주문 정보를 DB에서 삭제")
	private ResponseEntity<String> showOrderList(@RequestParam String member_userid, @RequestParam String product_id) {
		
		if(service.showOrderList(member_userid, product_id) == 1) {}
		
		return null;
	}
	
	@PostMapping("/cart/add")
	@ApiOperation(value = "장바구니 추가", notes = "product_id, Member_userid를 전달받아 장바구니테이블에 저장")
	private ResponseEntity<String> addCart(@RequestBody Map<String, String> map) {
		
		if(service.addCart(map) == 1) {}
		
		return null;
	}
	
	@DeleteMapping("/cart/delete")
	@ApiOperation(value = "장바구니 삭제", notes = "Member_userid, product_id를 전달받아 장바구니 정보를 DB에서 삭제. 리턴값 없음")
	private ResponseEntity<String> deleteCart(@RequestParam String member_userid, @RequestParam String product_id) {
		
		if(service.deleteCart(member_userid, product_id) == 1) {}
		
		return null;
	}
	
	@PostMapping("/wish/add")
	@ApiOperation(value = "찜목록 추가", notes = "product_id, Member_userid를 전달받아 Wish테이블에 저장")
	private ResponseEntity<String> addWish(@RequestBody Map<String, String> map) {
		
		if(service.addWish(map) == 1) {}
		
		return null;
	}
	
	@DeleteMapping("/wish/delete")
	@ApiOperation(value = "찜목록 삭제", notes = "product_id, Member_userid를 전달받아 Wish 정보를 DB에서 삭제. 리턴값 없음")
	private ResponseEntity<Object> deleteWish(@RequestParam String product_id, String member_userid) {
		
		if(service.deleteWish(product_id, member_userid) == 1) {}
		
		return null;
	}
}
