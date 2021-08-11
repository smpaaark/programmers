package com.smpaaark.programmers;

import java.util.Stack;

public class ParentalTranslation {

    public static void main(String[] args) {
        ParentalTranslation q = new ParentalTranslation();
        System.out.println(q.solution("()))((()()))((()"));
    }

    public String solution(String p) {
        return recursion(p);
    }

    private String recursion(String p) {
        if (p.length() == 0) {
            return p;
        }

        int open = 0;
        int close = 0;
        String u = "";
        String v = "";
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (c == '(') {
                open++;
            } else {
                close++;
            }

            u += c;
            if (open == close) {
                v = i + 1 < p.length() ? p.substring(i + 1) : "";
                break;
            }
        }

        if (correctCheck(u)) {
            return u + recursion(v);
        } else {
            u = u.length() > 2 ? u.substring(1, u.length() - 1) : "";
            String temp =  "(" + recursion(v) + ")";
            if (u.length() > 0) {
                temp += reverse(u);
            }

            return temp;
        }
    }

    private String reverse(String u) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < u.length(); i++) {
            sb.append(u.charAt(i) == '(' ? ')' : '(');
        }

        return sb.toString();
    }

    private boolean correctCheck(String u) {
        Stack<Character> stack = new Stack<>();
        for (char c : u.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }

        return stack.isEmpty();
    }

}
