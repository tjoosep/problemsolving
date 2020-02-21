package com.impro.codeabbey.beginner;


import java.util.*;


public class ArrayCounters {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        in.nextLine();

        List<Integer> arr = new ArrayList<>();
        String[] numbers = in.nextLine().split(" ");
        for (String number : numbers) {
            arr.add(Integer.parseInt(number));
        }
        countNumbers(arr, n);
    }

    static void countNumbers(List<Integer> arr, int n) {
        Map<Integer, Integer> result = new HashMap<>();

        for (Integer num : arr) {
            if (result.containsKey(num)) {
                result.put(num, result.get(num) + 1);
            } else {
                result.put(num, 1);
            }
        }

        int i = 0;
        for (Integer res : result.values()) {
            if (i == n) {
                break;
            }
            System.out.print(res + " ");
            i++;
        }

    }
}
