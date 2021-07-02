package com.ssafy.eureka.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.eureka.dto.Product;

@Mapper
public interface HomeDao {

	public List<Product> getRandomTopProductsByCategory();

	public List<Map<String, Object>> get1depthCategory();
	public List<Map<String, Object>> get2depthCategory();
	public List<Map<String, Object>> get3depthCategory();

}
