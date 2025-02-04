package com.jhcs.dynamicTest;

import com.jhcs.example.StringHelper;
import org.junit.jupiter.api.DynamicContainer;
import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DynamicTestDemo {
    StringHelper stringHelper = new StringHelper();
    @TestFactory
    public DynamicTest testReverse() {

       return  DynamicTest.dynamicTest(("Teste dinamico para reverter um texto"), () -> {

         assertEquals("god", stringHelper.reverse("dog"));
        });
    }
    @TestFactory
    public Collection<DynamicTest> dynamicTestsFromCollection() {
        List<String> inputList = createInputList();
        List<String> outputList = createOutputList();
        Collection<DynamicTest> dynamicTests = new ArrayList<>();
        for (int i = 0; i < inputList.size(); i++) {
            String input = inputList.get(i);
            String output = outputList.get(i);
            DynamicTest dynamicTest = DynamicTest.dynamicTest("Teste dinamico para reverter um texto",
                    () -> assertEquals(output, stringHelper.reverse(input)));
            dynamicTests.add(dynamicTest);
        }
        return dynamicTests;
    }
    private List<String> createInputList() {
        return Arrays.asList("cat", "dog", "bird");
    }
    @TestFactory
    public Stream<DynamicNode> dynamicTestsWithDynamicContainers() {
        return createInputList()
                .stream()
                .map(
                        input -> DynamicContainer.dynamicContainer("Container dinamico para reverter um texto",
                                Stream.of(
                                        DynamicTest.dynamicTest("Teste dinamico para reverter um texto",
                                                () -> assertEquals("tac", stringHelper.reverse("cat"))),
                                        DynamicTest.dynamicTest("Teste dinamico para reverter um texto",
                                                () -> assertEquals("god", stringHelper.reverse("dog"))),
                                        DynamicTest.dynamicTest("Teste dinamico para reverter um texto",
                                                () -> assertEquals("drib", stringHelper.reverse("bird")))
                                )
                        )
                    );

    }
    private List<String> createOutputList() {
        return Arrays.asList("tac", "god", "drib");
    }
    @TestFactory
    public Iterator<DynamicTest> dynamicTestsFromIterator() {
        List<String> inputList = createInputList();
        List<String> outputList = createOutputList();
        Collection<DynamicTest> dynamicTests = new ArrayList<>();
        for (int i = 0; i < inputList.size(); i++) {
            String input = inputList.get(i);
            String output = outputList.get(i);
            DynamicTest dynamicTest = DynamicTest.dynamicTest("Teste dinamico para reverter um texto",
                    () -> assertEquals(output, stringHelper.reverse(input)));
            dynamicTests.add(dynamicTest);
        }
        return dynamicTests.iterator();
    }

    @TestFactory
    public Stream<DynamicTest> dynamicTestsFromStream() {
        List<String> inputList = createInputList();
        List<String> outputList = createOutputList();
        Collection<DynamicTest> dynamicTests = new ArrayList<>();
        for (int i = 0; i < inputList.size(); i++) {
            String input = inputList.get(i);
            String output = outputList.get(i);
            DynamicTest dynamicTest = DynamicTest.dynamicTest("Teste dinamico para reverter um texto",
                    () -> assertEquals(output, stringHelper.reverse(input)));
            dynamicTests.add(dynamicTest);
        }
        return dynamicTests.stream();
    }
    @TestFactory
    public DynamicTest[] dynamicTestsFromArrays() {
        List<String> inputList = createInputList();
        List<String> outputList = createOutputList();
        Collection<DynamicTest> dynamicTests = new ArrayList<>();
        for (int i = 0; i < inputList.size(); i++) {
            String input = inputList.get(i);
            String output = outputList.get(i);
            DynamicTest dynamicTest = DynamicTest.dynamicTest("Teste dinamico para reverter um texto",
                    () -> assertEquals(output, stringHelper.reverse(input)));
            dynamicTests.add(dynamicTest);
        }
        return dynamicTests.toArray(new DynamicTest[dynamicTests.size()]);
    }

}
