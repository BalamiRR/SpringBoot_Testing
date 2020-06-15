package com.example.unittesting;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeEach;
import com.example.unittesting.data.SomeDataService;
import com.example.unittesting.business.SomeBusinessImpl;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeBusinessMockTest {

	@InjectMocks
	SomeBusinessImpl business = new SomeBusinessImpl();
	
	@Mock
	SomeDataService dataServiceMock = mock(SomeDataService.class);

	@BeforeEach
	public void before() {
		business.setSomeDataService(dataServiceMock);
	}
	
	@Test
	public void calculateSumUsingDataService_basic() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1,2,3});

		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
	}
	
	//Or we can in this way below
	 
	@Test
	public void calculateSumUsingDataService_empty() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		SomeDataService dataServiceMock = mock(SomeDataService.class);
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});

		business.setSomeDataService(dataServiceMock);
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
	}
	
	// Or can simply write inline
	
	@Test
	public void calculateSumUsingDataService_oneValue() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		SomeDataService dataServiceMock = mock(SomeDataService.class);
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {5});

		business.setSomeDataService(dataServiceMock);
		assertEquals(5, business.calculateSumUsingDataService());
	}

	// or diffrent version of upper one
	@Test
	public void calculate_Sum() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		SomeDataService dataServiceMock = mock(SomeDataService.class);
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {2});
		
		business.setSomeDataService(dataServiceMock);
		int actualResult = business.calculateSum(new int[] {2});
		int expectedResult = 2;
		assertEquals(expectedResult, actualResult);
		
	}
	
	//=================================================================$
	//	@Test														  
	//	public void calculateSumUsingDataService_oneValue() {
	//		SomeBusinessImpl business = new SomeBusinessImpl();
	//		business.setSomeDataService(new SomeDataOneElementStub());
	//		int actualResult = business.calculateSumUsingDataService();
	//		int expectedResult = 5;
	//		assertEquals(expectedResult, actualResult);
	//	}
	//=================================================================$
	
	
	@Test
	public void calculateSum_basic() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		int actualResult = business.calculateSum(new int[] {1,2,3});
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
	}
 
	
	@Test
	public void calculateSum_empty() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		int actualResult = business.calculateSum(new int[] {});
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
	}
	
	
	@Test
	public void calculateSum_oneValue() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		int actualResult = business.calculateSum(new int[] {5});
		int expectedResult = 5;
		assertEquals(expectedResult, actualResult);

	}
}