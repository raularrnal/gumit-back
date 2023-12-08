package com.gumit.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gumit.app.dto.GetAllSimples;
import com.gumit.app.dto.GetAllTables;
import com.gumit.app.dto.OrderDto;
import com.gumit.app.dto.OrderSimplePost;
import com.gumit.app.dto.OrderTablePost;
import com.gumit.app.dto.SimpleDto;
import com.gumit.app.dto.TableDto;


@RestController()
@RequestMapping("/management/simple")
public class SimpleController {
	
	
	
	

	@GetMapping("/simples" )
	public ResponseEntity<GetAllSimples> getAllSimples(){
		
		return null;
		
	}
	
	
	
	
	
	@GetMapping("/{simpleId}")
	public ResponseEntity<SimpleDto> getSimple(@PathVariable String simpleId){
		
		return null;
		
	}
	
	
	
	@PostMapping("/addSimple")
	public ResponseEntity<OrderDto> addSimpleOrder(@RequestBody OrderSimplePost orderSimplePost){
	
		
		return null;
	}
	
}
