package com.example.unittesting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

import com.example.unittesting.business.SomeBusinessImpl;
import com.example.unittesting.data.SomeDataService;

class SomeBusinessImpTest {
	
	//Total number
	@Test
	public void calculateSumTest() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		SomeDataService dataService = mock(SomeDataService.class);
		when(dataService.retrieveAllData()).thenReturn(new int[] {2});
		
		business.setSomeDataService(dataService);
		int actual = business.calculateSum(new int [] {2});
		int expected = 2;
		assertEquals(expected, actual);
	}

	// Comparing Words whether are same 
	@Test
	public void wordsRes() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		SomeDataService dataService = mock(SomeDataService.class);
		when(dataService.allLetters()).thenReturn("JAVA");
		
		business.setSomeDataService(dataService);
		String actual = business.correctWords();
		String expected = "JAVA";
		assertEquals(expected, actual);
	
	}
	
	// Sum of numbers in Array 
	@Test
	public void sumOfNoInArray() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		SomeDataService dataService = mock(SomeDataService.class);
		when(dataService.retrieveAllData()).thenReturn(new int[] {10});
		
		business.setSomeDataService(dataService);
		int actual = business.hesapla();
		int expected = 10;
		assertEquals(expected, actual);
	}
	
	// Index of Letter of o
	@Test
	public void findLetterIndex() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		SomeDataService dataService = mock(SomeDataService.class);
		when(dataService.retrieveAll()).thenReturn(8);
		
		business.setSomeDataService(dataService);
		int actual = business.findingLetter();
		int expected = 7;
		assertEquals(expected, actual);
	}
	
	//Total number of two method
	@Test 
	public void totalOfTwoMethod() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		SomeDataService dataService = mock(SomeDataService.class);
		when(dataService.retrieveAll()).thenReturn(5);
		
		business.setSomeDataService(dataService);
		int actual = business.showingTotalNumber();
		int expected = 5;
		assertEquals(expected, actual);
	}

	
	
	
}