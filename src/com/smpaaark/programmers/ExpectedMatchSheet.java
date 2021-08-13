package com.smpaaark.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class ExpectedMatchSheet {

    public static void main(String[] args) {
        ExpectedMatchSheet q = new ExpectedMatchSheet();
        System.out.println(q.solution(8, 4, 7));
    }

    public int solution(int n, int a, int b) {
        int round = 0;
        while (a != b) {
            round++;
            a = (a + 1) / 2;
            b = (b + 1) / 2;
        }

        return round;
    }

}
