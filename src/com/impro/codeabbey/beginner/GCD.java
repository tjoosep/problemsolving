package com.impro.codeabbey.beginner;


import java.util.*;


public class GCD {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();

            System.out.print("(" + gcd(a, b) + " " + lcd(a, b) + ") ");
        }
    }

    static int gcd(int a, int b){
        if (a ==  0){
            return b;
        }
        return gcd(b%a, a);
    }

    static int lcd(int a, int b) {
        return a * b / gcd(a, b);
    }
}
