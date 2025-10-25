package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

class FibonacciTest {

    private Fibonacci fibonacci;

    @BeforeEach
    void setUp() {
        fibonacci = new Fibonacci();
    }

    @Test
    void testFibonacciWithOneNumber() {
        fibonacci.setN(1);
        fibonacci.fibonacci();
        Vector<Integer> result = fibonacci.getVector();

        assertEquals(1, result.size());
        assertEquals(0, result.get(0));
    }

    @Test
    void testFibonacciWithTwoNumbers() {
        fibonacci.setN(2);
        fibonacci.fibonacci();
        Vector<Integer> result = fibonacci.getVector();

        assertEquals(2, result.size());
        assertEquals(0, result.get(0));
        assertEquals(1, result.get(1));
    }

    @Test
    void testFibonacciWithFiveNumbers() {
        fibonacci.setN(5);
        fibonacci.fibonacci();
        Vector<Integer> result = fibonacci.getVector();

        assertEquals(5, result.size());
        assertEquals(0, result.get(0));
        assertEquals(1, result.get(1));
        assertEquals(1, result.get(2));
        assertEquals(2, result.get(3));
        assertEquals(3, result.get(4));
    }

    @Test
    void testFibonacciWithTenNumbers() {
        fibonacci.setN(10);
        fibonacci.fibonacci();
        Vector<Integer> result = fibonacci.getVector();

        assertEquals(10, result.size());
        int[] expected = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34};
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], result.get(i));
        }
    }

    @Test
    void testFibonacciWithZero() {
        fibonacci.setN(0);
        fibonacci.fibonacci();
        Vector<Integer> result = fibonacci.getVector();

        assertTrue(result.isEmpty());
    }

    @Test
    void testFibonacciWithNegativeNumber() {
        fibonacci.setN(-5);
        fibonacci.fibonacci();
        Vector<Integer> result = fibonacci.getVector();

        assertTrue(result.isEmpty());
    }

    @Test
    void testFibonacciSequenceCorrectness() {
        fibonacci.setN(7);
        fibonacci.fibonacci();
        Vector<Integer> result = fibonacci.getVector();

        Vector<Integer> expected = new Vector<>();
        expected.add(0);
        expected.add(1);
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(5);
        expected.add(8);

        assertEquals(expected, result);
    }

    @Test
    void testVectorIsCleared() {
        fibonacci.setN(3);
        fibonacci.fibonacci();
        Vector<Integer> firstResult = new Vector<>(fibonacci.getVector());

        fibonacci.setN(2);
        fibonacci.fibonacci();
        Vector<Integer> secondResult = fibonacci.getVector();

        assertEquals(2, secondResult.size());
        assertNotEquals(firstResult.size(), secondResult.size());
    }
}