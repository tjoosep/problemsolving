package com.impro.codeabbey.beginner;


import java.util.Scanner;


public class FindMedian {

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
            searchMedian(arr);
        }
    }

    // 7 < 5 < 3  = 7 3 5
    // 15 < 20 < 40
    static void searchMedian(int[] arr) {
        int a = arr[0];
        int b = arr[1];
        int c = arr[2];

        if (a < b && a > c || a < c && a > b){
            System.out.print(a + " ");
        }
        if (b < c && b > a || b > c && b < a){
            System.out.print(b + " ");
        }
        if (c < a && c > b || c > a && c < b) {
            System.out.print(c + " ");
        }
    }
}
