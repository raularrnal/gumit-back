package com.gumit.app.dto;

import java.util.List;

import com.gumit.app.entity.CategoryMenu;
import com.gumit.app.entity.ProductMenu;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryMenuDto {
	
	private Long id;
	
	private String name;
	
	private List<ProductMenuDto>  productMenuList;

}
