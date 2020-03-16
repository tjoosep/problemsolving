package com.challenges.codeabbey.beginner;


import java.util.Scanner;


class Solution1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        int[] arr2 = new int[n];

        for(int i=0; i<n; i++ ) {
            arr[i] = in.nextInt();
            arr2[i] = in.nextInt();
        }

        for (int r : sumLoops(arr, arr2)){
            System.out.print(r + " ");
        }

    }

    public static int[] sumLoops(int[] arr, int[] arr2) {
        int[] total = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            total[i] = arr[i] + arr2[i];
        }

        return total;
    }

    public void inputStrings(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];


        for(int i=0; i<n; i++ ) {
            arr[i] = in.nextInt();
        }

        System.out.print("as");
    }
}