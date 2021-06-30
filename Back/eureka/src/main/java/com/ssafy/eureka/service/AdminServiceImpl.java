package com.ssafy.eureka.service;

import java.util.List;

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
	public List<Product> getProductList() {
		return dao.getProductList();
	}

	@Override
	public List<Member> getMemberList() {
		return dao.getMemberList();
	}

	@Override
	public int addProduct(Product product) {
		return dao.addProduct(product);
	}

}
