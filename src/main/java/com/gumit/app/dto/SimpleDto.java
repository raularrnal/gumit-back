package com.gumit.app.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SimpleDto {
	
	private String id;
	
	private List<OrderDto> orderList;
	
	private String status;
	
	

}
