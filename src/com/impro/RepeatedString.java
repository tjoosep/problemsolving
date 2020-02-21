package com.impro;



public class RepeatedString {

    static long repeatedString(String s, long n) {
        long aCounter = 0;
        int len = s.length();

        if (!s.contains("a")) {
            return 0;
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a'){
                aCounter++;
            }
        }

        long div = n / len;
        long remainder = n % len;

        aCounter = aCounter * div;

        for (int i = 0; i < remainder; i++) {
            if (s.charAt(i) == 'a'){
                aCounter++;
            }
        }

        return aCounter;
    }

    public static void main(String[] args) {
        String s = "aba";
        String x = "abaabaabaa"; // 7
        long repeats = 10;

        long result = repeatedString(s, repeats);

        System.out.println(result);
    }

}