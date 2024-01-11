package com.gumit.app.dto;

import java.util.List;

import com.gumit.app.entity.CategoryMenu;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MenuPriceDto {
	
	private Long id;
	
	private Double price;
	
	private String description;
	

}
