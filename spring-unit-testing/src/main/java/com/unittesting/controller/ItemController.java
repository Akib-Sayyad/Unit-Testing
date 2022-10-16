package com.unittesting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unittesting.model.Item;
import com.unittesting.service.ItemService;


@RestController
public class ItemController {
	
	@Autowired
	ItemService service;
	
	@GetMapping("/dummy-item")
	public Item dummyItem() {
		return new Item(1, "Dummy", 10, 100.00);
	}
	
	@GetMapping("/item")
	public Item itemFromService() {
		return service.retrieveHardcodedItem();
	}

}
