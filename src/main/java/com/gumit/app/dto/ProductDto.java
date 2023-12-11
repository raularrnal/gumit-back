package com.gumit.app.dto;

import java.util.List;

import com.gumit.app.entity.Category;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDto {
	
	private Long id;
	private String name;
	private Double price;
	private String description;
	private boolean recommended;
	private ProductCategoryDto category;
	
	private List<AllergenDto> allergentList;
	
}
