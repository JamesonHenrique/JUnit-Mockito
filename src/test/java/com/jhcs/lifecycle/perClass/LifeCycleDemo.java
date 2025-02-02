package com.jhcs.lifecycle.perClass;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LifeCycleDemo {
    @BeforeAll
    public void beforeAll() {
        System.out.println("@beforeAll executado");
    }

    public LifeCycleDemo() {
        System.out.println("Constructor executado");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("@beforeEach executado");
    }

    @Test
    public void testOne() {
        System.out.println("testOne executado");
    }

    @Test
    public void testTwo() {
        System.out.println("testTwo executado");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("@afterEach executado");
    }

    @AfterAll
    public void afterAll() {
        System.out.println("@afterAll executado");
    }
}
