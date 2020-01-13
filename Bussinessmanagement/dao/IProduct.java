package com.tyss.Bussinessmanagement.dao;

import java.util.List;

import com.tyss.Bussinessmanagement.dto.Products;


public interface IProduct {
	public boolean insert(Products bill);

	public boolean delete(int Id);

	public boolean update(Products empBill);

	public List<Products> getallProducts();
}
