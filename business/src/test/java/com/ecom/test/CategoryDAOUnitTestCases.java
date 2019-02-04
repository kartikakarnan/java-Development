package com.ecom.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecom.dao.CategoryDAO;
import com.ecom.model.Category;


public class CategoryDAOUnitTestCases {
static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecom");
		context.refresh();
		
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	}
	

	@Test
	public void addCategoryUnitTest()
	{
		Category category=new Category();
		category.setCategoryName("XiomiMobile");
		category.setCategoryDesc("All Xiomi Smart Phone Mobile");
		
		assertTrue("Problem in adding the Category",categoryDAO.addCategory(category));
	}
	
	@Test
	public void updateCategoryUnitTest()
	{
		Category category=categoryDAO.getCategory(1);
		category.setCategoryDesc("All Samsung Smart Phone Mobiles");
		
		assertTrue("Problem in Updating the Category",categoryDAO.updateCategory(category));
	}
	@Ignore
	@Test
	public void deleteCategoryUnitTest()
	{
		Category category=categoryDAO.getCategory(2);
		assertTrue("Problem in Deleting the Category:",categoryDAO.deleteCategory(category));
	}
	
	@Test
	public void listCategoriesUnitTest()
	{
		List<Category> listCategories=categoryDAO.listCategories();
		
		assertTrue("Problem in Listing Category:",listCategories.size()>0);
		
		for(Category category:listCategories)
		{
			System.out.print(category.getCategoryId()+"\t");
			System.out.print(category.getCategoryName()+"\t");
			System.out.println(category.getCategoryDesc());
		}
	}

}
