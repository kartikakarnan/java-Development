package com.ecom.dao;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecom.model.Suppliers;

@Repository("supplierDAO")

public class SupplierDAOImpl implements SupplierDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional


	public boolean addSupplier(Suppliers supplier) {
		try
		{
		sessionFactory.getCurrentSession().save(supplier);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:"+e);
		
		return false;
		}
		
	}

	
	public Suppliers getSupplier(int supplierId) {
		Session session=sessionFactory.openSession();
		Suppliers supplier=(Suppliers)session.get(Suppliers.class,supplierId);
		session.close();
		return supplier;
	     
		
	}
	@Transactional
	
	public boolean deleteSupplier(Suppliers supplier) {
		try
		{
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
		
		
	}
    @Transactional
	
	public boolean updateSuppplier(Suppliers supplier) {
		try
		{
			sessionFactory.getCurrentSession().update(supplier);
			
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
	}

	
	public List<Suppliers> getSupplier() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Supplier");
		List<Suppliers> listSuppliers=(List<Suppliers>)query.list();
		return listSuppliers;

}
}
