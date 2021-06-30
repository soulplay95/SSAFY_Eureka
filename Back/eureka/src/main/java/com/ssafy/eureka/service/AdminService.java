package com.ssafy.eureka.service;

import java.util.List;


import com.ssafy.eureka.dto.Member;
import com.ssafy.eureka.dto.Product;

public interface AdminService {

	List<Product> getProductList();

	List<Member> getMemberList();

	int addProduct(Product product);

}
