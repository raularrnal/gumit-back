package com.gumit.app.entity;

import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "category")
@Data
@NoArgsConstructor
public class Category {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	
	
	@Column(name = "description")
	private String description;
	
	
	@ManyToOne
	@JoinColumn(name = "restaurant_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Restaurant restaurant;
	
	
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private List<Product> productList;

}
