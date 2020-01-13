package com.tyss.Bussinessmanagement.sevice;

import java.util.List;

import com.tyss.Bussinessmanagement.dto.Sales;

public interface ISalesService {
	public boolean insert(Sales bill);

	public boolean delete(int Id);

	public boolean update(Sales Bill);

	public List<Sales> getallSales();
}
