package com.gumit.app.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gumit.app.dto.CategoryDto;
import com.gumit.app.dto.ProductDto;
import com.gumit.app.dto.RestaurantDto;
import com.gumit.app.entity.Category;
import com.gumit.app.entity.Product;
import com.gumit.app.entity.Restaurant;
import com.gumit.app.repository.CategoryRepository;
import com.gumit.app.repository.ProductRepository;
import com.gumit.app.repository.RestaurantRepository;


@Service
public class RestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepository;
	
	
	public List<RestaurantDto> getAllRestaurants() {
		
		List<Restaurant> restaurantList = restaurantRepository.findAll();
		
		List<RestaurantDto> restaurantDtoList= restaurantList.stream().map( item -> RestaurantDto.builder().id(item.getId()).name(item.getName()).address(item.getAddress()).city(item.getCity() ).phone(item.getPhone()).build() ).collect(Collectors.toList());
		
		
		return restaurantDtoList;
	}
	
	public RestaurantDto getRestaurantById(Long id) {
		
		Optional<Restaurant> restaurantOpt =  restaurantRepository.findById(id);
		
		
		if(restaurantOpt.isPresent()) {
			
			Restaurant item = restaurantOpt.get();
			
			return RestaurantDto.builder().id(item.getId()).name(item.getName()).address(item.getAddress()).city(item.getCity() ).phone(item.getPhone()).build() ;
		}
		return null;
	}
	
	
	public void addRestaurant(RestaurantDto restaurantDto) {
		
		Restaurant restaurant = new Restaurant();
		
		restaurant.setName(restaurantDto.getName());
		
		restaurant.setAddress(restaurantDto.getAddress());
		
		restaurant.setCity(restaurantDto.getCity());
		
		restaurant.setPhone(restaurantDto.getPhone());
		
		restaurantRepository.save(restaurant);
		
		
	}
	
	public void putRestaurant(RestaurantDto restaurantDto) {
		
		Restaurant restaurant = new Restaurant();
		
		restaurant.setId(restaurantDto.getId());
		
		restaurant.setName(restaurantDto.getName());
		
		restaurant.setAddress(restaurantDto.getAddress());
		
		restaurant.setCity(restaurantDto.getCity());
		
		restaurant.setPhone(restaurantDto.getPhone());
		
		restaurantRepository.save(restaurant);
		
		
	}
	
	

	
	public void deleteRestaurants(Long id) {
		
		restaurantRepository.deleteById(id);
		
	}
	
	
}
