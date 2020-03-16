package com.challenges.hackerrank.search;

import java.util.*;


public class MaximumSubarraySum {

    public static void main(String[] args) {
        long   m = 7;
        long[] n = {3, 3, 9, 9, 5};

        System.out.println(maximumSum(n, m));
    }

    /*
    static long maximumSum(long[] a, long m) {
        long maxSum=0;

        TreeSet<Long> prefix = new TreeSet<Long>();
        long currSum=0;

        for(int i=0;i<a.length;i++){
            currSum=(currSum+a[i]%m)%m;
            maxSum=Math.max(maxSum, currSum);

            Long pr = prefix.higher(currSum);
            if(pr != null){
                maxSum= Math.max(maxSum, (currSum-pr+m)%m);
            }
            prefix.add(currSum);
        }

        return maxSum;
    }
     */

    static long maximumSum(long[] arr, long m) {
        long bestResult = 0;

        for (int i = 0; i < arr.length; i++) {
            List<Long> subArray = new ArrayList<>();
            for (int j = i; j < arr.length; j++) {
                subArray.add(arr[j]);

                long sum = 0;
                for (Long element : subArray) {
                    sum += element;
                }

                if (sum % m > bestResult) {
                    bestResult = sum % m;
                }
            }
        }
        return bestResult;
    }
}
