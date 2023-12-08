package com.gumit.app.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GetAllTables {

	private List<TableDto> tableList;
	
}
