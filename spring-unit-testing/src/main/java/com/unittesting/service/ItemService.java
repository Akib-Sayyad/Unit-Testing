package com.unittesting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.unittesting.data.ItemRepository;
import com.unittesting.model.Item;

@Component
public class ItemService {
	
	@Autowired
	ItemRepository repository;

	public Item retrieveHardcodedItem() {
		return  new Item(1, "Mobile", 10, 50000.00);
	}
	
	public List<Item> retrieveItemsFromDatabase() {
		
		List<Item> list = repository.findAll();
		list.stream().forEach(i -> i.setValue(i.getPrice() * i.getQuantity()));
		return list;
	}
}
