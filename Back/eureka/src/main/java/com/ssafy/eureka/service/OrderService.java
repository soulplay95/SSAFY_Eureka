package com.ssafy.eureka.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.eureka.dto.Order;

@Service
public interface OrderService {

	List<Order> showOrderList(String member_userid);

	int addOrder(Map<String, Object> map);

	int showOrderList(String member_userid, String product_id);

	int addCart(Map<String, String> map);

	int deleteCart(String member_userid, String product_id);

	int addWish(Map<String, String> map);

	int deleteWish(String product_id, String member_userid);

}
