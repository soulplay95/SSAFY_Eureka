package com.ssafy.eureka.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.eureka.dto.Product;

@Mapper
public interface ProductDao {

	List<Product> showSearchResult(String keyword);

	List<Product> showItemList(String category);

	Map<String, Object> showDetail(String product_id);

	int registProduct(Product product);

	int modifyProduct(Product product);

	int deleteProduct(String product_id);
	
}
