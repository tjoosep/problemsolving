package com.impro.codeabbey.beginner;


import java.math.BigInteger;
import java.util.Scanner;


public class Fibo {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        for (int i = 0; i < n; i++) {
            BigInteger fiboNr = in.nextBigInteger();
            System.out.print(findFibonacciIndex(fiboNr) + " ");
        }
    }
    /*
    529282892349538663865041757952487834360789665256290022345566986834836521594735814856589938215468774943708863917660167406652278820948558442729902757341091825700790758348602488149084432
    18229483969956288937453823586319088430400473681987433688972410981043317007700252830412315571712082187550674621987144643298645736481136196312937518600257507956051407899662686771625669
    267298000959443373369737335156910777158008598307800387349948489344861418164945033552451332787950312664036625920910448826584264474944033858595331213966981203149609525741601791321904127106537860109
    26463782426792414518658024158648929513854998967969749699940971585740453487532494757312352026064060422315167698797283354716411469851334503341169305671258275227817834024
    3016128079338728432528443992613633888712980904400501

    876 869 932 798 248
     */

    static BigInteger findFibonacciIndex(BigInteger nr) {
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
        BigInteger c;
        if (nr.equals(BigInteger.ZERO)) {
            return a;
        }
        int counter = 1;
        for (int i = 2; i <= 1000; i++) {
            c = a.add(b);
            a = b;
            b = c;
            counter++;
            if (nr.equals(b)) {
                return BigInteger.valueOf(counter);
            }
        }
        return BigInteger.ZERO;
    }
}
