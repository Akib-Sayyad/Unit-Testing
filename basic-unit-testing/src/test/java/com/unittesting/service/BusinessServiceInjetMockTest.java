package com.unittesting.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

//Mocking using Annotations - remove BusinessServiceMockTest boilerplate code

@ExtendWith(MockitoExtension.class)
//@RunWith(MockitoJUnitRunner.class) - Not work
class BusinessServiceInjetMockTest {

	@InjectMocks
	BusinessService service ;
	
	@Mock
	DataService dataService;

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
