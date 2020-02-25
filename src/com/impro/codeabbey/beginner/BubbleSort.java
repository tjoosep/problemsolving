package com.impro.codeabbey.beginner;


import java.util.*;

public class BubbleSort {
    public static void main(String[] args) {
        /*
        Scanner in = new Scanner(System.in);
        String[] input = in.nextLine().split(" ");
        long[] arr = new long[input.length-1];
        for (int i = 0; i < input.length-1; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

         */
        //15, 18, 13, 12, 2, 9, 6, 7, 5, 8, 4, 3, 14, 1, 11, 10, 17, 16
        //14 83
        int[] a = new int[] {15, 18, 13, 12, 2, 9, 6, 7, 5, 8, 4, 3, 14, 1, 11, 10, 17, 16};
        bubbleSort(a);

    }
    
    static void bubbleSort(int[] arr) {
        int swaps = 0;
        int passes = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] <= arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    swaps++;
                }
            }
            passes++;
        }
        System.out.println(Arrays.toString(arr));
        System.out.print(swaps + " " + passes + " ");
    }

}
