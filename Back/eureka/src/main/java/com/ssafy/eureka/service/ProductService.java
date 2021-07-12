package com.ssafy.eureka.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.eureka.dto.Product;

public interface ProductService {

	Map<String, Object> showSearchResult(String keyword, int page);

	Map<String, Object> showItemListByCategory(String category, int page);

	Map<String, Object> showDetail(String product_id);

	int registProduct(Product product);

	int modifyProduct(Product product);

	int deleteProduct(String product_id);

	List<Product> categoryTopList(String category);
	
}
