package com.unittesting.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.unittesting.model.Item;
import com.unittesting.service.ItemService;

@WebMvcTest(ItemController.class)
@RunWith(SpringRunner.class)
public class ItemControllerTest {

	@Autowired
	MockMvc mock;

	@MockBean
	ItemService service;
	
	@Test
	public void testDummyItem() throws Exception {

		RequestBuilder builder = MockMvcRequestBuilders.get("/dummy-item");
		
		mock.perform(builder).andExpect(status().isOk())
			.andExpect(content().json("{\"id\": 1 ,\"name\":\"Dummy\",\"quantity\":10,\"price\":100.0}"))
			.andReturn();
	}
	
	@Test
	public void testItemFromService() throws Exception {
		
		when(service.retrieveHardcodedItem()).thenReturn(new Item(1, "Laptop", 2, 100000.00)); 

		RequestBuilder builder = MockMvcRequestBuilders.get("/item")
										.accept(MediaType.APPLICATION_JSON);
		mock.perform(builder).andExpect(status().isOk())
			.andExpect(content().json("{id: 1 ,name : Laptop, quantity:2,price:100000.0}"))
			.andReturn();
	}
	
	@Test
	public void testItemsFromDatabase() throws Exception {
		
		when(service.retrieveItemsFromDatabase()).thenReturn(Arrays.asList(new Item(1, "Keyboard", 2, 750.00), new Item(2, "Mouse", 5, 250.00))); 

		RequestBuilder builder = MockMvcRequestBuilders.get("/all-items")
										.accept(MediaType.APPLICATION_JSON);
		
		mock.perform(builder).andExpect(status().isOk())
			.andExpect(content().json("[{id:2,name:Mouse,quantity:5,price:250.00},  {id:1,name:Keyboard,quantity:2,price:750.00}]"))
			.andReturn();
		
		// JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

}

// content().json() - can be matched with any formatting when strict = false (Deleting tag)
