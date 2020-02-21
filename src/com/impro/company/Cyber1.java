package com.impro.company;



import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;




public class Cyber1 {

    // Complete the findNumber function below.
    static String findNumber(List<Integer> arr, int k) {
        for (Integer elem : arr){
            if (k == elem){
                return "YES";
            }
        }
        return "NO";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> arrTemp = new ArrayList<>();

        IntStream.range(0, arrCount).forEach(i -> {
            try {
                arrTemp.add(bufferedReader.readLine().replaceAll("\\s+$", ""));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> arr = arrTemp.stream()
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String res = findNumber(arr, k);

        System.out.println(res);

    }
}
/*
    int len = str.length();
    int n,count=0;
    boolean flag= true;

        for(int i=0; i<len;i++)
        {
        for(int j=i+1;j<=len;j++)
        {
        /*To get substring from i to j-1
        String sub = str.substring(i,j);

        flag = true;                        //reset flag
        n = sub.length()-1;

        /*loop to check whether the substring is palindrome
        for(int k=0; k<sub.length()/2;k++,n--)
        {
        /*In string 'madam' we check
         * sub[0] == sub[4]
         * sub[1] == sub[3]
         * Both are true, so string is palindrome

        if(sub.charAt(k) == sub.charAt(n))
        continue;
        else
        {
        /*Condition for palindrome failed
        flag =false;
        break;
        }

        }
        /*if the sub-string is palindrome(flag remains true)
        if(flag)
        System.out.println(sub);

        }

        }
        */