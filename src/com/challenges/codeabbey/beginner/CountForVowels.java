package com.challenges.codeabbey.beginner;


import java.util.Scanner;


public class CountForVowels {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String a = in.nextLine();
        String[] arr = new String[]{"a", "o", "u", "i", "e", "y"};

        for(int i=0; i < n; i++ ) {
            String input = in.nextLine();
            int result = countVowels(input);
            System.out.print(result + " ");
        }

    }
    public static int countVowels(String str) {
        int counter = 0;
        for (int i = 0; i < str.length(); i++) {
            if ("aeouiy".indexOf(str.charAt(i)) >= 0) {
                counter++;
            }
        }

        return counter;
    }
}
