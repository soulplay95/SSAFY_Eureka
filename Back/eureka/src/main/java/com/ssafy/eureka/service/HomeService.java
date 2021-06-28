package com.ssafy.eureka.service;

import java.util.List;
import java.util.Map;

import com.ssafy.eureka.dto.Product;

public interface HomeService {

	List<Product> getRandomTopProductsByCategory(Map map);
	
}
