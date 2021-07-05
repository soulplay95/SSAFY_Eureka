package com.ssafy.eureka.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.eureka.dao.AdminDao;
import com.ssafy.eureka.dto.Member;
import com.ssafy.eureka.dto.Product;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDao dao;
	
	@Override
	public Map<String, Object> getProductList(int page) {
		int start = (page-1) * 100;
		int cnt = 100;
		int all = dao.getProductCount();
		List<Product> products = dao.getProductList(start, cnt);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("count", all);
		map.put("products", products);
		return map;
	}

	@Override
	public List<Member> getMemberList() {
		return dao.getMemberList();
	}

	@Override
	public int addProduct(Product product) {
		return dao.addProduct(product);
	}
	
	@Override
	public int modifyProduct(Product product) {

		return dao.modifyProduct(product);
	}

	@Override
	public int deleteProduct(String product_id) {

		return dao.deleteProduct(product_id);
	}

}
