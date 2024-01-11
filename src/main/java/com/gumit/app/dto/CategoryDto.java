package com.gumit.app.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryDto {

	private Long id;
	
	private String description;
	
	
	private List<ProductDto> productList;
	
}
