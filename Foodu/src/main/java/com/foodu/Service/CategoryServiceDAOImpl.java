package com.foodu.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodu.Exception.CategoryException;
import com.foodu.Exception.LoginException;
import com.foodu.Model.Category;
import com.foodu.Model.CurrentUserSession;
import com.foodu.Repository.CategoryRepository;
import com.foodu.Repository.CurrentUserRepo;




@Service
public class CategoryServiceDAOImpl implements CategoryServiceDAO{
	
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	@Autowired
	private CurrentUserRepo currSession;
	
	
	
	@Override
	public Category addCategory(String key, String categoryName) throws CategoryException, LoginException {
		
		
		CurrentUserSession cur = currSession.findByUuid(key);
		
		if (cur != null && cur.getRole().equalsIgnoreCase("restaurant")) {
			
			Category exixtsCatogory = categoryRepository.findByCategoryName(categoryName);
			
			if (exixtsCatogory != null)
				throw new CategoryException("Category already exists!");
			
			Category category = new Category();
			category.setCategoryName(categoryName);

			return categoryRepository.save(category);

		}else
			throw new LoginException("Admin login required");
		
	}



	@Override
	public Category removeCategory(String key, String categoryName) throws CategoryException, LoginException {
		// TODO Auto-generated method stub
		
		CurrentUserSession currSess = currSession.findByUuid(key);
		if (currSess != null && currSess.getRole().equalsIgnoreCase("restaurant")) {

			Category category = categoryRepository.findByCategoryName(categoryName);
			if (category == null)
				throw new CategoryException("Category not found!");

			categoryRepository.delete(category);
			return category;
		} else
			throw new LoginException("Admin login required");
		
	}



	@Override
	public Category viewCategoryById(String key, Integer categoryId) throws CategoryException, LoginException {
		// TODO Auto-generated method stub
		
		CurrentUserSession currSess = currSession.findByUuid(key);
		if (currSess == null)
			throw new LoginException("Login required");

		Optional<Category> opt = categoryRepository.findById(categoryId);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new CategoryException("Category id not found!");
		}
		
	}



	@Override
	public Category updateCategory(String key, Category category) throws CategoryException, LoginException {
		// TODO Auto-generated method stub
		CurrentUserSession currSess = currSession.findByUuid(key);
		if (currSess != null && currSess.getRole().equalsIgnoreCase("restaurant")) {

			Optional<Category> categoryOpt = categoryRepository.findById(category.getCategoryId());
			if (categoryOpt.isEmpty())
				throw new CategoryException("Category not found!");

			return categoryRepository.save(category);
		} else
			throw new LoginException("Admin login required");
	}



	@Override
	public List<Category> viewAllCategory(String key) throws CategoryException, LoginException {
		// TODO Auto-generated method stub
		CurrentUserSession currSess = currSession.findByUuid(key);
		if (currSess == null)
			throw new LoginException("Login required");

		List<Category> categories = categoryRepository.findAll();
		if (categories.isEmpty())
			throw new CategoryException("Categories list is empty!");

		return categories;
	}
	

//   Method without key;	
	
//	@Override
//	public Category addCategory(Category category) throws CategoryException {
//		
//		
//		if(category==null) {
//			throw new CategoryException("Category is Empty");
//			
//		}else
//			return 	categoryRepository.save(category);
//		
//		
//	}
//
//
//	@Override
//	public Category updateCategory(Category category) throws CategoryException {
//		Category category2= categoryRepository.findById(category.getCategoryId()).orElseThrow(()-> new CategoryException("Food Category not found with this Category Id"));
//		if(category2 !=null) {
//			categoryRepository.save(category);
//		}
//		return category;
//	}
//
//	
//	
//	@Override
//	public Category removeCategory(Integer categoryId) throws CategoryException {
//		Category category2= categoryRepository.findById(categoryId).orElseThrow(()-> new CategoryException("Food Category not found with this Category Id"));
//		if(category2 !=null) {
//			categoryRepository.delete(category2);
//		}
//		return category2;
//	}
//
//	@Override
//	public Category viewCategory(Integer categoryId) throws CategoryException {
//		Category category2=	categoryRepository.findById(categoryId).orElseThrow(()-> new CategoryException("Food Category not found with this Category Id"));
//		return category2;
//	}
//
//		
//		
//	@Override
//	public List<Category> viewAllCategory(Category category) throws CategoryException {
//		List<Category> categories=categoryRepository.findAll();
//		if(categories.size()==0) {
//			throw new CategoryException("Food Category not found with this Category Id");
//		}
//		return categories;
//	}










	
	
	
	
	
	

}
