package com.ssafy.eureka.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.eureka.dao.OrderDao;
import com.ssafy.eureka.dto.Order;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDao dao;
	
	@Override
	public List<Order> showOrderList(String member_userid) {
		
		return dao.showOrderList(member_userid);
	}

	@Override
	public int addOrder(Map<String, Object> map) {

		return dao.addOrder(map);
	}

	@Override
	public int showOrderList(String member_userid, String product_id) {
		
		return dao.showOrderList(member_userid, product_id);
	}

	@Override
	public int addCart(Map<String, String> map) {
		
		return dao.addCart(map);
	}

	@Override
	public int deleteCart(String member_userid, String product_id) {
		
		return dao.deleteCart(member_userid, product_id);
	}

	@Override
	public int addWish(Map<String, String> map) {
		
		return dao.addWish(map);
	}

	@Override
	public int deleteWish(String product_id, String member_userid) {
		
		return dao.deleteWish(product_id, member_userid);
	}

}
