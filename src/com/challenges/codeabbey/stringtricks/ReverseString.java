package com.challenges.codeabbey.stringtricks;

import java.util.*;


public class ReverseString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String inputString = in.nextLine();
        System.out.println(reverseString(inputString));
    }

    static String reverseString(String str) {
        byte[] strBytes = str.getBytes();
        byte[] result = new byte[strBytes.length];

        for (int i = 0; i < strBytes.length; i++) {
            result[i] = strBytes[strBytes.length-i - 1];
        }

        return new String(result);
    }
}