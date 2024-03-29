package com.gumit.app.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product_allergen")
@Data
@NoArgsConstructor
public class AllergenProduct {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	

	
	@ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;


    @ManyToOne
    @JoinColumn(name = "allergen_id", insertable = false, updatable = false)
    private Allergen allergen;


}
