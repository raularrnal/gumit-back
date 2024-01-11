package com.gumit.app.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "menu")
@NoArgsConstructor
public class Menu {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(fetch =  FetchType.EAGER)
	@JoinColumn(name = "menu_id")
	private List<PriceMenu> priceMenuList;
	
	@OneToMany(fetch =  FetchType.EAGER)
	@JoinColumn(name = "menu_id")
	private List<CategoryMenu>  categoryMenuList;
	
}
