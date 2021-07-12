package com.ssafy.eureka.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.eureka.dto.Product;
import com.ssafy.eureka.dto.Productqna;
import com.ssafy.eureka.dto.Review;

@Mapper
public interface ProductDao {

	List<Product> showSearchResult(String keyword, int start);

	List<Product> showItemListByCategory(String category, int start);

	List<Product> getCategoryTopList(String product_category);

	Product getProduct(String product_id);
	List<Productqna> getProductqna(String product_id);
	List<Review> getReview(String product_id);

	int registProduct(Product product);

	int modifyProduct(Product product);

	int deleteProduct(String product_id);

	int getProductSearchCount(String keyword);

	int getCountByCategory(String category);
	
}
