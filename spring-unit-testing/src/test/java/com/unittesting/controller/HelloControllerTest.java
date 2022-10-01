package com.unittesting.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class) // Define Class to Test
public class HelloControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Test
	public void testHello() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders
				.get("/hello")
				.accept("application/json");
		
		MvcResult result = mockMvc.perform(request)
								  .andReturn();
		assertEquals("Hello", result.getResponse().getContentAsString());
	}

}
