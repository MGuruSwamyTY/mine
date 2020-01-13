package com.tyss.Bussinessmanagement.dao;

import java.util.List;

import com.tyss.Bussinessmanagement.dto.Products;
import com.tyss.Bussinessmanagement.dto.Sales;

public interface ISales {
	public boolean insert(Sales bill);

	public boolean delete(int Id);

	public boolean update(Sales Bill);

	public List<Sales> getallSales();
}
