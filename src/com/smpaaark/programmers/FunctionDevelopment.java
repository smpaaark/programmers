package com.smpaaark.programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

public class FunctionDevelopment {

    public static void main(String[] args) {
        FunctionDevelopment q = new FunctionDevelopment();
        System.out.println(q.solution(new int[] {93, 30, 55}, new int[] {1, 30, 5}));
    }

    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Function> queue = new LinkedList<>();
        IntStream.range(0, progresses.length).mapToObj(i -> new Function(progresses[i], speeds[i])).forEach(queue::offer);

        List<Integer> deploy = new ArrayList<>();
        while (!queue.isEmpty() && queue.peek().progress < 100) {
            int qSize = queue.size();
            while (qSize-- > 0) {
                Function f = queue.poll();
                f.develop();
                queue.offer(f);
            }

            int count = 0;
            while (!queue.isEmpty() && queue.peek().progress == 100) {
                queue.poll();
                count++;
            }

            if (count > 0) {
                deploy.add(count);
            }
        }

        int[] result = deploy.stream().mapToInt(integer -> integer).toArray();

        return result;
    }

    class Function {

        int progress;
        int speed;

        public Function(int progress, int speed) {
            this.progress = progress;
            this.speed = speed;
        }

        public void develop() {
            if (this.progress < 100) {
                this.progress += speed;
                if (this.progress >= 100) {
                    this.progress = 100;
                }
            }
        }

    }

}
