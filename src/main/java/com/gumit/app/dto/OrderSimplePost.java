package com.gumit.app.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderSimplePost {
	
	private Long simpleId;
	
	private List<OrderDto> orderList;
	
}
