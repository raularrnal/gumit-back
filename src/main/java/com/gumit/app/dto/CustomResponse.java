package com.gumit.app.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CustomResponse {

	private String message;
	
	private Object obj;
}
