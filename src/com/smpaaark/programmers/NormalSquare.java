package com.smpaaark.programmers;

public class NormalSquare {

    public long solution(int w, int h) {
        int gcd = getGcd(w, h);
        return ((long)w * h) - (w + h - gcd);
    }

    private int getGcd(int w, int h) {
        int max = Math.max(w, h);
        int min = Math.min(w, h);
        while(min > 0) {
            int r = max % min;
            max = min;
            min = r;
        }
        return max;
    }

}
