package com.tyss.Bussinessmanagement.sevice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.Bussinessmanagement.dao.ISales;
import com.tyss.Bussinessmanagement.dto.Sales;
@Service
public class SalesService implements ISalesService{
	@Autowired	
	private ISales dao;
	@Override
	public boolean insert(Sales bill) {
		
		return dao.insert(bill);
	}

	@Override
	public boolean delete(int Id) {
		
		return dao.delete(Id);
	}

	@Override
	public boolean update(Sales Bill) {
		
		return dao.update(Bill);
	}

	@Override
	public List<Sales> getallSales() {
		
		return dao.getallSales();
	}

}
