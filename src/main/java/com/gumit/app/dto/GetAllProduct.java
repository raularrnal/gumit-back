package com.gumit.app.dto;

import java.util.List;

import com.gumit.app.entity.Product;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GetAllProduct {

	private List<ProductDto> productList;
	
}
