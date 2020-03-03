package com.impro.codeabbey.stringtricks;

import java.util.*;

public class Palindrome {

    public enum ANSWER { N, Y };

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        for (int i = 0; i < n; i++) {
            String input = in.nextLine();
            System.out.print(isPalindrome(input) + " ");
        }
    }

    // check if start and end chars match every time
    static ANSWER isPalindrome(String str) {
        String parsedStr = removeSpaceAndPunctuations(str);

        int right = parsedStr.length() - 1;

        for (int left = 0; left < parsedStr.length(); left++, right--) {
            if (parsedStr.charAt(left) != parsedStr.charAt(right)) {
                return ANSWER.N;
            }
        }
        return ANSWER.Y;
    }
    // remove all punctuations and spaces from string
    private static String removeSpaceAndPunctuations(String str) {
        return str.replaceAll("\\p{Punct}", "").toLowerCase().replaceAll(" ", "");
    }
}
