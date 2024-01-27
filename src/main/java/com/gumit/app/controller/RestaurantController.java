package com.gumit.app.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gumit.app.dto.GetAllRestaurants;
import com.gumit.app.dto.RestaurantDto;
import com.gumit.app.dto.RestaurantsSearchList;
import com.gumit.app.elastic.RestaurantSearch;
import com.gumit.app.services.ElasticService;
import com.gumit.app.services.RestaurantService;

import co.elastic.clients.elasticsearch._types.ElasticsearchException;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/management/restaurant")
@CrossOrigin
@Log4j2
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@Autowired
	private ElasticService elasticService;

	
	@GetMapping("/restaurants" )
	public ResponseEntity<GetAllRestaurants> getAllRestaurants(){
		
		GetAllRestaurants getAllRestaurants = GetAllRestaurants.builder().restaurantList(restaurantService.getAllRestaurants()).build();
		
		
		return  ResponseEntity.ok(getAllRestaurants );
		
	}
	
	
	@GetMapping("/elastic" )
	public ResponseEntity<RestaurantsSearchList> getAllRestaurantsFromElastic( @RequestParam("name") String name   ) {
		
		if(name == null || name.isEmpty()) {
			name = "*";
		}
		
		List<RestaurantSearch> restaurantList;
		try {
			restaurantList = elasticService.getRestaurantFromElastic(name);
		
		} catch (Exception e) {
			log.error(e);
			return ResponseEntity.internalServerError().body(new RestaurantsSearchList() );
		}
		
		return  ResponseEntity.ok(new RestaurantsSearchList(restaurantList) );
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<RestaurantDto> getRestaurantById(@PathVariable Long id) {
		
		log.info("REQUEST TO {} ",id);
		
		return ResponseEntity.ok(restaurantService.getRestaurantById(id)) ;
	}
	
	
	
}
