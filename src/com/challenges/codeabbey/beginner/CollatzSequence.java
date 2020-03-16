package com.challenges.codeabbey.beginner;


import java.util.*;


public class CollatzSequence {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String[] numbers = new String[n];

        numbers = in.nextLine().split(" ");
        for (String number : numbers) {
            int nr = Integer.parseInt(number);
            printSequence(nr);
        }
    }
    // how many steps it takes to get to 1
    static void printSequence(int nr) {
        int steps = 0;
        while (nr != 1) {
            if (nr % 2 == 0) {
                nr = nr / 2;
            } else {
                nr = 3 * nr + 1;
            }
            steps++;
        }
        System.out.print(steps + " ");
    }
}
