package com.gumit.app.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GetAllSimples {

	private List<SimpleDto> simpleList;
	
}
