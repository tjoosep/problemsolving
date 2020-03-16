package com.challenges.hackerrank.sorting;




public class BubbleSortEx {

    static void countSwaps(int[] arr){

        int len = arr.length;
        int swaps = 0;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len-1; j++) {
                if (arr[j] > arr[j+1]){
                   int temp = arr[j];
                   arr[j] = arr[j+1];
                   arr[j+1] = temp;
                    swaps++;
                }
            }
        }
        System.out.println("Array is sorted in " + swaps + " swaps.");
        System.out.println("First Element: " + arr[0]);
        System.out.println("Last Element: " + arr[len-1]);
    }

    public static void main(String[] args) {

        int[] a = {6, 4, 2};
        countSwaps(a);
    }
}
