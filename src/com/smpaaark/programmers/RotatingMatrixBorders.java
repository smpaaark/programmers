package com.smpaaark.programmers;

import java.util.Arrays;

public class RotatingMatrixBorders {

    public static void main(String[] args) {
        RotatingMatrixBorders q = new RotatingMatrixBorders();
        q.solution(6, 6, new int[][]{{2,2,5,4},{3,3,6,6},{5,1,6,3}});
    }

    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] matrix = new int[rows + 1][columns + 1];
        int num = 1;
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                matrix[i][j] = num++;
            }
        }

        int[] result = new int[queries.length];
        int index = 0;
        for (int[] query : queries) {
            result[index++] = rotate(matrix, query);
        }

        return result;
    }

    private int rotate(int[][] matrix, int[] query) {
        int min = Integer.MAX_VALUE;

        // 윗변 이동
        int prevNum = matrix[query[0] + 1][query[1]];
        int tempNum = 0;

        for (int i = query[1]; i <= query[3]; i++) {
            tempNum = matrix[query[0]][i];
            matrix[query[0]][i] = prevNum;
            min = Math.min(min, prevNum);
            prevNum = tempNum;
        }

        // 오른쪽변 이동
        for (int i = query[0] + 1; i <= query[2]; i++) {
            tempNum = matrix[i][query[3]];
            matrix[i][query[3]] = prevNum;
            min = Math.min(min, prevNum);
            prevNum = tempNum;
        }

        // 아래변 이동
        for (int i = query[3] - 1; i >= query[1]; i--) {
            tempNum = matrix[query[2]][i];
            matrix[query[2]][i] = prevNum;
            min = Math.min(min, prevNum);
            prevNum = tempNum;
        }

        // 왼쪽변 이동
        for (int i = query[2] - 1; i >= query[0]; i--) {
            tempNum = matrix[i][query[1]];
            matrix[i][query[1]] = prevNum;
            min = Math.min(min, prevNum);
            prevNum = tempNum;
        }
//        Arrays.stream(matrix).forEach(mat -> {
//            Arrays.stream(mat).forEach(num -> {
//                System.out.print(num + "\t");
//            });
//            System.out.println();
//        });
//
//        System.out.println();
        return min;
    }

}
