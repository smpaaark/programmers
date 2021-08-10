package com.smpaaark.programmers;

public class StringCompression {

    public static void main(String[] args) {
        StringCompression q = new StringCompression();
        System.out.println(q.solution("aabbaccc"));
    }

    public int solution(String s) {
        int minLength = s.length();
        for (int i = 1; i < s.length(); i++) {
            String splitStr = s.substring(0, i);
            String remainStr = s.substring(i);
            String tempResult = "";
            int count = 1;
            while (remainStr.length() >= splitStr.length()) {
                if (remainStr.indexOf(splitStr) == 0) {
                    count++;
                    remainStr = remainStr.substring(splitStr.length());
                } else {
                    if (count > 1) {
                        tempResult += count + splitStr;
                    } else {
                        tempResult += splitStr;
                    }

                    count = 1;
                    splitStr = remainStr.substring(0, i);
                    remainStr = remainStr.substring(i);
                }
            }

            if (count > 1) {
                tempResult += count + splitStr + remainStr;
            } else {
                tempResult += splitStr + remainStr;
            }

            minLength = Math.min(minLength, tempResult.length());
        }

        return minLength;
    }

}
