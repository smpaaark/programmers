package com.smpaaark.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestGameMap {

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        boolean[][] visit = new boolean[n][m];
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0, 1));

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            visit[point.x][point.y] = true;
            int count = point.count;
            for (int i = 0; i < 4; i++) {
                int tempX = point.x + dx[i];
                int tempY = point.y + dy[i];
                if (tempX >= 0 && tempX < n && tempY >= 0 && tempY < m && !visit[tempX][tempY] && maps[tempX][tempY] == 1) {
                    if (tempX == n - 1 && tempY == m - 1) {
                        return count + 1;
                    }

                    visit[tempX][tempY] = true;
                    queue.offer(new Point(tempX, tempY, count + 1));
                }
            }
        }

        return -1;
    }

    class Point {

        int x;
        int y;
        int count;

        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

    }

}
