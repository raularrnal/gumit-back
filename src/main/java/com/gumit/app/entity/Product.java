package com.gumit.app.entity;

import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "product")
@NoArgsConstructor
public class Product {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Long id;
	@Column(name = "name")
    private String name;
	@Column(name = "price")
	private Double price;
	@Column(name = "description")
	private String description;
	@Column(name = "recommended")
	private boolean recommended;
	@Column(name = "image")
	private String image;
	
	@ManyToOne
	@JoinColumn(name = "id_category")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@OneToMany(fetch = FetchType.EAGER)
	private Category category;
	
	
	
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<AllergenProduct>  allergentProductList;
}
