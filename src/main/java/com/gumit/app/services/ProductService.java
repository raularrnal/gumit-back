package com.gumit.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gumit.app.dto.AllergenDto;
import com.gumit.app.dto.CategoryDto;
import com.gumit.app.dto.ProductCategoryDto;
import com.gumit.app.dto.ProductDto;
import com.gumit.app.entity.Allergen;
import com.gumit.app.entity.AllergenProduct;
import com.gumit.app.entity.Category;
import com.gumit.app.entity.Product;
import com.gumit.app.repository.ProductRepository;


@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	
//	public List<ProductDto> getAllProduct() {
//
//		List<Product> productList = productRepository.findAll();
//
//		List<ProductDto> productDtoList = productList.stream().map(item -> productMapProductToDto(item))
//				.collect(Collectors.toList());
//
//		return productDtoList;
//	}
	
//	private ProductDto productMapProductToDto(Product item) {
//		
//		List<AllergenProduct> allergenProductList = item.getAllergenProduct();
//		
//		List<AllergenDto> allergenDtoList = new ArrayList<>();
//		
//		if(allergenProductList != null) {
//			for (AllergenProduct allergenProduct : allergenProductList) {
//				
//				List<Allergen> allergenList = allergenProduct.getAllergen();
//				
//					if (allergenList != null) {
//						for (Allergen allergen : allergenList) {
//							AllergenDto allergenDto = AllergenDto.builder().id(allergen.getId()).imgPath(allergen.getFileName()).name(allergen.getName()).build();
//						
//							allergenDtoList.add(allergenDto);
//						}
//					}
//			}
//			
//		}
//		
//		
//		return ProductDto.builder().name(item.getName()).id(item.getId())
//		.description(item.getDescription()).price(item.getPrice())
//		.category(ProductCategoryDto.builder().description(item.getCategory().getDescription())
//				.id(item.getCategory().getId()).build())
//		.recommended(item.isRecommended()).allergentList(allergenDtoList).build();
//		
//	}
	
//	public List<ProductDto> getAllProductsByCategory(Long categoryId){
//		
//		List<Product> productList = productRepository.findAll();
//		
//		List<ProductDto> productDtoList= productList.stream().filter(item -> item.getCategory().getId() == categoryId).map( item -> productMapProductToDto(item) ).collect(Collectors.toList());
//		
//		return productDtoList;
//		
//	}
	
	
	
	public void putProduct(ProductDto productDto){
		
		Product product = new Product();
		
		product.setId(productDto.getId());
		
		product.setPrice(productDto.getPrice());
		
		product.setDescription(productDto.getDescription());
		
		product.setRecommended(productDto.isRecommended() );
		
		Category category = new Category();
		
//		ProductCategoryDto categoryDto = productDto.getCategory();
		
//		category.setDescription(categoryDto.getDescription());
//		
//		category.setId(categoryDto.getId());
		
//		product.setCategory(category);
		
		productRepository.save(product);
		
	}
	
	public void removeProduct(Long id) {
		
		productRepository.deleteById(id);
		
	}
	
	
	public void addProduct(ProductDto productDto){
		
		Product product = new Product();
		
		
		product.setPrice(productDto.getPrice());
		
		product.setDescription(productDto.getDescription());
		
		product.setRecommended(productDto.isRecommended() );
		
		Category category = new Category();
		
//		ProductCategoryDto categoryDto = productDto.getCategory();
//		
//		category.setDescription(categoryDto.getDescription());
//		
//		category.setId(categoryDto.getId());
		
		product.setCategory(category);
		
		productRepository.save(product);
		
	}
	
	
	
	
}
