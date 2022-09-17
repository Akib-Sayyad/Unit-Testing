package com.unittesting.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Simple Testcases for calculateSum Using DataService Mock
class BusinessServiceMockTest {

	BusinessService service = new BusinessService();
	DataService dataService = mock(DataService.class);

	@BeforeEach
	public void beforeTest() {
		service.setDataService(dataService);
	}

	@Test
	void calculateSum() {

		when(dataService.retrieveAllData()).thenReturn(new int[] { 10, 20 });
		int actual = service.calculateSumByDataService();
		int expected = 30;
		assertEquals(expected, actual);
	}

	@Test
	void calculateSumEmpty() {
		
		when(dataService.retrieveAllData()).thenReturn(new int[] {});
		int actual = service.calculateSumByDataService();
		int expected = 0;
		assertEquals(expected, actual);
	}

	@Test
	void calculateSumSingleValue() {

		when(dataService.retrieveAllData()).thenReturn(new int[] { 50 });
		int actual = service.calculateSumByDataService();
		int expected = 50;
		assertEquals(expected, actual);
	}

}
