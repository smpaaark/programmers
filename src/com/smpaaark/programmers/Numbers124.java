package com.smpaaark.programmers;

public class Numbers124 {

    public static void main(String[] args) {
        Numbers124 q = new Numbers124();
        System.out.println(q.solution(13));
    }

    public String solution(int n) {
        int[] number = {1, 2, 4};
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(number[(n - 1) % 3]);
            n = (n - 1) / 3;
        }

        return sb.reverse().toString();
    }

}
