package com.gumit.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gumit.app.dto.CategoryDto;
import com.gumit.app.dto.ProductDto;
import com.gumit.app.dto.RestaurantDto;
import com.gumit.app.dto.Schedule;
import com.gumit.app.entity.Category;
import com.gumit.app.entity.Product;
import com.gumit.app.entity.Restaurant;
import com.gumit.app.entity.RestaurantAdditionalInfo;
import com.gumit.app.repository.CategoryRepository;
import com.gumit.app.repository.ProductRepository;
import com.gumit.app.repository.RestaurantRepository;

import jakarta.transaction.Transactional;


@Service
public class RestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Transactional
	public List<RestaurantDto> getAllRestaurants() {
		
		List<Restaurant> restaurantList = restaurantRepository.findAll();
		
		List<RestaurantDto> restaurantDtoList = restaurantList
				.stream().map(item -> mapRestaurantDto(item))
				.collect(Collectors.toList());		
		
		return restaurantDtoList;
	}
	
	@Transactional
	public RestaurantDto getRestaurantById(Long id) {
		
		Optional<Restaurant> restaurantOpt =  restaurantRepository.findById(id);
		
		
		if(restaurantOpt.isPresent()) {
			
			Restaurant item = restaurantOpt.get();
			
			return  mapRestaurantDto(item);
		}
		return null;
	}
	
	private RestaurantDto mapRestaurantDto(Restaurant item) {
		
		RestaurantAdditionalInfo restaurantAdditionalInfo = item.getRestaurantAdditionalInfo();
		
		
		
		List<Category> categoryList = item.getCategory();
		List<CategoryDto> categoryListDto = new ArrayList<>();
		
		if(categoryList != null) {
			
			for (Category category : categoryList) {
			 CategoryDto categoryDto =	modelMapper.map(category , CategoryDto.class);
			 categoryListDto.add(categoryDto);

			}
			
		}
		
		List<com.gumit.app.entity.Schedule> scheduleList = item.getScheduleList();
		
		List<Schedule> scheduleDtoList = new ArrayList<>();
		
		if(scheduleList != null) {
			for (com.gumit.app.entity.Schedule scheduleEntity : scheduleList) {
				
			
			Schedule schedule = 	modelMapper.map(scheduleEntity , Schedule.class);
			scheduleDtoList.add(schedule);
			}
		}

		
		if(restaurantAdditionalInfo != null) {
			return  RestaurantDto.builder().id(item.getId()).logo(item.getLogo()).name(item.getName()).address(item.getAddress())
					.city(item.getCity()).phone(item.getPhone()).facebookAccount(restaurantAdditionalInfo.getFacebookAccount())
					.instragramAccount(restaurantAdditionalInfo.getInstragramAccount())
					.isdelivery(restaurantAdditionalInfo.isIsdelivery())
					.isWhatsappOrder(restaurantAdditionalInfo.isWhatsappOrder())
					.whatsappNumber(restaurantAdditionalInfo.getWhatsappNumber())
					.isTakeAway(restaurantAdditionalInfo.isTakeAway()).categoryList(categoryListDto)
					.scheduleList(scheduleDtoList)
					.build();
		}
		return RestaurantDto.builder().logo(item.getLogo()).id(item.getId()).name(item.getName()).address(item.getAddress())
				.city(item.getCity()).phone(item.getPhone()).categoryList(categoryListDto)
				.scheduleList(scheduleDtoList)
				.build();

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
