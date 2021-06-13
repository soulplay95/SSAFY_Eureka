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
		
		List<Order> list = dao.showOrderList(member_userid);
		
		return null;
	}

	@Override
	public int addOrder(Map<String, Object> map) {
		
		dao.addOrder(map);
		
		return 0;
	}

	@Override
	public int showOrderList(String member_userid, String product_id) {

		dao.showOrderList(member_userid, product_id);
		
		return 0;
	}

	@Override
	public int addCart(Map<String, String> map) {

		dao.addCart(map);
		
		return 0;
	}

	@Override
	public int deleteCart(String member_userid, String product_id) {

		dao.deleteCart(member_userid, product_id);
		
		return 0;
	}

	@Override
	public int addWish(Map<String, String> map) {

		dao.addWish(map);
		
		return 0;
	}

	@Override
	public int deleteWish(String product_id, String member_userid) {
		
		dao.deleteWish(product_id, member_userid);
		
		return 0;
	}

}
