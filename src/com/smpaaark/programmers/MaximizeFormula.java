package com.smpaaark.programmers;

import java.util.LinkedList;
import java.util.List;

public class MaximizeFormula {

    private Long max = Long.MIN_VALUE;

    public long solution(String expression) {
        char[][] operations = {{'-', '*', '+'}, {'-', '+', '*'}, {'*', '-', '+'}, {'*', '+', '-'}, {'+', '-', '*'}, {'+', '*', '-'}};
        for (char[] operation : operations) {
            List<Node> list = new LinkedList<>();
            createList(list, expression);
            calculate(operation, list);
        }

        return max;
    }

    private void calculate(char[] operation, List<Node> list) {
        for (char c : operation) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).operation != null &&  list.get(i).operation == c) {
                    long calNum = 0;

                    if (c == '-') {
                        calNum = list.get(i - 1).num - list.get(i + 1).num;
                    } else if (c == '*') {
                        calNum = list.get(i - 1).num * list.get(i + 1).num;
                    } else {
                        calNum = list.get(i - 1).num + list.get(i + 1).num;
                    }

                    list.get(i - 1).num = calNum;
                    list.remove(i + 1);
                    list.remove(i);
                    i -= 1;
                }
            }
        }

        max = Math.max(max, Math.abs(list.get(0).num));
    }

    private void createList(List<Node> list, String expression) {
        String num = "";
        for (char c : expression.toCharArray()) {
            if (c == '-' || c == '*' || c == '+') {
                list.add(new Node(Long.parseLong(num)));
                list.add(new Node(c));
                num = "";
            } else {
                num += c;
            }
        }

        list.add(new Node(Long.parseLong(num)));
    }

    class Node {

        Long num;
        Character operation;

        public Node(Long num) {
            this.num = num;
        }

        public Node(Character operation) {
            this.operation = operation;
        }

    }

}
