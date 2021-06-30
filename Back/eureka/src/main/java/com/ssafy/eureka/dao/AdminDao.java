package com.ssafy.eureka.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.eureka.dto.Member;
import com.ssafy.eureka.dto.Product;

@Mapper
public interface AdminDao {

	List<Product> getProductList(int start, int cnt);

	List<Member> getMemberList();

	int addProduct(Product product);

	int getProductCount();
}
