package com.gumit.app.dto;

import java.util.List;

import com.gumit.app.elastic.RestaurantSearch;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class RestaurantsSearchList {

	private List<RestaurantSearch> restaurantSearchList;
}
