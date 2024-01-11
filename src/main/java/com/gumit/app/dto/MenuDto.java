package com.gumit.app.dto;

import java.util.List;

import com.gumit.app.entity.CategoryMenu;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MenuDto {
	
	private Long id;
	
	private String name;
	
	private List<CategoryMenuDto>  categoryMenuList;
	
	private List<MenuPriceDto> menuPriceList;

}
