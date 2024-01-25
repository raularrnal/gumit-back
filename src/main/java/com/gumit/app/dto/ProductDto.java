package com.gumit.app.dto;

import java.util.List;

import com.gumit.app.entity.Category;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDto {
	
	private Long id;
	private String name;
	private Double price;
	private String description;
	private boolean recommended;
	private String image;
	
	private List<AllergenProductDto> allergentProductList;
	
	
}
