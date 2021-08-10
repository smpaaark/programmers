package com.smpaaark.programmers;

public class CheckDistancing {

    public int[] solution(String[][] places) {
        int[] result = new int[5];
        for (int i = 0; i < places.length; i++) {
            result[i] = check(places[i]);
        }

        return result;
    }

    private int check(String[] place) {
        boolean[][] visit = new boolean[5][5];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int[] dx2 = {-2, 2, 0, 0};
        int[] dy2 = {0, 0, -2, 2};
        int[] dx3 = {-2, 2, 0, 0};
        int[] dy3 = {0, 0, -2, 2};
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (!visit[i][j] && place[i].charAt(j) == 'P') {
                    visit[i][j] = true;
                    for (int k = 0; k < 4; k++) {
                        int tempX = i + dx[k];
                        int tempY = j + dy[k];
                        if (tempX >= 0 && tempX < 5 && tempY >= 0 && tempY < 5 && !visit[tempX][tempY] && place[tempX].charAt(tempY) == 'P') {
                            return 0;
                        }
                    }

                    for (int k = 0; k < 4; k++) {
                        int tempX = i + dx2[k];
                        int tempY = j + dy2[k];
                        int tempX2 = i + dx[k];
                        int tempY2 = i + dy[k];
                        if (tempX >= 0 && tempX < 5 && tempY >= 0 && tempY < 5 && !visit[tempX][tempY] && place[tempX].charAt(tempY) == 'P' && place[tempX2].charAt(tempY2) != 'X') {
                            return 0;
                        }
                    }


                }
            }
        }
    }

}
