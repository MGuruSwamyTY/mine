package com.tyss.Bussinessmanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.tyss.Bussinessmanagement.dto.Products;

@Repository
public class ProductDao implements IProduct {
	@PersistenceUnit
	private EntityManagerFactory emf;
	
	@Override
	public boolean insert(Products product) {
		System.out.println("product id::"+product.getId());
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(product);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(int Id) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Products bill1 = manager.find(Products.class, Id);
		if (bill1 == null) {
			return false;
		}
		transaction.begin();
		manager.remove(bill1);
		transaction.commit();
		return true;
	}

	@Override
	public boolean update(Products products) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Products product = manager.find(Products.class, products.getId());
		if (product == null) {
			return false;
		}
		transaction.begin();
		product.setId(products.getId());
		product.setName(products.getName());
		transaction.commit();
		return true;
	}

	@Override
	public List<Products> getallProducts() {
		EntityManager manager = emf.createEntityManager();
		String get = "from Products";
		Query query = (Query) manager.createQuery(get);
		List<Products> list = query.getResultList();
		if (list == null) {
			return null;
		}
		return list;
	}

}
