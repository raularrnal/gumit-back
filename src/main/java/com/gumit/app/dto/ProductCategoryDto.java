package com.gumit.app.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductCategoryDto {

	private Long id;
	
	private String description;
	
	
}
