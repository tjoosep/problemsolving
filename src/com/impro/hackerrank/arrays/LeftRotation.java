package com.impro.hackerrank.arrays;


import java.util.Arrays;


public class LeftRotation {

    static int[] rotLeft(int[] a, int numberOfRotations) {

        int len = a.length;
        int[] result = new int[len];

        for (int i = 0; i < a.length; i++) {
            int newIndex = (i + numberOfRotations) % len;
            result[i] = a[newIndex];
        }

        return result;
    }

    public static void main(String[] args) {

        int[] a = {1,2,3,4,5};
        int d = 4;
        int[] res = rotLeft(a, d);

        System.out.println(Arrays.toString(res));

    }
}
