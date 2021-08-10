package com.smpaaark.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class ColoringBook {

    class Solution {

        private int max = 0;
        private int areaCount = 0;
        private int[] dx = {-1, 1, 0, 0};
        private int[] dy = {0, 0, -1, 1};

        public int[] solution(int m, int n, int[][] picture) {
            boolean[][] visit = new boolean[m][n];
            for (int i = 0; i < picture.length; i++) {
                for (int j = 0; j < picture[i].length; j++) {
                    if (!visit[i][j] && picture[i][j] != 0) {
                        bfs(i, j, picture, visit, picture[i][j]);
                        areaCount++;
                    }
                }
            }

            return new int[] {areaCount, max};
        }

        private void bfs(int x, int y, int[][] picture, boolean[][] visit, int pictureNum) {
            Queue<Point> queue = new LinkedList<>();
            queue.offer(new Point(x, y));
            visit[x][y] = true;

            int count = 0;
            while (!queue.isEmpty()) {
                Point point = queue.poll();
                count++;
                for (int i = 0; i < dx.length; i++) {
                    int tempX = point.x + dx[i];
                    int tempY = point.y + dy[i];
                    if (tempX >= 0 && tempX < picture.length && tempY >= 0 && tempY < picture[tempX].length && picture[tempX][tempY] == pictureNum && !visit[tempX][tempY]) {
                        queue.offer(new Point(tempX, tempY));
                        visit[tempX][tempY] = true;
                    }
                }
            }

            max = Math.max(max, count);
        }

        class Point {

            int x;
            int y;

            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

    }

}
