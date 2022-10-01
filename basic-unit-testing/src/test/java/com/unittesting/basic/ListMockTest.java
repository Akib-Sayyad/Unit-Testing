package com.unittesting.basic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

public class ListMockTest {

	List<String> mock = mock(List.class);

	@Test
	public void sizeBasic() {
		when(mock.size()).thenReturn(5);
		assertEquals(5, mock.size());
	}

	@Test
	public void returnMultipleValues() {
		when(mock.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, mock.size());
		assertEquals(10, mock.size());
	}

	@Test
	public void returnParameter() {
		when(mock.get(0)).thenReturn("Test0");
		assertEquals("Test0", mock.get(0));
		assertEquals(null, mock.get(1));
	}

	@Test
	public void returnGenericParameter() {
		when(mock.get(anyInt())).thenReturn("Test1");
		// ArgumentMatchers
		assertEquals("Test1", mock.get(0));
		assertEquals("Test1", mock.get(1));
	}

	// verify executions
	@Test
	public void verificationBasic() {
		String v1 = mock.get(0);
		String v2 = mock.get(1);

		verify(mock).get(0);
		verify(mock, times(2)).get(anyInt());
		verify(mock, atLeast(1)).get(anyInt());
		verify(mock, atMost(2)).get(anyInt());
		verify(mock, atLeastOnce()).get(anyInt());
		verify(mock, atMostOnce()).get(0);
		verify(mock, never()).get(2);
	}

	// ARGUMENT CAPTURE
	@Test
	public void argumentCapture() {
		mock.add("Dummy");

		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock).add(captor.capture()); // capture the argument call on method ie. Dummy

		assertEquals("Dummy", captor.getValue());
	}

	// MULTIPLE ARGUMENT CAPTURE
	@Test
	public void multipleArgumentCapture() {
		mock.add("Dummy1");
		mock.add("Dummy2");

		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

		verify(mock, times(2)).add(captor.capture());

		List<String> allValues = captor.getAllValues();
		
		System.out.println("captor value:" + allValues);
		
		assertEquals("Dummy1", allValues.get(0));
		assertEquals("Dummy2", allValues.get(1));

	}
	// Mocking
	@Test
	@Ignore
	public void mockTest() {
		ArrayList<String> mock = mock(ArrayList.class);
		System.out.println(mock.get(0)); // null
		System.out.println(mock.size()); //0
		mock.add("Dummy1");
		System.out.println(mock.size()); //0
		mock.add("Dummy2");
		System.out.println(mock.get(0)); //null
		System.out.println(mock.size()); //0
		
		when(mock.size()).thenReturn(5); // always return set value  
		System.out.println(mock.size());//5
		mock.add("Dummy3");
		System.out.println(mock.size()); //5
		System.out.println(mock.get(5)); // null
	}

	// Spying
	@Test
	public void spyTest() {
		ArrayList<String> spy = spy(ArrayList.class);
		// System.out.println(spy.get(0)); // IndexOutOfBoundException
		System.out.println(spy.size()); // 0
		spy.add("Dummy1");
		System.out.println(spy.size()); // 1
		spy.add("Dummy2");
		System.out.println(spy.get(0)); // Dummy1
		System.out.println(spy.size()); // 2

		when(spy.size()).thenReturn(5); // always return set value
		System.out.println(spy.size()); // 5
		spy.add("Dummy3");
		System.out.println(spy.size()); // 5
		System.out.println(spy.get(5)); // Exception
	}
	

}
