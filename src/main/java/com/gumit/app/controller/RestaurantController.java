package com.gumit.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gumit.app.dto.GetAllRestaurants;
import com.gumit.app.dto.RestaurantDto;
import com.gumit.app.services.RestaurantService;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/management/restaurant")
@CrossOrigin
@Log4j2
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;

	
	@GetMapping("/restaurants" )
	public ResponseEntity<GetAllRestaurants> getAllRestaurants(){
		
		GetAllRestaurants getAllRestaurants = GetAllRestaurants.builder().restaurantList(restaurantService.getAllRestaurants()).build();
		
		
		return  ResponseEntity.ok(getAllRestaurants );
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<RestaurantDto> getRestaurantById(@PathVariable Long id) {
		
		log.info("REQUEST TO {} ",id);
		
		return ResponseEntity.ok(restaurantService.getRestaurantById(id)) ;
	}
	
	
	
}
