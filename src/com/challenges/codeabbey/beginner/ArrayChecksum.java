package com.challenges.codeabbey.beginner;

import java.util.*;

public class ArrayChecksum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String[] elements = in.nextLine().split(" ");
        long[] numbers = new long[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Long.parseLong(elements[i]);
        }
        calcArrayChecksum(numbers);
    }
    //2266562
    //496 775515 7 660 43543 399018 5144137 77926 8648637 9987 6145 38943966 519983 709 500000268 2093 189382 36590256 262892 1934873 2661698 467641 7770714 490 622443482 34247
    static void calcArrayChecksum(long[] nums) {
        int seed = 113;
        long mod  = 10000007;
        long result = 0;

        for (long num : nums) {
            result = (result + num) * seed;
            if (result > mod) {
                result = result % mod;
            }
        }
        System.out.println(result);
    }
}
