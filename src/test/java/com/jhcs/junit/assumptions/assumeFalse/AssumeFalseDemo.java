package com.jhcs.junit.assumptions.assumeFalse;



import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeFalse;

public class AssumeFalseDemo {
    @Test
    public void assumeFalseWithNoMessage() {
        String envTest = "PROD"; assumeFalse("DEV".equals(envTest)); System.out.println("Suposição passada");
        assertEquals(3, 2 + 1);

    }

    @Test
    public void assumeFalseWithMessage() {
        String envTest = "PROD"; assumeFalse("DEV".equals(envTest), "Suposição falhou");
        System.out.println("Suposição passada"); assertEquals(3, 2 + 1);

    }

    @Test
    public void assumeFalseWithMessageSupplier() {
        String envTest = "PROD"; assumeFalse("DEV".equals(envTest), () -> "Suposição falhou");
        System.out.println("Suposição passada"); assertEquals(3, 2 + 1);

    }

    @Test
    public void assumeFalseWithBooleanSupplierNoMessage() {
        String envTest = "PROD"; assumeFalse(() -> "DEV".equals(envTest)); System.out.println("Suposição passada");
        assertEquals(3, 2 + 1);

    }

    @Test
    public void assumeFalseWithBooleanSupplierAndMessage() {
        String envTest = "PROD"; assumeFalse(() -> "DEV".equals(envTest), "Suposição falhou");
        System.out.println("Suposição passada"); assertEquals(3, 2 + 1);

    }

    @Test
    public void assumeFalseWithBooleanSupplierAndMessageSupplier() {
        String envTest = "PROD"; assumeFalse(() -> "DEV".equals(envTest), () -> "Suposição falhou");
        System.out.println("Suposição passada"); assertEquals(3, 2 + 1);

    }
}
