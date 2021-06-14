package com.ssafy.eureka.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.eureka.dao.ProductDao;
import com.ssafy.eureka.dto.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao dao;
	
	@Override
	public List<Product> showSearchResult(String keyword) {
		
		return dao.showSearchResult(keyword);
	}

	@Override
	public List<Product> showItemList(String category) {
		
		return dao.showItemList(category);
	}

	@Override
	public Map<String, Object> showDetail(String product_id) {

		return dao.showDetail(product_id);
	}

	@Override
	public int registProduct(Product product) {

		return dao.registProduct(product);
	}

	@Override
	public int modifyProduct(Product product) {

		return dao.modifyProduct(product);
	}

	@Override
	public int deleteProduct(String product_id) {

		return dao.deleteProduct(product_id);
	}

}
