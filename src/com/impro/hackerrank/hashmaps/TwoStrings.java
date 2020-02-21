package com.impro.hackerrank.hashmaps;


public class TwoStrings {

    public static void main(String[] args) {
        String s = "aardvark";
        String t = "apple";
        System.out.println(twoStrings(s, t));

        String u = "beetroot";
        String v= "sandlas";
        System.out.println(twoStrings(u, v));
    }

    static String twoStrings(String s1, String s2) {
        if (helper(s1, s2)){
            return "YES";
        }
        return "NO";
    }

    static boolean helper(String x, String y) {
        for (char c : "abcdefghijklmnopqrstuvwzx".toCharArray()) {
            if (x.indexOf(c) >= 0 && y.indexOf(c) >= 0){
                return true;
            }
        }
        return false;
    }
}
