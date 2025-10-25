package org.example;

import java.util.Scanner;

public class Palindrome {
    private Scanner scanner = new Scanner(System.in);
    private Long number;

    public void enterNumber() {
        System.out.print("Введите число для проверки на палиндром: ");
        number = scanner.nextLong();
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public Long getNumber() {
        return number;
    }

    public boolean isPalindrome() {
        if (number == null) {
            System.out.println("Число не задано");
            return false;
        }

        if (number < 0) {
            System.out.println("Отрицательные числа не могут быть палиндромами");
            return false;
        }

        String str = number.toString();
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public void checkAndPrint() {
        boolean result = isPalindrome();
        System.out.println("Число " + number + (result ? " является палиндромом" : " не является палиндромом"));
    }
}