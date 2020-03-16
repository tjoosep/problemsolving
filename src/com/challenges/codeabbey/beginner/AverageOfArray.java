package com.challenges.codeabbey.beginner;

import java.util.*;

public class AverageOfArray {

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
            findAverage(arr);
        }
    }
    // Correct 286 7485 125 223 2317 106 1997 1110 408 3927 1164 318
    // Actual  286 7485 125 223 2316 105 1997 1110 408 3927 1163 318
    static void findAverage(int[] arr) {
        int result = 0;
        for (int num : arr) {
            if (num == 0) {
                break;
            }
            result += num;
        }
        float avg = (float) result / (arr.length - 1);

        System.out.print( Math.round(avg) + " ");
    }
}
