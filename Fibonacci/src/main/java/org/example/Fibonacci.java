package org.example;

import java.util.Scanner;
import java.util.Vector;

public class Fibonacci {
    private Scanner scanner = new Scanner(System.in);
    private Integer n;
    private Vector<Integer> vector = new Vector<>();

    public void enterN(){
        System.out.print("Введите натуральное число n: ");
        n = scanner.nextInt();
    }

    public void setN(int n) {
        this.n = n;
    }

    public Vector<Integer> getVector() {
        return vector;
    }

    public void fibonacci(){
        vector.clear();

        if (n <= 0) {
            System.out.println("Число должно быть натуральным (n > 0)");
            return;
        }

        if (n >= 1) {
            vector.add(0);
        }
        if (n >= 2) {
            vector.add(1);
        }

        for (int i = 2; i < n; i++) {
            int next = vector.get(i - 1) + vector.get(i - 2);
            vector.add(next);
        }

        System.out.println("Результат: " + vector);
    }
}