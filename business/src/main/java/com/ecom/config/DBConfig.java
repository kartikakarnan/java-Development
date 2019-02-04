package com.ecom.config;

import java.util.Properties;



import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import com.ecom.model.Category;
import com.ecom.model.Suppliers;
import com.ecom.model.Product;
import com.ecom.model.User;
import com.ecom.dao.*;


@Configuration
@EnableTransactionManagement
@ComponentScan("com.ecom")
public class DBConfig 
{
	
	//1. Create a DataSource object
	@Bean(name="dataSource") 
	public DataSource getH2DataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUsername("karthi");
		dataSource.setPassword("karthi");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test1");
		System.out.println("===Creating the DataSource Created=====");
		return dataSource;
	}
	
	//2. Create a SessionFactory object
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		Properties hibernateProperties=new Properties();
		hibernateProperties.put("hibernate.hbm2ddl.auto", "update");
		hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		
		LocalSessionFactoryBuilder factory1=new LocalSessionFactoryBuilder(getH2DataSource());
		factory1.addProperties(hibernateProperties);
		factory1.addAnnotatedClass(Category.class);
		factory1.addAnnotatedClass(Suppliers.class);
		factory1.addAnnotatedClass(Product.class);
		factory1.addAnnotatedClass(User.class);
		//We need to add the annotated class of Model later once it is created.
		SessionFactory sessionFactory=factory1.buildSessionFactory();
		
		System.out.println("===Creating the SessionFactory Bean=====");
		return factory1.buildSessionFactory();
	}
	@Bean(name="categoryDAO")
	public CategoryDAO getCategoryDAO()
	{
		System.out.println("----Category DAO Implementation---");
		return new CategoryDAOImpl();
	}
	
	@Bean(name="supplierDAO")
	public SupplierDAO getSupplierDAO()
	{
		System.out.println("----Supplier DAO Implementation---");
		return new SupplierDAOImpl();
	}
	@Bean(name="productDAO")
	public ProductDAO getProductDAO()
	{
		System.out.println("----Product DAO Implementation---");
		return new ProductDAOImpl();
	}
	@Bean(name="userDAO")
	public UserDAO getUserDAO()
	{
		System.out.println("----User DAO Implementation---");
		return new UserDAOImpl();
	}

	
	
	//3. Create a HibernateTransactionManager
	
	@Bean(name="txManager")
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("===Creating the TransactionManager Bean=====");
		return new HibernateTransactionManager(getSessionFactory());
	}
}
