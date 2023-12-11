package com.gumit.app.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AllergenDto {
	
	private Long id;
	
	private String name;

	private String imgPath;
	
	
	
}
