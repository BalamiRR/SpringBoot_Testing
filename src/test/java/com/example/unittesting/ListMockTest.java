package com.example.unittesting;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

class ListMockTest {

	@Test
	public void size_basic() {
		List mock = Mockito.mock(List.class);
		when(mock.size()).thenReturn(5);
		assertEquals(5, mock.size());
	}
	
	@Test
	public void returnDiffrentValues() {
		List mock = Mockito.mock(List.class);
		when(mock.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, mock.size());
		assertEquals(10, mock.size());
	}
	
	@Test
	public void returnWithParam() {
		List mock = Mockito.mock(List.class);
		when(mock.get(0)).thenReturn("in28minutes");
		assertEquals("in28minutes", mock.get(0));
		assertEquals(null, mock.get(1));
	}

//	@Test
//	public void returnWithGenericParameters() {
//		List mock = Mockito.mock(List.class);
//		when(mock.get(anyInt())).thenReturn("in28minutes");
//		assertEquals("in28minutes", mock.get(0));
//		assertEquals("in28minutes", mock.get(1));
//	}

	
	@Test
	public void verificationBasic() {

		List mock = Mockito.mock(List.class);
		
		//SUT
		String value = (String) mock.get(0);	
		
		//Verify
		verify(mock).get(0);
		verify(mock, times(2)).get(2);
		verify(mock, atLeastOnce()).get(4);
		verify(mock, atMost(2)).get(5);
		verify(mock, never()).get(2);
		
	}

	
	@Test
	public  void argumentCapturing() {
		
		List mock = Mockito.mock(List.class);
		
		//SUT
		mock.add("SomeString1");
		mock.add("SomeString2");
		
		//Verification
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock, times(2)).add(captor.capture());
		
		List<String> allValues = captor.getAllValues();
		
		assertEquals("SomeString", allValues.get(0));
		assertEquals("SomeString", allValues.get(1));
	}
	

	@Test
	public void spying() {
		ArrayList arrayListSpy = spy(ArrayList.class);
		arrayListSpy.add("Test0");
		
		System.out.println(arrayListSpy.get(0));  // Test0
		System.out.println(arrayListSpy.size()); // 1 olucak
		arrayListSpy.add("Test");
		arrayListSpy.add("Test2");
		System.out.println(arrayListSpy.get(1));  // Test yazisini alicak
		System.out.println(arrayListSpy.size());  // 3 olucak
		
		when(arrayListSpy.size()).thenReturn(5);
		System.out.println(arrayListSpy.size()); // 5 olucak
		
		arrayListSpy.add("Test4");
		System.out.println(arrayListSpy.size()); // 5 olucak
		
	}
	
	
	
	
	
}

