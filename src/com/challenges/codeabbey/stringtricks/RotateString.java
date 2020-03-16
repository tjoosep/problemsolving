package com.challenges.codeabbey.stringtricks;


import java.util.*;


public class RotateString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        // we can also rotate char array twice from the center but lets say this is easier
        for (int i = 0; i < n; i++) {
            int nrOfRotations = in.nextInt();
            String word = in.next();
            String result = nrOfRotations >= 0 ?
                    word.substring(nrOfRotations) + word.substring(0, nrOfRotations) :
                    word.substring(word.length() + nrOfRotations) + word.substring(0, word.length() + nrOfRotations);
            System.out.print(result + " ");
        }
    }
}
