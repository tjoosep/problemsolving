package com.impro.codeabbey.beginner;


import java.util.*;


public class BodyMass {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        for (int i = 0; i < n; i++) {
            int w = in.nextInt();
            double h = in.nextDouble();
            findBMI(w, h);
        }
    }

    static void findBMI(int weight, double height) {
        double BMI = weight / Math.pow(height, 2);

        if (BMI < 18.5) {
            System.out.print("under" + " ");
        }
        else if (BMI >= 18.5 && BMI < 25.0) {
            System.out.print("normal" + " ");
        }
        else if (BMI >= 25.0 && BMI < 30.0) {
            System.out.print("over" + " ");
        }
        else if (BMI >= 30.0) {
            System.out.print("obese" + " ");
        }
    }
}
