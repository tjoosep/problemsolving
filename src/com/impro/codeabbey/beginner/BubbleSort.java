package com.impro.codeabbey.beginner;


import java.util.*;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] input = in.nextLine().split(" ");
        long[] arr = new long[input.length-1];
        for (int i = 0; i < input.length-1; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
    }


}
