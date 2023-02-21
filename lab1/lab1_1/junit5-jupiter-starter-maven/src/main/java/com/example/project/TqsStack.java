package com.example.project;

import java.util.NoSuchElementException;

public class TqsStack {

    private Object[] stack;

    public TqsStack() {
        stack = new Object[0];
    }

    public void push(Object obj) {
        Object[] newStack = new Object[stack.length + 1];
        for (int i = 0; i < stack.length; i++) {
            newStack[i] = stack[i];
        }
        newStack[newStack.length - 1] = obj;
        stack = newStack;
    }

    public Object peek() {
        return stack[stack.length - 1];
    }

    public Object pop() {

        Object obj = stack[stack.length - 1];

        Object[] newStack = new Object[stack.length - 1];
        for (int i = 0; i < newStack.length; i++) {
            newStack[i] = stack[i];
        }
        stack = newStack;
        return obj;

    }

    public int size() {
        return stack.length;
    }

    public boolean isEmpty() {
        if (stack.length == 0) {
            return true;
        }
        return false;
    }
}
