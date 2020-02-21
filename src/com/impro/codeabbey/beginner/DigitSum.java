package com.impro.codeabbey.beginner;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class DigitSum {
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
            System.out.print(findTotalOfDigits(arr) + " ");
        }
    }
    /*
        1492 div 10 = 149 and 2 as a remainder
        149 div 10 = 14 and 9 as a remainder
        14 div 10 = 1 and 4 as a remainder
        1 div 10 = 0 and 1 as a remainder
     */
    public static int findTotalOfDigits(int[] arr){
        int A = arr[0];
        int B = arr[1];
        int C = arr[2];

        int result = A * B + C;
        int total = 0;

        List<Integer> digits = new ArrayList<>();
        collectDigits(result, digits);

        for (Integer digit : digits) {
            total += digit;
        }
        return total;
    }

    public static void collectDigits(int num, List<Integer> digits) {
        if(num / 10 > 0) {
            collectDigits(num / 10, digits);
        }
        digits.add((num % 10));
    }
}
