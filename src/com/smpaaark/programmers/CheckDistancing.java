package com.smpaaark.programmers;

public class CheckDistancing {

    public static void main(String[] args) {
        CheckDistancing q = new CheckDistancing();
        System.out.println(q.solution(new String[][] {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}}));
    }

    public int[] solution(String[][] places) {
        int[] result = new int[5];
        for (int i = 0; i < places.length; i++) {
            result[i] = check(places[i]);
        }

        return result;
    }

    private int check(String[] place) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int[] dx2 = {-2, 2, 0, 0};
        int[] dy2 = {0, 0, -2, 2};
        int[] dx3 = {-1, -1, 1, 1};
        int[] dy3 = {-1, 1, -1, 1};
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (place[i].charAt(j) == 'P') {
                    for (int k = 0; k < 4; k++) {
                        int tempX = i + dx[k];
                        int tempY = j + dy[k];
                        if (tempX >= 0 && tempX < 5 && tempY >= 0 && tempY < 5 && place[tempX].charAt(tempY) == 'P') {
                            return 0;
                        }
                    }

                    for (int k = 0; k < 4; k++) {
                        int tempX = i + dx2[k];
                        int tempY = j + dy2[k];
                        int tempX2 = i + dx[k];
                        int tempY2 = j + dy[k];
                        if (tempX >= 0 && tempX < 5 && tempY >= 0 && tempY < 5 && place[tempX].charAt(tempY) == 'P' && place[tempX2].charAt(tempY2) != 'X') {
                            return 0;
                        }
                    }

                    for (int k = 0; k < 4; k++) {
                        int tempX = i + dx3[k];
                        int tempY = j + dy3[k];
                        if (tempX >= 0 && tempX < 5 && tempY >= 0 && tempY < 5 && place[tempX].charAt(tempY) == 'P') {
                            if (k == 0 && !(place[tempX].charAt(tempY + 1) == 'X' && place[tempX + 1].charAt(tempY) == 'X')) {
                                return 0;
                            } else if (k == 1 && !(place[tempX].charAt(tempY - 1) == 'X' && place[tempX + 1].charAt(tempY) == 'X')) {
                                return 0;
                            } else if (k == 2 && !(place[tempX - 1].charAt(tempY) == 'X' && place[tempX].charAt(tempY + 1) == 'X')) {
                                return 0;
                            } else if (k == 4 && !(place[tempX].charAt(tempY - 1) == 'X' && place[tempX - 1].charAt(tempY) == 'X')){
                                return 0;
                            }
                        }
                    }
                }
            }
        }

        return 1;
    }

}
