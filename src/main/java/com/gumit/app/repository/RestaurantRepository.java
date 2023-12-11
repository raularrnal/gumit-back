package com.gumit.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gumit.app.entity.Product;
import com.gumit.app.entity.Restaurant;

@org.springframework.stereotype.Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

}
