package com.impro.codeabbey.beginner;


import java.util.*;


public class ModuloAndTimeDiff {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        for (int i = 0; i < n; i++) {
            String[] times = in.nextLine().split(" ");
            int[] time1 = new int[times.length/2];
            int[] time2 = new int[times.length/2];
            for (int j = 0; j < 4; j++) {
                time1[j] = Integer.parseInt(times[j]);
                time2[j] = Integer.parseInt(times[j + 4]);
            }
            calcTimeDifferences(time1, time2);
        }
    }

    static void calcTimeDifferences(int[] time1, int[] time2) {
        int days = time2[0] - time1[0];
        int hours = 0;
        int minutes = 0;
        int seconds = 0;

        System.out.print("(" + days + " " + hours + " " + minutes + " " + seconds + ")");
    }
}
