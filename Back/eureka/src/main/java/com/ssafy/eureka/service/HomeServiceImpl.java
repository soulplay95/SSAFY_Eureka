package com.ssafy.eureka.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.eureka.dao.HomeDao;
import com.ssafy.eureka.dto.Product;

@Service
public class HomeServiceImpl implements HomeService {

	@Autowired
	HomeDao dao;
	
	@Override
	public List<Product> getRandomTopProductsByCategory(Map map) {
		return dao.getRandomTopProductsByCategory(map);
	}

}
