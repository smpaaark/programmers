package com.smpaaark.programmers;

public class TargetNumber {

    public int solution(int[] numbers, int target) {
        int answer = 0;

        answer = backTracking(numbers, target, 0, 0, answer);

        return answer;
    }

    private int backTracking(int[] numbers, int target, int index, int tempSum, int answer) {
        if (index > numbers.length -1 ) {
            return tempSum == target ? 1 : 0;
        }

        return backTracking(numbers, target, index + 1, tempSum + numbers[index], answer) +
                backTracking(numbers, target, index + 1, tempSum - numbers[index], answer);
    }

}
