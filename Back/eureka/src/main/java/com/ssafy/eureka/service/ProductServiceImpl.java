package com.ssafy.eureka.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssafy.eureka.dao.ProductDao;
import com.ssafy.eureka.dto.Product;

public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao dao;
	
	@Override
	public List<Product> showSearchResult(String keyword) {

		List<Product> list = dao.showSearchResult(keyword);
		
		return null;
	}

	@Override
	public List<Product> showItemList(String category) {

		List<Product> list = dao.showItemList(category);
		
		return null;
	}

	@Override
	public Map<String, Object> showDetail(String product_id) {

		Map<String, Object> map = dao.showDetail(product_id);
		
		return null;
	}

	@Override
	public int registProduct(Product product) {

		dao.registProduct(product);
		
		return 0;
	}

	@Override
	public int modifyProduct(Product product) {

		dao.modifyProduct(product);
		
		return 0;
	}

	@Override
	public int deleteProduct(String product_id) {

		dao.deleteProduct(product_id);

		return 0;
	}

}
