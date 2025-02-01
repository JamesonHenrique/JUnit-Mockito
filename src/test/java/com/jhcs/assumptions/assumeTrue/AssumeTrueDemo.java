package com.jhcs.assumptions.assumeTrue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class AssumeTrueDemo {
    @Test
    public void assumeTrueWithNoMessage() {
        String envTest = "DEV"; assumeTrue("DEV".equals(envTest)); System.out.println("Suposição passada");
        assertEquals(3, 2 + 1);

    }

    @Test
    public void assumeTrueWithMessage() {
        String envTest = "DEV"; assumeTrue("DEV".equals(envTest), "Suposição falhou");
        System.out.println("Suposição passada"); assertEquals(3, 2 + 1);

    }

    @Test
    public void assumeTrueWithMessageSupplier() {
        String envTest = "DEV"; assumeTrue("DEV".equals(envTest), () -> "Suposição falhou");
        System.out.println("Suposição passada"); assertEquals(3, 2 + 1);

    }

    @Test
    public void assumeTrueWithBooleanSupplierNoMessage() {
        String envTest = "DEV"; assumeTrue(() -> "DEV".equals(envTest)); System.out.println("Suposição passada");
        assertEquals(3, 2 + 1);

    }

    @Test
    public void assumeTrueWithBooleanSupplierAndMessage() {
        String envTest = "DEV"; assumeTrue(() -> "DEV".equals(envTest), "Suposição falhou");
        System.out.println("Suposição passada"); assertEquals(3, 2 + 1);

    }

    @Test
    public void assumeTrueWithBooleanSupplierAndMessageSupplier() {
        String envTest = "DEV"; assumeTrue(() -> "DEV".equals(envTest), () -> "Suposição falhou");
        System.out.println("Suposição passada"); assertEquals(3, 2 + 1);

    }
}
