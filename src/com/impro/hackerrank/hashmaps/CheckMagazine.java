package com.impro.hackerrank.hashmaps;


import java.util.HashMap;
import java.util.Map;


public class CheckMagazine {

    public static void main(String[] args) {
        String[] magazine1 = new String[] {"give", "me", "one", "grand", "today", "night"};
        String[] note1 = new String[] {"give", "one", "grand", "today"};
        checkMagazine(magazine1, note1); // yes

        String[] magazine2 = new String[] {"two", "times", "three",  "is", "not", "four"};
        String[] note2 = new String[] {"two", "time", "two", "is", "four"};
        checkMagazine(magazine2, note2); // no

        String s2 = "ive got a lovely bunch of coconuts";
        String[] magazine3 = s2.split(" ");
        String[] note3 = {"ive", "got", "some", "coconuts"};
        checkMagazine(magazine3, note3); // no
    }

    static void checkMagazine(String[] magazine, String[] notes) {
        Map<String, Integer> magazineMap = new HashMap<>();

        if (notes.length == 0) {
            System.out.println("No");
        }

        for (String word : magazine){
            if (magazineMap.containsKey(word)){
                magazineMap.put(word, magazineMap.get(word) + 1);
            }
            else {
                magazineMap.put(word, 1);
            }
        }
        if (ransomNote(magazineMap, notes)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    static boolean ransomNote(Map<String, Integer> magazine, String[] notes) {
        for (String note : notes) {
            if (magazine.containsKey(note) && magazine.get(note) > 0) {
                magazine.put(note, magazine.get(note)-1);
            }
            else if (!magazine.containsKey(note) || magazine.get(note) != null || magazine.get(note) < 1) {
                return false;
            }
        }
        return true;
    }
}
