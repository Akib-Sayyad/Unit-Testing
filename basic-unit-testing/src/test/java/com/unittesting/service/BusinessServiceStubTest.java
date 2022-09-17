package com.unittesting.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

// Simple Testcases for calculateSum Using DataService Stub
class BusinessServiceStubTest {
	
	BusinessService service = new BusinessService();
	
	class DataServiceStub implements DataService{
		@Override
		public int[] retrieveAllData() {
			return new int[] {1,2,3};
		}
	}
	
	@Test
	void calculateSum() {
		// Create stub class
		service.setDataService(new DataServiceStub());
		int actual = service.calculateSumByDataService();
		int expected = 6;
		assertEquals(expected,actual);
	}
	
	@Test
	void calculateSumEmpty() {
		// Create stub using Anonymous class
		service.setDataService(new DataService() {		
			@Override
			public int[] retrieveAllData() {
				return new int[] {};
			}
		});
		int actual = service.calculateSumByDataService();
		int expected = 0;
		assertEquals(expected,actual);
	}
	
	@Test
	void calculateSumSingleValue() {
		// Create stub using lambda
		service.setDataService(() -> {
			return new int[] { 5 };
		});
		int actual = service.calculateSumByDataService();
		int expected = 5;
		assertEquals(expected,actual);
	}
	
	

}
