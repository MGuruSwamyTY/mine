package com.tyss.Bussinessmanagement.sevice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.Bussinessmanagement.dao.IProduct;
import com.tyss.Bussinessmanagement.dto.Products;
@Service
public class ProductService implements IProductService {
	@Autowired
	private IProduct dao;
	@Override
	public boolean insert(Products product) {
		return dao.insert(product);
	}

	@Override
	public boolean delete(int Id) {
		
		return dao.delete(Id);
	}

	@Override
	public boolean update(Products product) {
		
		return dao.update(product);
	}

	@Override
	public List<Products> getallProducts() {
		
		return dao.getallProducts();
	}

}
