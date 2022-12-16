package com.foodu.Controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.foodu.Exception.CategoryException;
import com.foodu.Exception.CustomerException;
import com.foodu.Model.Category;

import com.foodu.Service.CategoryServiceDAO;







@RestController
public class CategoryHandler {
	
	
	@Autowired
	CategoryServiceDAO categoryServiceDAO;
	
	@PostMapping("/categorys")
	public ResponseEntity<Category> addCategoryHandler(@RequestBody Category category) throws CategoryException{
		Category category2=	categoryServiceDAO.addCategory(category);

		return new ResponseEntity<Category>(category2,HttpStatus.CREATED);
		
	}
	
	
	@PutMapping("/updatedcategory")
	public ResponseEntity<Category> updateCategoryHandler(@RequestBody Category category) throws CategoryException{
		Category category2=	categoryServiceDAO.updateCategory(category);
		
		return new ResponseEntity<Category>(category2,HttpStatus.CREATED);
		
	}
	
	
	@DeleteMapping("/removecategory/{categoryId}")
	public ResponseEntity<Category> removeCategoryHandler(@PathVariable ("categoryId") Integer categoryId){
		Category category2=	categoryServiceDAO.removeCategory(categoryId);
		
		return new ResponseEntity<Category>(category2,HttpStatus.OK);
		
		
		//  http://localhost:8888/removecategory/3
		
	}
	
	
	
	@GetMapping("/viewcategorybyid/{categoryId}")
	public ResponseEntity<Category> viewCategoryByIdHandler(@PathVariable ("categoryId") Integer categoryId) throws CategoryException{
		Category category2=	categoryServiceDAO.viewCategory(categoryId);
		
		return new ResponseEntity<Category>(category2,HttpStatus.OK);
		
	//  http://localhost:8888/viewcategorybyid/4
	}
	
	
	
	
	@GetMapping("/viewallcategory")
	public ResponseEntity<List<Category>> viewAllCategories(Category category) throws CustomerException {
		List<Category> categories=	categoryServiceDAO.viewAllCategory(category);
		
		return new ResponseEntity<List<Category>>(categories,HttpStatus.OK);
		
	//  http://localhost:8888/viewallcategory
	}
	
	
	

}
