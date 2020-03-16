package com.challenges.codeabbey.beginner;


import java.util.Scanner;


public class Triangle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        for (int i = 0; i < n; i++) {
            String[] numbers = in.nextLine().split(" ");
            int[] arr = new int[numbers.length];;
            for (int j = 0; j < numbers.length; j++) {
                arr[j] = Integer.parseInt(numbers[j]);
            }
            isTrianglePosible(arr);
        }
    }

    // it is possible to create triangle if
    static void isTrianglePosible(int[] arr) {
        int a = arr[0];
        int b = arr[1];
        int c = arr[2];

        if (a + b <= c || a + c <= b || b + c <= a) {
            System.out.print(0 + " ");
        } else {
            System.out.print(1 + " ");
        }
    }
}
