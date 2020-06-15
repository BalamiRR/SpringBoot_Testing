package com.example.unittesting;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.anything;
import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
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


}