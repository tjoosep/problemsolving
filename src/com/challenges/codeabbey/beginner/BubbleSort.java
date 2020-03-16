package com.challenges.codeabbey.beginner;


import java.util.*;

public class BubbleSort {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        String[] input = in.nextLine().split(" ");
        int[] arr = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        bubbleSort(arr);

    }
    
    static void bubbleSort(int[] numbers) {
        int swaps = 0;
        int pass = 0;
        boolean sorted = false;

        while (!sorted) {
            sorted = true;
            for (int i = 0; i < numbers.length-1; i++) {
                if (numbers[i] > numbers[i+1]) {
                    sorted = false;
                    swaps++;

                    int temp = numbers[i];
                    numbers[i] = numbers[i+1];
                    numbers[i+1] = temp;
                }
            }
            pass++;
        }
        System.out.print(pass + " " + swaps + " ");
    }

}
