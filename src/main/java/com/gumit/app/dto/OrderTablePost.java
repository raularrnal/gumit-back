package com.gumit.app.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderTablePost {
	
	private String tableId;
	
	private List<OrderDto> orderList;
	
}
