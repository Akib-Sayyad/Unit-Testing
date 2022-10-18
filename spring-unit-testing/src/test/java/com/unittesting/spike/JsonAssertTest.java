package com.unittesting.spike;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

	String actual = "{\"id\":1,\"name\":\"Dummy\",\"quantity\":10,\"price\":100.0}";
	
	@Test
	public void StrictTrue_ExactMatchExceptSpaces() throws JSONException {
		String expected = "{\"id\": 1,\"name\": \"Dummy\",\"quantity\": 10,\"price\": 100.0}"; 
		// not allow in case of string()
		JSONAssert.assertEquals(expected, actual, true);
	}
	
	@Test
	public void StrictFalse() throws JSONException {
		String expected = "{\"id\": 1,\"name\": \"Dummy\",\"quantity\": 10}"; 
		JSONAssert.assertEquals(expected, actual, false);
	}
	
	@Test
	public void withoutEscapeCharacter() throws JSONException {
		String expected = "{id: 1, name: Dummy , quantity: 10, price: 100.0}"; 
		// no restriction on spaces
		JSONAssert.assertEquals(expected, actual, true);
	}
}

//content().json() - can be matched with any formatting when strict = false (Deleting tag)

//JSONAssert.assertEquals(expected, actual, strict);
//default - false
/*
* <groupId>org.skyscreamer</groupId> 
* <artifactId>jsonassert</artifactId>
*/