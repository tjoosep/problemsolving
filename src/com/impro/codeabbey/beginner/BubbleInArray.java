package com.impro.codeabbey.beginner;


import java.util.*;


public class BubbleInArray {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] input = in.nextLine().split(" ");
        long[] arr = new long[input.length-1];
        for (int i = 0; i < input.length-1; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        bubbleInArray(arr);
    }

    static void bubbleInArray(long[] arr) {
        int swaps = 0;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] > arr[i+1]) {
                long temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
                swaps++;
            }
        }

        System.out.print(swaps + " " + calcArrayChecksum(arr));
    }

    static long calcArrayChecksum(long[] nums) {
        int seed = 113;
        long mod  = 10000007;
        long result = 0;

        for (long num : nums) {
            result = (result + num) * seed;
            if (result > mod) {
                result = result % mod;
            }
        }
        return result;
    }

}
