package com.impro.codeabbey.stringtricks;

import java.util.*;

public class MatchingWords {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        for (String result : findDuplicates(input)) {
            System.out.print(result + " ");
        }
    }
    // TreeSet keeps things in "sorted" order
    static Set<String> findDuplicates(String str) {
        if (str == null || str.isEmpty()) {
            return Collections.emptySet();
        }

        String[] words = str.split(" ");
        TreeSet<String> duplicates = new TreeSet<>();
        Set<String> holder = new HashSet<>();

        for (String word : words) {
            if (!holder.add(word)) {
                duplicates.add(word);
            }
        }
        return duplicates;
    }
}
