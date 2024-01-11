package com.gumit.app.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Schedule {
	
	private Long id;
	
	
	private Integer openHour;
	private Integer openMinutes;

	private Integer closeHour;
	private Integer closeMinutes;

	
	
	
}
