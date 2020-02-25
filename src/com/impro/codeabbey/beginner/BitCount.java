package com.impro.codeabbey.beginner;


import java.util.Scanner;


public class BitCount {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        String[] nextLine = in.nextLine().split(" ");
        for (int i = 0; i < nextLine.length; i++) {
            int nr = Integer.parseInt(nextLine[i]);
            hammingWeight(nr);
        }
    }

    public static void hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; ++i) {
            if (((n >>> i) & 1) == 1) {
                ++count;
            }
        }
        System.out.println(count);
    }
}
