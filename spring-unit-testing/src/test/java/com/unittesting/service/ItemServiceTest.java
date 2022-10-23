package com.unittesting.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.unittesting.data.ItemRepository;
import com.unittesting.model.Item;

@ExtendWith(MockitoExtension.class)
public class ItemServiceTest {
	
	@InjectMocks
	ItemService service;
	
	@Mock
	ItemRepository repository;
	
	@Test //org.junit.jupiter.api.Test - Works
	public void testRetrieveItemsFromDatabase() throws Exception {
		
		when(repository.findAll()).thenReturn(Arrays.asList(new Item(1, "AC", 2, 75000.00), new Item(2, "Cooler", 5, 25000.00)));
		
		List<Item> expectedList = Arrays.asList(new Item(1, "AC", 2, 75000.00), new Item(2, "Cooler", 5, 25000.00));
		List<Item> actualList = service.retrieveItemsFromDatabase();
		
		
		assertEquals(expectedList.size(), actualList.size());
		assertEquals("AC", actualList.get(0).getName());

	}
}
