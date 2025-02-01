package com.jhcs.assumptions.assumingThat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class AssumingThatDemo {
    @Test
    public void assumingThatWithBooleanCondition() {
        String envTest = "DEV"; assumingThat("DEV".equals(envTest), () -> {
            System.out.println("DEV enviroment"); assertEquals(3, 2 + 1);
        }); System.out.println("Suposição passada"); assertEquals(3, 2 + 1);

    }

    @Test
    public void assumingThatWithBooleanSupplier() {
        String envTest = "DEV"; assumingThat(() -> "DEV".equals(envTest), () -> {
            System.out.println("DEV enviroment"); assertEquals(3, 2 + 1);
        }); System.out.println("Suposição passada"); assertEquals(3, 2 + 1);

    }
}
