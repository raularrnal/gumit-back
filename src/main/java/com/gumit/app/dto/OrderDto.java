package com.gumit.app.dto;

import java.util.Date;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderDto {
	
	private Long id;
	
	private ProductDto product;
	
	private Date date;
	
	private String status;
	

}
