package com.impro.codeabbey.beginner;

import java.util.*;

public class ModularCalc {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int startingNumber = in.nextInt();
        in.nextLine();

        long result = startingNumber;
        boolean flag = true;

        List<String> l = new ArrayList<>();
        int i = 0;
        while (flag) {
            String op = in.nextLine();
            l.add(op);
            i++;
            if (op.startsWith("%")) {
                flag = false;
            }
        }
        in.close();

        System.out.println(findAnswer(result, l));

    }

    // correct idea is to calc modulo from each number
    static long findAnswer(long num, List<String> list) {
        String[] modStr = list.get(list.size() - 1).split(" ");
        int mod = Integer.parseInt(modStr[1]);

        long result = num;
        for (int i = 0; i < list.size() - 1; i++) {
            String[] split = list.get(i).split(" ");
            String operation = split[0];
            long number = Long.parseLong(split[1]);

            switch(operation) {
                case "*":
                    long temp = number * result;
                    result = calcModular(temp, mod);
                    break;
                case "+":
                    long temp2 = number + result;
                    result = calcModular(temp2, mod);
                    break;
                default:
                    break;
            }
        }

        return result;
    }

    //  xy (mod a) ≡ ((x (mod a) * y) (mod a)).
    static long calcModular(long number, long mod) {
        long acc = 0;
        String str = Long.toString(number);
        for (int i = 0; i < str.length(); i++) {
            acc = (acc * 10 + (int) str.charAt(i) - '0') % mod;
        }

        return acc;
    }

}
