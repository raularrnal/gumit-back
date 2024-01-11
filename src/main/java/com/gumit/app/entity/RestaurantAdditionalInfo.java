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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "restaurant_additional_info")
@NoArgsConstructor
public class RestaurantAdditionalInfo {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Long id;
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
	

	

}
