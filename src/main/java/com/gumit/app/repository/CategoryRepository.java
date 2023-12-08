package com.gumit.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gumit.app.entity.Category;
import com.gumit.app.entity.Product;

@org.springframework.stereotype.Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
