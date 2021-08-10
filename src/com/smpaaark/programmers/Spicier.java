package com.smpaaark.programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Spicier {

    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        Arrays.stream(scoville).forEach(heap::offer);

        int count = 0;
        while (heap.peek() < K && heap.size() > 1) {
            count++;
            heap.offer(heap.poll() + (heap.poll() * 2));
        }

        return heap.peek() >= K ? count : -1;
    }

}
