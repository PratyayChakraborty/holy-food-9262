package com.foodu.Service;

import java.util.List;
import com.foodu.Exception.CategoryException;
import com.foodu.Model.Category;




public interface CategoryServiceDAO {
	
    public Category addCategory (Category category) throws CategoryException;
	
    public Category updateCategory (Category category) throws CategoryException;
	
	public Category removeCategory (Integer categoryId)throws CategoryException;
	
	public Category viewCategory (Integer categoryId)throws CategoryException;
	
	public List<Category> viewAllCategory (Category category)throws CategoryException;


}
