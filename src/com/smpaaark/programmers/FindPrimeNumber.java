package com.smpaaark.programmers;

import java.util.HashSet;
import java.util.Set;

public class FindPrimeNumber {

    private Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        FindPrimeNumber q = new FindPrimeNumber();
        System.out.println(q.solution("011"));
    }

    public int solution(String numbers) {
        for (int i = 1; i <= numbers.length(); i++) {
            boolean[] visit = new boolean[numbers.length()];
            recursion(visit, numbers, i, "");
        }

        return set.size();
    }

    private void recursion(boolean[] visit, String numbers, int length, String number) {
        if (number.length() == length) {
            int num = Integer.parseInt(number);
            if (!set.contains(num) && isPrimeNumber(num)) {
                set.add(num);
            }

            return;
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visit[i]) {
                if (!(number.length() == 0 && numbers.charAt(i) == '0')) {
                    visit[i] = true;
                    recursion(visit, numbers, length, number + numbers.charAt(i));
                    visit[i] = false;
                }
            }
        }
    }

    private boolean isPrimeNumber(int num) {
        if (num == 1) {
            return false;
        }

        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

}
