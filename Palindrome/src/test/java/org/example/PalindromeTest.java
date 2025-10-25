package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class PalindromeTest {

    private Palindrome palindrome;

    @BeforeEach
    void setUp() {
        palindrome = new Palindrome();
    }

    @Test
    void testSingleDigitPalindrome() {
        palindrome.setNumber(5);
        assertTrue(palindrome.isPalindrome());
    }

    @Test
    void testTwoDigitPalindrome() {
        palindrome.setNumber(55);
        assertTrue(palindrome.isPalindrome());
    }

    @Test
    void testTwoDigitNonPalindrome() {
        palindrome.setNumber(57);
        assertFalse(palindrome.isPalindrome());
    }

    @Test
    void testMultiDigitPalindrome() {
        palindrome.setNumber(12321);
        assertTrue(palindrome.isPalindrome());
    }

    @Test
    void testMultiDigitNonPalindrome() {
        palindrome.setNumber(12345);
        assertFalse(palindrome.isPalindrome());
    }

    @Test
    void testLargePalindrome() {
        palindrome.setNumber(1234554321L);
        assertTrue(palindrome.isPalindrome());
    }

    @Test
    void testNegativeNumber() {
        palindrome.setNumber(-121);
        assertFalse(palindrome.isPalindrome());
    }

    @Test
    void testZero() {
        palindrome.setNumber(0);
        assertTrue(palindrome.isPalindrome());
    }
}