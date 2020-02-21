package com.impro.company;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


/* Max Stock Prices */
public class Cyber3 {

    public static long maximumProfit(List<Integer> price) {
        long profit = 0L;
        int maxAtGivenMoment = 0;

        for (int i = price.size() -1; i > -1; i--){
            if (price.get(i) >= maxAtGivenMoment) {
                maxAtGivenMoment = price.get(i);
            }

            profit += maxAtGivenMoment - price.get(i);
        }

        return profit;
    }


    public static void main(String[] args) {
        List<Integer> s = new ArrayList<>();
        s.add(-5);
        s.add(4);
        s.add(-2);
        s.add(3);
        s.add(1);
        s.add(-1);
        s.add(-6);
        s.add(-1);
        s.add(0);
        s.add(5);

        List<Integer> p = new ArrayList<>();
        p.add(5);
        p.add(-5);
        p.add(4);
        p.add(-2);
        p.add(3);
        p.add(1);

        int[] arr = {-5, 4, -2, 3, 1};

        List<Integer> price = new ArrayList<>();
        price.add(1);
        price.add(2);
        price.add(100);

        List<Integer> price2 = new ArrayList<>();
        price2.add(5);
        price2.add(3);
        price2.add(2);

        int[] arr2 = {-5, 4, -2, 3, 1, -1, -6, -1, 0, 5};

        System.out.println(maximumProfit(price));
        System.out.println(maximumProfit(price2));
//        System.out.println(minPower(s));
//        System.out.println(minPower(p));

    }

}
