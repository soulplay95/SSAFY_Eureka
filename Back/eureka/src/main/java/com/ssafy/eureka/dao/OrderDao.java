package com.ssafy.eureka.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.eureka.dto.Order;
import com.ssafy.eureka.dto.OrderDetail;

@Mapper
public interface OrderDao {

	List<Order> showOrderList(String member_userid);

	int addOrder(Map<String, Object> map);

	int showOrderList(String member_userid, String product_id);

	int addCart(Map<String, String> map);

	int deleteCart(String member_userid, String product_id);

	int addWish(Map<String, String> map);

	int deleteWish(String product_id, String member_userid);

	List<OrderDetail> showOrderDetailList(String order_id);
}
