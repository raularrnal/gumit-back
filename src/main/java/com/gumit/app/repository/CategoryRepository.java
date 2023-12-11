package com.gumit.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gumit.app.entity.Category;
import com.gumit.app.entity.Product;

@org.springframework.stereotype.Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	@Query("SELECT c FROM Category c INNER JOIN c.restaurant r WHERE r.id = :id")
	List<Category> getCategoryByRestaurantId( @Param(value = "id") Long id );

}
