package com.jhcs.repeatedTest;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RepeatedTestDemo {
    @BeforeAll
    public static void beforeAll() {
        System.out.println("@BeforeAll executado");
    }

    public RepeatedTestDemo() {
        System.out.println("Constructor executado");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("@beforeEach executado");
    }


    @RepeatedTest(value = 5)
    public void simpleRepeatedTest() {
        assertTrue(0 < 5);
    }

    @AfterEach
    public void afterEach() {
        System.out.println("@afterEach executado");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("@afterAll executado");
    }
}
