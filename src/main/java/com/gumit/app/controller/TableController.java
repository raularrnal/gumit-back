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
@RequestMapping("/management/table")
public class TableController {
	
	@GetMapping("/{tableId}" )
	public ResponseEntity<TableDto> getTable(@PathVariable String tableId){
		
		return null;
		
	}
	
	
	@GetMapping("/tables" )
	public ResponseEntity<GetAllTables> getAllTables(){
		
		return null;
		
	}
	
	
	

	
	
	
	@PostMapping("/addTable")
	public ResponseEntity<OrderDto> addOrderToTable(@RequestBody OrderTablePost  orderTablePost){
	
		
		return null;
	}
	
	
}
