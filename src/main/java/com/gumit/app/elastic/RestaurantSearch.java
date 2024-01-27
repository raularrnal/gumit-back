package com.gumit.app.elastic;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RestaurantSearch  {
	
private Long id;
	
	private String name;
	

	private String logo;
	
	
	private String address;
	
	private String city;
	
	
    private boolean isTakeAway;
	private boolean isdelivery;
	private boolean isWhatsappOrder;

}
