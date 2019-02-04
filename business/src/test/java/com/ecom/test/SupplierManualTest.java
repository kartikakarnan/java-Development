package com.ecom.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecom.dao.SupplierDAO;
import com.ecom.model.Suppliers;

public class SupplierManualTest {
	public static void main(String arg[])
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecom");
		context.refresh();
		
		SupplierDAO supplierDAO=(SupplierDAO )context.getBean("supplierDAO");
		
		Suppliers suppliers=new Suppliers();
		suppliers.setSupplierName("True Retailer");
		suppliers.setSupplierDesc("All Variety of Samsung Mobile");
		
		supplierDAO.addSupplier(suppliers);
	}

}
