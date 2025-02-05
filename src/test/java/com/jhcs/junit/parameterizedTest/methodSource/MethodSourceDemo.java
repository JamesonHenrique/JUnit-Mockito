package com.jhcs.junit.parameterizedTest.methodSource;

import com.jhcs.junit.example.StringHelper;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MethodSourceDemo {
    @ParameterizedTest
    @MethodSource("stringProvider")
    public void methodSourceTest(String value) {
        assertNotNull(value);
    }

    public static Stream<String> stringProvider() {
        return Stream.of("cat", "dog", "bird");
    }
    @ParameterizedTest
    @MethodSource("argumentsProvider")
    public void methodSourceTestWithArguments(String input, String expected) {
        StringHelper stringHelper = new StringHelper();
        assertEquals(expected, stringHelper.reverse(input));
    }
    public static Stream<Arguments> argumentsProvider() {
        return Stream.of(
                Arguments.of("cat", "tac"),
                Arguments.of("dog", "god")

                        );
    }
}
