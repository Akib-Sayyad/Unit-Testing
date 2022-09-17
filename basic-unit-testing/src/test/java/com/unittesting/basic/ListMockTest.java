package com.unittesting.basic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

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
		
		System.out.println(allValues + " " + captor.capture());
		
		assertEquals("Dummy1", allValues.get(0));
		assertEquals("Dummy2", allValues.get(1));

	}

}
