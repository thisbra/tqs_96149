package com.example.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

public class TqsStackTest {

    // Declare class previously for the BeforeEach
    private TqsStack testStack;
    private Object obj;

    // Annotation to declare the class that will be executed
    //  before every test
    @BeforeEach
    public void setUp() {
        testStack = new TqsStack();
        obj = new Object();
    }

    // a)
    @DisplayName("Test Stack is empty on construction")
    @Test
    void stackIsEmptyOnConstruction() {
        assertEquals(true, testStack.isEmpty());
    }

    // b)
    @DisplayName("Test Stack.size() == 0 on construction")
    @Test
    void stackHasSizeZeroOnConstruction() {
        assertEquals(0, testStack.size());
    }

    // c)
    @DisplayName("Test n pushes to stack has size n")
    @Test
    void stackHasSizeN() {
        for (int i = 0; i < 5; i++) {
            testStack.push(obj);
        }
        assertEquals(false, testStack.isEmpty());
    }

    // d)
    @DisplayName("Test if pushes x, pops x")
    @Test
    void pushXpopX() {
        obj = 1;
        testStack.push(obj);
        assertEquals(1, testStack.pop());
    }

    // e)
    @DisplayName("Test if pushes x, peeks x and size remains the same")
    @Test
    void pushPeekSize() {
        obj = 1;
        testStack.push(obj);
        int v1 = (Integer) testStack.peek();
        int v2 = testStack.size();
        assertEquals(2, v1 + v2);
    }

    // f)
    @DisplayName("Test if size is n ")
    @Test
    void emptyAfterNPops() {
        int n = 5;
        for (int i = 0; i < n; i++) {
            testStack.push(obj);
        }
        for (int i = 5; i > 0; i--) {
            testStack.pop();
        }
        assertEquals(0, testStack.size(), "After n pops, the stack should have length 0");
    }

    // g)
    @DisplayName("Popping from an empty stack does throw a NoSuchElementException")
    @Test
    void popThrowException() {
        assertThrows(ArrayIndexOutOfBoundsException.class, testStack::pop, "Pop on empty not returning");
    }

    //h)
    @DisplayName("Peeking into an empty stack does throw a NoSuchElementException")
    @Test
    void peekThrowException() {
        assertThrows(ArrayIndexOutOfBoundsException.class, testStack::peek, "Peek on empty not returning");
    }

    //i)
}






