package com.ecom.dao;

import java.util.List;

import com.ecom.model.Suppliers;

public interface SupplierDAO
{
	public boolean addSupplier(Suppliers supplier);
	public Suppliers getSupplier(int supplierId);
	public boolean deleteSupplier(Suppliers supplier);
	public boolean updateSuppplier(Suppliers supplier);
	public List<Suppliers> getSupplier();

}
