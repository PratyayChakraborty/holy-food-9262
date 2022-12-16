package com.foodu.Service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodu.Exception.CategoryException;
import com.foodu.Model.Category;
import com.foodu.Repository.CategoryRepository;


@Service
public class CategoryServiceDAOImpl implements CategoryServiceDAO{
	
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category addCategory(Category category) throws CategoryException {
		
		
		if(category==null) {
			throw new CategoryException("Category is Empty");
			
		}else
			return 	categoryRepository.save(category);
		
		
	}

	@Override
	public Category updateCategory(Category category) throws CategoryException {
		Category category2= categoryRepository.findById(category.getCategoryId()).orElseThrow(()-> new CategoryException("Food Category not found with this Category Id"));
		if(category2 !=null) {
			categoryRepository.save(category);
		}
		return category;
	}

	
	
	@Override
	public Category removeCategory(Integer categoryId) throws CategoryException {
		Category category2= categoryRepository.findById(categoryId).orElseThrow(()-> new CategoryException("Food Category not found with this Category Id"));
		if(category2 !=null) {
			categoryRepository.delete(category2);
		}
		return category2;
	}

	@Override
	public Category viewCategory(Integer categoryId) throws CategoryException {
		Category category2=	categoryRepository.findById(categoryId).orElseThrow(()-> new CategoryException("Food Category not found with this Category Id"));
		return category2;
	}

		
		
	@Override
	public List<Category> viewAllCategory(Category category) throws CategoryException {
		List<Category> categories=categoryRepository.findAll();
		if(categories.size()==0) {
			throw new CategoryException("Food Category not found with this Category Id");
		}
		return categories;
	}
	
	
	
	
	

}
