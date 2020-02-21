package com.impro.company;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;


public class Twilio {

    public static void main(String[] args) {

        List<String> prefixes = new ArrayList<>();
        prefixes.add("+1415123");
        prefixes.add("+1415000");
        prefixes.add("+1412");
        prefixes.add("+1510");
        prefixes.add("+1");
        prefixes.add("+44");

        List<String> numbers = new ArrayList<>();
        numbers.add("+14151234567"); // +1415123
        numbers.add("+9990");        // ""
        numbers.add("+14151224983"); // +1

        List<String> res = match(prefixes, numbers);

        findLongestPrefix(numbers, prefixes);
        for (String el : res) {
            System.out.println(el);
        }
    }

    /*
    I totally misunderstood the problem statement at first.
    This solution took me (extra) 37 minutes and 52 seconds.

    The idea behind this algorithm is :
    First, it will start to look prefixes that match to the number. If prefix is in the number,
    it will look for best one while comparing already existing prefix length and next found
    prefix.
    If there is no matching prefix, a empty String will be added.

    This algorithm is O(N*P) complexity,
    where N is number of numbers in array and P is number of prefixes it has to look loop through.
    Worst case is that it needs to loop through all numbers and prefixes. best case is when
    One good case is that there are no prefixes, so no extra loops, just numbers, then it is O(N)
    Then there is a case that both numbers and prefixes are empty and empty array will be
    returned.

    To make it better, I found that there is a algorithm called Longest Prefix Match, which
    is mainly used in IP routing but I think it can be used here as well.
    But I didnt have time to implement it.
     */
    public static List<String> match(List<String> prefixes, List<String> numbers) {
        List<String> result = new ArrayList<>();
        Map<String, String> numsAndPrefixes = new HashMap<>();

        /* some corner cases */
        if (!numbers.isEmpty() && prefixes.isEmpty()) {
            for (int i = 0; i < numbers.size(); i++) {
                result.add("");
            }
            return result;
        }

        if (prefixes.isEmpty() || numbers.isEmpty()) {
            return result; // or throw exception
        }

        for (String number : numbers) {
            for (String prefix : prefixes) {
                if (number.contains(prefix)) {
                    if (numsAndPrefixes.containsKey(number)) {
                        int prefixLen = prefix.length();
                        int currentLen = numsAndPrefixes.get(number).length();
                        if (prefixLen > currentLen) {
                            numsAndPrefixes.put(number, prefix);
                        }
                    } else {
                        numsAndPrefixes.put(number, prefix);
                    }
                } else if (!number.contains(prefix) && !numsAndPrefixes.containsKey(number)) {
                    numsAndPrefixes.put(number, "");
                }
            }
        }

        return new ArrayList<String>(numsAndPrefixes.values());
    }

    /* even better solution
    Your code is a full Cartesian join of numbers and prefixes, so O(n*m).
    This solution is O(n*log m). On average, it probably only has to look up in the prefixSet about 3 times per phone number,
    not scan the full prefix array.
    Sure, there is a one-time O(m*log m) startup cost to build the Set, so if you only have a few numbers or prefixes,
    it may not be worth it, but if the prefix list is huge, which it will be if you're doing all the international prefixes,
     and you have a lot of phone numbers to check, then the performance gain is immense.
     */
    public static void findLongestPrefix(List<String> numbers, List<String> prefixes) {
        TreeSet<String> prefixSet = new TreeSet<>(prefixes);

        for (String number :numbers){
            String prefix = prefixSet.floor(number);
            while (prefix != null && !number.startsWith(prefix)) {
                prefix = prefixSet.floor(prefix.substring(0, prefix.length() - 1));
                if (prefix == null) {
                    prefix = "";
                }
            }
                System.out.println(number + " -> " + prefix);
        }
    }

}
