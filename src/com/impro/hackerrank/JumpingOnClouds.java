package com.impro.hackerrank;


public class JumpingOnClouds {

    static int jumpingOnClouds(int[] c) {
        int i = 0;
        int jumps = 0;
        int n = c.length;

        while( i < n - 1) {
            if (i < n - 2 && c[i + 2] == 0) {
                i++;
            }
            if (i != n-1){
                jumps++;
            }
            i++;
        }
        return jumps;
    }

    public static void main(String[] args) {
        int[] c1 = {0, 0, 0, 0, 1, 0};
        int[] c2 = {0, 1, 0, 0, 0, 1, 0};
        int[] c3 = {0, 0, 1, 0, 0, 1, 0};

        int result1 = jumpingOnClouds(c1);
        int result2 = jumpingOnClouds(c2);
        int result3 = jumpingOnClouds(c3);

        System.out.println(result1); // 3
        System.out.println(result2); // 3
        System.out.println(result3); // 4

    }
}
