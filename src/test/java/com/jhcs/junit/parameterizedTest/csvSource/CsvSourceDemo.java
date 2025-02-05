package com.jhcs.junit.parameterizedTest.csvSource;

import com.jhcs.junit.example.StringHelper;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CsvSourceDemo {
    @ParameterizedTest
    @CsvSource({"car, rac"})
    public void csvSourceDemoTest(String input, String expect) {
        StringHelper stringHelper = new StringHelper();

        assertEquals(expect, stringHelper.reverse(input));
    }
    @ParameterizedTest
    @CsvSource({
            "car, 'my, car'",
            "car, ''"

    })
    public void csvSourceDemoWithSingleQuotes(String first, String second) {
        assertNotNull(first);
        assertNotNull(second);
    }

    @ParameterizedTest
    @CsvSource({
            "One, 2"
    })
    public void csvSourceDemoWithIntegers(String first, Integer second) {
        assertNotNull(first);
        assertNotNull(second);
    }
}
