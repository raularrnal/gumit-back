package com.gumit.app.dto;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class RestaurantDto {
	
	private Long id;
	
	private String name;
	
	private String phone;

	
	private String address;
	
	private String city;
	
    private boolean isTakeAway;
	private boolean isdelivery;
	private boolean isWhatsappOrder;
	private String instragramAccount;
	private String facebookAccount;
	private Long whatsappNumber;
	
	private List<MenuDto> menuList;
	
	private List<CategoryDto> categoryList;
	
	private List<Schedule> scheduleList;

}
	


