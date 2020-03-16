package com.challenges.codeabbey.beginner;


import java.util.*;


public class WeightedSumOfDigits {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        String[] numbers = in.nextLine().split(" ");
        int[] arr = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = Integer.parseInt(numbers[i]);
        }
        wsd(arr);
    }

    static void wsd(int[] arr){
        for (int number : arr) {
            List<Integer> digits = new ArrayList<>();
            collectDigits(number, digits);
            int result = 0;
            int j = 1;
            for (Integer digit : digits) {
                result += (j * digit);
                j++;
            }
            System.out.print(result + " ");
        }
    }
    public static void collectDigits(int num, List<Integer> digits) {
        if (num / 10 > 0) {
            collectDigits(num / 10, digits);
        }
        digits.add((num % 10));
    }
}
