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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gumit.app.dto.CategoryDto;
import com.gumit.app.dto.CustomResponse;
import com.gumit.app.dto.GetAllProduct;
import com.gumit.app.dto.ProductDto;
import com.gumit.app.dto.ProductInsertDto;
import com.gumit.app.dto.ProductUpdateDto;
import com.gumit.app.services.CategoryService;
import com.gumit.app.services.ProductService;


@RestController
@RequestMapping("/management/product")
@CrossOrigin
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	

	@GetMapping("/products" )
	public ResponseEntity<GetAllProduct> getAllSimples(){
		
		GetAllProduct getAllProduct = GetAllProduct.builder().productList(productService.getAllProduct()).build();
		
		return  ResponseEntity.ok(getAllProduct);
		
	}
	
	
	@GetMapping("/products/{categoryId}" )
	public ResponseEntity<GetAllProduct> getAllSimples(@PathVariable Long categoryId){
		
		GetAllProduct getAllProduct = GetAllProduct.builder().productList(productService.getAllProductsByCategory(categoryId)).build();
		
		return  ResponseEntity.ok(getAllProduct);
		
	}
	
	
	@PostMapping("/add" )
	public ResponseEntity<CustomResponse> insertProduct( @RequestBody ProductInsertDto productDto){
		
		
		
		CategoryDto categoryDto =  categoryService.getCategoryById(productDto.getCategoryId());
		
		productService.addProduct(ProductDto.builder().category(categoryDto).description(productDto.getDescription()).price(productDto.getPrice()).recommended(productDto.isRecommended()).build());
		
		return ResponseEntity.ok( CustomResponse.builder().message("INSERTADO CORRECTAMENTE").obj(productDto).build() );
	}
	
	
	@PutMapping("/update" )
	public ResponseEntity<CustomResponse> putProduct( @RequestBody ProductUpdateDto productDto){
		
		CategoryDto categoryDto =  categoryService.getCategoryById(productDto.getCategoryId());
		
		productService.putProduct(ProductDto.builder().category(categoryDto).description(productDto.getDescription()).id(productDto.getId()).price(productDto.getPrice()).recommended(productDto.isRecommended()).build());
		
		return ResponseEntity.ok( CustomResponse.builder().message("MODIFICADO CORRECTAMENTE").obj(productDto).build() );
	}
	
	
	@DeleteMapping("/remove/{id}" )
	public ResponseEntity<CustomResponse> removeProduct( @PathVariable Long id){
		
		productService.removeProduct(id);
		
		return ResponseEntity.ok( CustomResponse.builder().message("BORRADO CORRECTAMENTE").obj(id).build() );
	}
}
