package org.openmrs.web.filter.initialization;

import org.apache.log4j.Appender;
import org.junit.Test;
import org.openmrs.util.MemoryAppender;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Tests {@link InitializationFilter}.
 */
public class InitializationFilterTest {

	@Test
	public void shouldReturnEmptyLogLinesFromAppender() {
		Appender mockAppender = mock(Appender.class);
		List<String> logLines = InitializationFilter.getLogLinesFromAppender(mockAppender);
		assertTrue(logLines.isEmpty());
	}	
	
	@Test
	public void shouldReturnLogLinesFromAppender() {
		MemoryAppender mockAppender = mock(MemoryAppender.class);
		when(mockAppender.getLogLines()).thenReturn(Arrays.asList("This is a log"));
		List<String> logLines = InitializationFilter.getLogLinesFromAppender(mockAppender);
		assertTrue(logLines.contains("This is a log"));
	}
	
}
