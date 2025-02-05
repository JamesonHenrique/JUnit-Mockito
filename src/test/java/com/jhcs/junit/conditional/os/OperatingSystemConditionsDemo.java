package com.jhcs.junit.conditional.os;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

public class OperatingSystemConditionsDemo {
    @Test
    @EnabledOnOs(value = {OS.WINDOWS})
    public void enableOnWindows() {
        System.out.println("Somente executado no windows");
    }

    @Test
    @DisabledOnOs(value = {OS.WINDOWS})
    public void disableOnWindows() {
        System.out.println("Executado menos no windows");
    }
}
