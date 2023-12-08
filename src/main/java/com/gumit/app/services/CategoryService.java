package com.gumit.app.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gumit.app.dto.CategoryDto;
import com.gumit.app.dto.ProductDto;
import com.gumit.app.entity.Category;
import com.gumit.app.entity.Product;
import com.gumit.app.repository.CategoryRepository;
import com.gumit.app.repository.ProductRepository;


@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	
	public List<CategoryDto> getAllCategories() {
		
		List<Category> categoryList = categoryRepository.findAll();
		
		List<CategoryDto> categoryDtoList= categoryList.stream().map( item -> CategoryDto.builder().id(item.getId()).description(item.getDescription()).build() ).collect(Collectors.toList());
		
		
		return categoryDtoList;
	}
	
	
	public void addCategory(CategoryDto categoryDto) {
		
		Category category = new Category();
		
//		category.setId(categoryDto.getId());
		
		category.setDescription(categoryDto.getDescription());
		
		
		categoryRepository.save(category);
	}
	

	public void putCategory(CategoryDto categoryDto) {
		
		Category category = new Category();
		
		category.setId(categoryDto.getId());
		
		category.setDescription(categoryDto.getDescription());
		
		
		categoryRepository.save(category);
	}
	
	public void deleteCategory(Long id) {
		
		categoryRepository.deleteById(id);
		
	}
	
	public CategoryDto  getCategoryById(Long id) {
		
		Optional<Category> categoryOpt  = categoryRepository.findById(id);
		
		if(categoryOpt.isPresent()) {
			Category category = categoryOpt.get();
			return CategoryDto.builder().id(category.getId()).description(category.getDescription()).build();
			
		}
		
		return null;
	}
	
}
