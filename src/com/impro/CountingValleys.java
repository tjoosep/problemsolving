package com.impro;


public class CountingValleys {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        // U - up
        // D - down
        int valley = 0;
        int level  = 0;

        for (char c : s.toCharArray()) {
            if (c == 'U') {
                level++;
            }
            if (c == 'D') {
                level--;
            }
            if (level == 0 && c == 'U'){
                valley++;
            }
        }

        return valley;
    }

    public static void main(String[] args) {
        int n = 8;
        String steps = "UDDDUDUU";
        String steps2 = "DDUUUUDD";

        int result = countingValleys(n, steps);

        System.out.println(result); // 1
    }
}
