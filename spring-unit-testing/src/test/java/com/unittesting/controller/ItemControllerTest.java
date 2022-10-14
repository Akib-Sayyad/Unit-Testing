package com.unittesting.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(ItemController.class)
@RunWith(SpringRunner.class)
public class ItemControllerTest {

	@Autowired
	MockMvc mock;

	@Test
	public void testDummyItem() throws Exception {


		RequestBuilder builder = MockMvcRequestBuilders.get("/dummy-item")
										.accept(MediaType.APPLICATION_JSON);
		
		mock.perform(builder).andExpect(status().isOk())
			.andExpect(content().json("{\"id\": 1 ,\"name\":\"Dummy\",\"quantity\":10,\"price\":100.0}"))
			.andReturn();

	}

}

// content().json() - can be matched with any formatting when strict = false