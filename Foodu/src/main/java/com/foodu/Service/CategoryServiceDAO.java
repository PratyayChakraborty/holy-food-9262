package com.foodu.Service;

import java.util.List;
import com.foodu.Exception.CategoryException;
import com.foodu.Exception.LoginException;
import com.foodu.Model.Category;





public interface CategoryServiceDAO {
	
	public Category addCategory(String key, String categoryName) throws CategoryException, LoginException;
	
	public Category removeCategory(String key, String categoryName) throws CategoryException, LoginException;

	public Category viewCategoryById(String key, Integer categoryId) throws CategoryException, LoginException;
	
	public Category updateCategory(String key, Category category) throws CategoryException, LoginException;

	public List<Category> viewAllCategory(String key) throws CategoryException, LoginException;


	
 // public Category addCategory (Category category) throws CategoryException;
//	
//  public Category updateCategory (Category category) throws CategoryException;
//	
//	public Category removeCategory (Integer categoryId)throws CategoryException;
//	
//	public Category viewCategory (Integer categoryId)throws CategoryException;
//	
//	public List<Category> viewAllCategory (Category category)throws CategoryException;


}
