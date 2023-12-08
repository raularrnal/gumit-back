package com.gumit.app.dto;

import com.gumit.app.entity.Category;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductInsertDto {
	
	private Double price;
	private String description;
	private boolean recommended;
	private Long categoryId;
}
