package com.ssafy.eureka.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.eureka.dto.Product;

@Service
public interface ProductService {

	List<Product> showSearchResult(String keyword);

	List<Product> showItemList(String category);

	Map<String, Object> showDetail(String product_id);

	int registProduct(Product product);

	int modifyProduct(Product product);

	int deleteProduct(String product_id);
	
}
