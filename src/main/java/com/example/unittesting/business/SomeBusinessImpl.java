package com.example.unittesting.business;

import com.example.unittesting.data.SomeDataService;

public class SomeBusinessImpl {

	private SomeDataService someDataService;
	
	public void setSomeDataService(SomeDataService someDataService) {
		this.someDataService = someDataService;
	}

	//Total number
	public int calculateSum(int[] data) {
		int sum=0;
		for(int value:data) {
			sum += value;
		}
		return sum;
	}
	
	//Total number
	public int calculateSumUsingDataService() {
		int sum=0;
		int[] data = someDataService.retrieveAllData();
		for(int value:data) {
			sum += value;
		}
		return sum;
	}
	
	// Comparing Words whether are same 
	public String correctWords() {
		String words = "JAVA";
		
		return words;
	}
	
	// Sum of numbers in Array
	public int hesapla() {
		
		int[] arr = {1,2,3,4,1};
		int sum=0;
			
		for(int i=0; i < arr[i]; i++) {
			if(i <= arr[i]) {				
				sum = sum + arr[i];
			}
		}
		
		System.out.println(sum);
		return sum;
	}
	
	// finding index of letter
	public int findingLetter() {
		String str = new String("Hi welcome to Tutioral");
		int index = str.indexOf('o');
		System.out.println("Index of Letter o : " + index);
		return index;
	}
	
	
	// show and display are the common method
	public int display() {
		int simpleNo = 5;
		int sum =0;
		
		sum += simpleNo;
		
		return sum;
	}
	
	//Same with upper one
	public int showingTotalNumber() {
		
		SomeBusinessImpl number = new SomeBusinessImpl();
		
		return number.display();
	}
	
	
	
	
}