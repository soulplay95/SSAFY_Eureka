package com.ssafy.eureka.service;

import java.util.List;
import java.util.Map;

import com.ssafy.eureka.dto.Member;
import com.ssafy.eureka.dto.Product;

public interface AdminService {

	Map<String, Object> getProductList(int page);

	List<Member> getMemberList();

	int addProduct(Product product);
	
	int modifyProduct(Product product);

	int deleteProduct(String product_id);

}
