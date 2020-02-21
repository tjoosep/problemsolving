package com.impro.codeabbey.beginner;


import java.util.Scanner;


public class CalcSequence {
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
            printSequence(arr);
        }
    }

    public static void printSequence(int[] arr) {
        int A = arr[0];
        int B = arr[1];
        int N = arr[2];

        int result = 0;
        for (int i = 0; i < N; i++) {
            result += A;
            A = A + B;
        }
        System.out.println(result + " ");
    }
}
