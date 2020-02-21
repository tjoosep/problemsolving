package com.impro.codeabbey.beginner;


import java.util.*;


public class MatchingBrackets {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        for (int i = 0; i < n; i++) {
            String brackets = in.nextLine();
            if (areBracketsMatching(brackets)) {
                System.out.print(1 + " ");
            } else {
                System.out.print(0 + " ");
            }
        }
    }

    static boolean areBracketsMatching(String str) {
        Stack<Character> characters = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (currentChar == '(' || currentChar == '{' || currentChar == '[' || currentChar == '<') {
                characters.push(currentChar);
            }
            else if (currentChar == ')' || currentChar == '}' || currentChar == ']' || currentChar == '>') {
                if (characters.size() == 0) {
                    return false;
                }
                switch (characters.pop()) {
                    case '(':
                        if (currentChar != ')') { return false; } break;
                    case '{':
                        if (currentChar != '}') { return false; } break;
                    case '[':
                        if (currentChar != ']') { return false; } break;
                    case '<':
                        if (currentChar != '>') { return false; } break;
                }
            }
        }
        return characters.size() == 0;
    }
}
