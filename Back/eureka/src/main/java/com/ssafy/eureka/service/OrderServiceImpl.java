package com.ssafy.eureka.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.eureka.dao.OrderDao;
import com.ssafy.eureka.dto.Order;
import com.ssafy.eureka.dto.OrderDetail;
import com.ssafy.eureka.dto.Product;
import com.ssafy.eureka.dto.ShipAddress;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDao dao;
	
	@Override
	public List<Order> showOrderList(String member_userid) {
		
		return dao.showOrderList(member_userid);
	}

	@Override
	public int deleteOrder(String order_id) {
		
		return dao.deleteOrder(order_id);
	}

	@Override
	public List<OrderDetail> showOrderDetailList(String order_id) {
		return dao.showOrderDetailList(order_id);
	}
	
	@Override
	public List<Map<String, Object>> showAllOrderList(String member_userid) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List<Order> order_list = dao.showOrderList(member_userid);
		for(int i = 0; i < order_list.size();i++) {
			Map<String, Object> map = new HashMap<String,Object>();
			String order_id = order_list.get(i).getOrder_id() +"";
			List<OrderDetail> orderdetail_list = dao.showOrderDetailList(order_id);
			map.put("order", order_list.get(i));
			map.put("orderdetail_list", orderdetail_list);
			list.add(map);
		}
		return list;
	}

	@Override
	public int addOrder(Map<String, Object> map) {
		List<OrderDetail> od_list = (List<OrderDetail>) map.get("orderdetails");
		 ObjectMapper mapper = new ObjectMapper();
		 List<OrderDetail> list =  mapper.convertValue(od_list, new TypeReference<List<OrderDetail>>() {});
		int cnt = 0;
		int size = list.size();
		Order order = (Order) map.get("order");
		dao.addOrder(order);
		int order_id = dao.getLastOrderid();
		for(int i = 0; i < size; i++) {
			OrderDetail temp = list.get(i);
			temp.setOrder_id(order_id);
			cnt += dao.addOrderdetail(temp);
		}
		return cnt;
	}


	@Override
	public List<Map<String,Object>> getCart(String member_userid) {
		return dao.getCart(member_userid);
	}

	@Override
	public int checkDup(Map<String, String> map) {
		
		return dao.checkDup(map);
	}

	@Override
	public int addCart(Map<String, String> map) {
		
		return dao.addCart(map);
	}

	@Override
	public int modifyCart(Map<String, String> map) {
		
		return dao.modifyCart(map);
	}

	@Override
	public int deleteCart(String member_userid, String product_id) {
		
		return dao.deleteCart(member_userid, product_id);
	}
	
	@Override
	public List<Product> getWish(String member_userid) {
		return dao.getWish(member_userid);
	}

	@Override
	public int checkWishDup(Map<String, String> map) {
		
		return dao.checkWishDup(map);
	}

	@Override
	public int addWish(Map<String, String> map) {
		
		return dao.addWish(map);
	}

	@Override
	public int deleteWish(String product_id, String member_userid) {
		
		return dao.deleteWish(product_id, member_userid);
	}

	@Override
	public List<ShipAddress> getShippingAddress(String member_userid) {
		
		return dao.getShippingAddress(member_userid);	
	}

	@Override
	public int addShippingAddress(ShipAddress shipAddress) {
		
		if(shipAddress.getShipaddress_type() == 1) { // 기본 배송지로 추가 하는 경우, 모두 2로 바꾼 ㅎ
			dao.changeAllTypeTo2ByMemberId(shipAddress.getMember_userid());
		}
		
		return dao.addShippingAddress(shipAddress);
	}

	@Override
	public int defaultShippingAddress(int shipaddress_id) {
		dao.changeAllTypeTo2ByShipId(shipaddress_id);
		return dao.defaultShippingAddress(shipaddress_id);
	}

}
