package com.impro.codeabbey.beginner;


import java.util.*;


public class SortWithIndexes {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        String[] input = in.nextLine().split(" ");
        int[] arr = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        sortWithIndexes(arr);
    }

    static void sortWithIndexes(int[] arr) {
        Map<Integer, Integer> indexes = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            indexes.put(arr[i], i+1);
        }
        // sort
        Arrays.sort(arr);

        // loop and get out indexes
        for (int element : arr) {
            System.out.print(indexes.get(element) + " ");
        }
    }
}
