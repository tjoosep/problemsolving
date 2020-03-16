package com.challenges.codeabbey.beginner;

import java.util.*;

public class DiceRolling {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int dice = 6;

        // floor(x * (B-A) + A)
        // x * 6 + 1
        for (int i = 0; i < n; i++) {
            float input = in.nextFloat();
            float a = input * dice;
            int b = (int) a;
            System.out.print(b + 1 + " ");
        }
    }
}
