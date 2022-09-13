package com.unittesting.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

// Simple Testcase for calculateSum
class BusinessServiceTest {

	BusinessService service = new BusinessService();
	
	@Test
	void calculateSum() {
		int actual = service.calculateSum(new int[] {1,2,3});
		int expected = 6;
		assertEquals(expected,actual);
	}
	
	@Test
	void calculateSumEmptyValue() {
		int actual = service.calculateSum(new int[] {});
		int expected = 0;
		assertEquals(expected,actual);
	}
	
	@Test
	void calculateSumSingleValue() {
		int actual = service.calculateSum(new int[] {1});
		int expected = 1;
		assertEquals(expected,actual);
	}

}
