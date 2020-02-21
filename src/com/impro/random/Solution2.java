package com.impro.random;


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


/* count palindrome substrings */
public class Solution2 {

    // Complete the oddNumbers function below.
    private static int countPalindromes(String s) {
        int len = s.length();
        int n;
        int count=0;
        boolean flag= true;

        for(int i=0; i<len;i++){
            for(int j=i+1;j<=len;j++) {
                /*To get substring from i to j-1*/
                String sub = s.substring(i,j);

                flag = true;
                n = sub.length()-1;

                /*loop to check whether the substring is palindrome*/
                for(int k=0; k<sub.length()/2;k++,n--)
                {
                    /*In string 'madam' we check
                     * sub[0] == sub[4]
                     * sub[1] == sub[3]
                     * Both are true, so string is palindrome*/

                    if(sub.charAt(k) == sub.charAt(n))
                        continue;
                    else
                    {
                        /*Condition for palindrome failed*/
                        flag = false;
                        break;
                    }

                }
                /*if the sub-string is palindrome(flag remains true)*/
                if(flag)
                    count++;

            }

        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        String s = "abccba";
        String s2 = "daata";
        int result = countPalindromes(s);
        int result2 = countPalindromes(s2);
        System.out.println(result);
        System.out.println(result2);

    }
}

