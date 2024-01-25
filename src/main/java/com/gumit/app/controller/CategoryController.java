package com.gumit.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gumit.app.dto.CategoryDto;
import com.gumit.app.dto.CustomResponse;
import com.gumit.app.dto.GetAllCategories;
import com.gumit.app.dto.GetAllProduct;
import com.gumit.app.services.CategoryService;
import com.gumit.app.services.ProductService;


@RestController
@RequestMapping("/management/category")
@CrossOrigin
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	

	@GetMapping("/categories/{id}" )
	public ResponseEntity<GetAllCategories> getAllCategoriesByrestaurant(@PathVariable Long id){
		
		
		GetAllCategories getAllCategories = GetAllCategories.builder().categoryList(categoryService.getCategoriesByRestaurant(id)).build();
		
		return  ResponseEntity.ok(getAllCategories );
		
	}
	
	
	
	
	
	
}
