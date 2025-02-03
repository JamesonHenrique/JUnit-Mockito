package com.jhcs.parameterizedTest.enumSource;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EnumSourceDemo {
    @ParameterizedTest
    @EnumSource(value = Animal.class)
    public void enumSourceDemoTest(Animal animal) {
        assertNotNull(animal);
    }
    @ParameterizedTest
    @EnumSource(value = Animal.class, names =  {"DOG","BIRD"})
    public void enumSourceDemoWithNamesTest(Animal animal) {
        assertNotNull(animal);
    }
    @ParameterizedTest
    @EnumSource(value = Animal.class, mode =  EnumSource.Mode.EXCLUDE, names = {"DOG", "BIRD"})
    public void enumSourceDemoWithExcludeModeTest(Animal animal) {
        assertNotNull(animal);
    }
    @EnumSource(value = Animal.class, mode =  EnumSource.Mode.MATCH_ALL, names = "^(C|F).+$")
    public void enumSourceDemoWithMatchAllModeTest(Animal animal) {
        assertNotNull(animal);
    }
}
