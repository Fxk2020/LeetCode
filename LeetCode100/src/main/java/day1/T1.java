package day1;

import java.util.HashMap;

public class T1 {

    public void setZeroes(int[][] matrix) {
        HashMap<Integer, Boolean> Sites = new HashMap<Integer, Boolean>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j]==0&&!Sites.containsKey(i*matrix[0].length+j)){
//                    行=0
                    for (int k = 0; k < matrix[0].length; k++) {
                        if (matrix[i][k]!=0){
                            matrix[i][k] = 0;
                            Sites.put(i*matrix[0].length+k, false);
                        }
                    }
//                    列=0
                    for (int k = 0; k < matrix.length; k++) {
                        if (matrix[k][j]!=0){
                            matrix[k][j] = 0;
                            Sites.put(k*matrix[0].length+j, false);
                        }
                    }

                }
            }
        }

    }

    public void setZeroes2(int[][] matrix) {
        boolean[][] nums = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                nums[i][j] = false;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j]==0){
//                    行=0
                    for (int k = 0; k < matrix[0].length; k++) {
                        nums[i][k] = true;
                    }
//                    列=0
                    for (int k = 0; k < matrix.length; k++) {
                        nums[k][j] = true;
                    }

                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (nums[i][j]){
                    matrix[i][j] = 0;
                }
            }
        }

    }
    public void setZeroes3(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }


    public static void main(String[] args) {
        new T1().setZeroes(new int[][]{{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}});
    }

}
