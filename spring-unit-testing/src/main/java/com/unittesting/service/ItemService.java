package com.unittesting.service;

import org.springframework.stereotype.Component;

import com.unittesting.model.Item;

@Component
public class ItemService {

	public Item retrieveHardcodedItem() {
		return  new Item(1, "Mobile", 10, 50000.00);
	}
}
