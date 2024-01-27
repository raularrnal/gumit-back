package com.gumit.app.entity;

import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "restaurant")
@Data
@NoArgsConstructor
public class Restaurant {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name" , columnDefinition = "VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci")
	private String name;
	

	@Column(name = "logo")
	private String logo;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "is_take_away")
    private boolean isTakeAway;
	@Column(name = "is_delivery")
	private boolean isdelivery;
	@Column(name = "is_whatsapp_order")
	private boolean isWhatsappOrder;
	@Column(name = "instagram_account")
	private String instragramAccount;
	@Column(name = "facebook_account")
	private String facebookAccount;
	@Column(name = "whatsapp_number")
	private Long whatsappNumber;
	
	
	
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "restaurant_id")
	private List<Category> category;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "restaurant_id")
	private List<Schedule> scheduleList;
	

}
	


