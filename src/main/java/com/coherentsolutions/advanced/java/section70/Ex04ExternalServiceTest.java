package com.coherentsolutions.advanced.java.section70;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Demonstrates using Mockito to mock external dependencies in stream tests.
 */
public class Ex04ExternalServiceTest {

    /**
     * Tests the stream pipeline that depends on an external service using mocks.
     */
    @Test
    public void testStreamWithExternalService() {
        // Mock external service
        ExternalService service = mock(ExternalService.class);
        when(service.getData()).thenReturn(List.of("data1", "data2", "data3"));

        // Stream pipeline using the mocked service
        List<String> processedData = service.getData().stream()
                .map(String::toUpperCase)
                .toList();

        // Assert that the processed data is as expected
        assertEquals(List.of("DATA1", "DATA2", "DATA3"), processedData);
    }

    /**
     * Mocked external service interface.
     */
    interface ExternalService {
        List<String> getData();
    }
}
