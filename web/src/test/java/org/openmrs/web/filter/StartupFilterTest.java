package org.openmrs.web.filter;

import org.apache.log4j.Appender;
import org.junit.Test;
import org.openmrs.util.MemoryAppender;
import org.openmrs.web.filter.initialization.InitializationFilter;

import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.withSettings;

public class StartupFilterTest {

	@Test
	public void shouldReturnEmptyLogLinesFromAppender() {
		Appender mockAppender = mock(Appender.class);
		List<String> logLines = StartupFilter.getLogLinesFromAppender(mockAppender);
		assertTrue(logLines.isEmpty());
	}

	@Test
	public void shouldReturnLogLinesFromAppender() {
		MemoryAppender mockAppender = mock(MemoryAppender.class, withSettings().extraInterfaces(Appender.class));
		when(mockAppender.getLogLines()).thenReturn(Collections.singletonList("This is a log"));
		Appender appender = (Appender) mockAppender;
		List<String> logLines = StartupFilter.getLogLinesFromAppender(appender);
		assertTrue(logLines.contains("This is a log"));
	}

}
