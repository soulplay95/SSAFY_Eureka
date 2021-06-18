package com.ssafy.eureka.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.eureka.dto.Product;
import com.ssafy.eureka.dto.Productqna;
import com.ssafy.eureka.dto.Review;

@Mapper
public interface ProductDao {

	List<Product> showSearchResult(String keyword);

	List<Product> showItemList(String category);

	Product getProduct(String product_id);
	Productqna getProductqna(String product_id);
	Review getReview(String product_id);

	int registProduct(Product product);

	int modifyProduct(Product product);

	int deleteProduct(String product_id);


	
}
