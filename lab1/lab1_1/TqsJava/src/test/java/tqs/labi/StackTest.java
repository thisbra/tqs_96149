package tqs.labi;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;

public class StackTest {

    // Declare class previously for the BeforeEach
    private Stack testStack;
    private Object obj;

    // Annotation to declare the class that will be executed
    //  before every test
    @BeforeEach
    public void setUp() {
        testStack = new Stack();
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
        assertEquals(2, v1+v2);
    }

    // f)
    // @DisplayName("Test if size is n ")

}
