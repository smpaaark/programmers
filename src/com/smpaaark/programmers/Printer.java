package com.smpaaark.programmers;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.IntStream;

public class Printer {

    public int solution(int[] priorities, int location) {
        Queue<Integer> queue = new LinkedList<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> {
           return b - a;
        });

        IntStream.range(0, priorities.length).forEach(i -> {
            queue.offer(i);
            heap.offer(priorities[i]);
        });

        int count = 0;
        while (!queue.isEmpty()) {
            int pollLocation = queue.poll();
            if (priorities[pollLocation] < heap.peek()) {
                queue.offer(pollLocation);
            } else {
                count++;
                if (pollLocation == location) {
                    break;
                }

                heap.poll();
            }
        }

        return count;
    }

}
