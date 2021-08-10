package com.smpaaark.programmers;

import java.util.Stack;

public class RemoveInPairs {

    class Solution {
        public int solution(String s) {
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if (stack.isEmpty()) {
                    stack.push(c);
                } else if (stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }

            return stack.isEmpty() ? 1 : 0;
        }
    }

}
