package com.unittesting.service;

import java.util.Arrays;

// BusinessService is dependent on DataService for retrieving data to calculateSum
public class BusinessService {

	private DataService dataService;

	int calculateSum(int[] num) {
		return Arrays.stream(num).reduce(0, Integer::sum);
	}

	int calculateSumByDataSerice() {
		int[] data = dataService.retieveAllData();
		return Arrays.stream(data).reduce(0, Integer::sum);
	}

	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}
}
