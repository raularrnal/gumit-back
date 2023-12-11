package com.gumit.app.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gumit.app.dto.CategoryDto;
import com.gumit.app.dto.ProductCategoryDto;
import com.gumit.app.dto.RestaurantDto;
import com.gumit.app.entity.Category;
import com.gumit.app.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public List<CategoryDto> getAllCategories() {

		List<Category> categoryList = categoryRepository.findAll();

		List<CategoryDto> categoryDtoList = categoryList.stream().map(item -> CategoryDto.builder().id(item.getId())
				.restauranDto(RestaurantDto.builder().id(item.getRestaurant().getId()).name(item.getRestaurant().getName())
						.address(item.getRestaurant().getAddress()).city(item.getRestaurant().getCity()).phone(item.getRestaurant().getPhone()).build())
				.description(item.getDescription()).build())
				.collect(Collectors.toList());

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

	public ProductCategoryDto getCategoryById(Long id) {

		Optional<Category> categoryOpt = categoryRepository.findById(id);

		if (categoryOpt.isPresent()) {
			Category category = categoryOpt.get();
			return ProductCategoryDto.builder().id(category.getId()).description(category.getDescription()).build();

		}

		return null;
	}

	public List<CategoryDto> getCategoriesByRestaurant(Long id) {

		List<Category> categoryList = categoryRepository.getCategoryByRestaurantId(id);

		if (categoryList != null) {
			return  categoryList.stream()
					.map(item -> CategoryDto.builder().id(item.getId())
							.restauranDto(RestaurantDto.builder().id(item.getRestaurant().getId()).name(item.getRestaurant().getName())
									.address(item.getRestaurant().getAddress()).city(item.getRestaurant().getCity()).phone(item.getRestaurant().getPhone()).build())
							.description(item.getDescription()).build())
					.collect(Collectors.toList());
			
			

		}

		return null;
	}

}
