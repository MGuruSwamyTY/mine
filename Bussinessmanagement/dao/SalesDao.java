package com.tyss.Bussinessmanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.tyss.Bussinessmanagement.dto.Sales;
@Repository
public class SalesDao implements ISales{
	@PersistenceUnit
	private EntityManagerFactory emf;
	@Override
	public boolean insert(Sales bill) {
		System.out.println("insert :::"+bill);
		EntityManager manager=emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(bill);
			transaction.commit();
			return true;
		}catch(Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean delete(int Id) {
		EntityManager manager=emf.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		Sales sales=manager.find(Sales.class,Id);
		if(sales==null) {
			return false;
		}
		transaction.begin();
		manager.remove(sales);
		transaction.commit();
		return true;
	}

	@Override
	public boolean update(Sales Bill) {
		EntityManager manager=emf.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		Sales sales=manager.find(Sales.class,Bill.getId());
		if(sales==null) {
			return false;
		}
		transaction.begin();
		sales.setId(Bill.getId());
		sales.setP_id(Bill.getP_id());
		sales.setDate(Bill.getDate());
		sales.setPrize(Bill.getPrize());
		sales.setQuantity(Bill.getQuantity());
		transaction.commit();
		return true;
	}

	@Override
	public List<Sales> getallSales() {
		EntityManager manager=emf.createEntityManager();
		String get="from Sales";
		Query query=manager.createQuery(get);
		List<Sales> list=query.getResultList();
		if(list == null) {
			return null;
		}
		return list;
	}

}
