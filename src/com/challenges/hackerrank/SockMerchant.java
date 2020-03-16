package com.challenges.hackerrank;

import java.io.*;
import java.util.*;

public class SockMerchant {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] arr) {
        int totalPairs = 0;
        Map<Integer, Integer> socks = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (socks.containsKey(arr[i])){
                int value = socks.get(arr[i]);
                socks.put(arr[i], value + 1);
            } else {
                socks.put(arr[i], 1);
            }
        }

        for (Integer a : socks.values()) {
            totalPairs += a / 2;
        }

        return totalPairs;
    }

    static int socksMerch(int n, int[] c){
        Set<Integer> colors = new HashSet<>();
        int paris = 0;

        for (int i = 0; i < n; i++) {
            if (!colors.contains(c[i])){
                colors.add(c[i]);
            }
            else {
                paris++;
                colors.remove(c[i]);
            }
        }
        return paris;
    }

    public static void main(String[] args) throws IOException {
        int n = 7;
        int[] ar = {1,2,1,2,1,3,2};

        int a = 9;
        int[] arr = {10 ,20, 20, 10 ,10,30,50,10,20};

        int b = 3;
        int[] arrr = {1,2,3};

        int result = sockMerchant(n, ar);
        System.out.println(result); // 2

        int result2 = socksMerch(a, arr);
        System.out.println(result2); // 3

        int result3 = sockMerchant(b, arrr);
        System.out.println(result3);
    }
}
