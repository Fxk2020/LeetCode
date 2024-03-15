package day1;

import java.util.Arrays;

//240 搜索二维矩阵II
public class T3 {

    public boolean searchMatrix2(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        int m_mid = m/2;
        int n_mid = n/2;

        if (m_mid==0){
            return Arrays.binarySearch(matrix[0], target)>=0;
        }
        if (n_mid==0){
            boolean result = false;
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][0]==target){
                    result = true;
                }
            }
            return result;
        }

        return searchLittleMatrix(matrix, 0, 0,m_mid, n_mid,target);

    }

    private boolean searchLittleMatrix(int[][] matrix, int m_start, int n_start, int mMid, int nMid, int target) {

        if (matrix[mMid][nMid]==target){
            return true;
        } else if (mMid-m_start==0||nMid-n_start==0) {
            return matrix[m_start][n_start+1]==target||matrix[m_start+1][n_start]==target;
        } else if (matrix[mMid][nMid]<target) {
            if (mMid==matrix.length-1||nMid==matrix[0].length-1){
                return false;
            }
            return searchLittleMatrix(matrix, mMid,nMid,(mMid+matrix.length)/2, (nMid+matrix[0].length)/2,target);
        }else {
            return searchLittleMatrix(matrix,m_start, n_start, (mMid+m_start)/2,(nMid+n_start)/2, target);
        }
    }

    public boolean searchMatrix(int[][] matrix, int target){
        int m = matrix.length-1;
        int n = matrix[0].length-1;
        int x = 0;
        int y = n;

        while (true){
            if (matrix[x][y]==target){
                return true;
            } else if (matrix[x][y]>target) {
                y--;
            } else if (matrix[x][y]<target) {
                x++;
            }

            if (x>m||y<0){
                return false;
            }
        }

    }


    public static void main(String[] args) {
//        System.out.println(new T3().searchMatrix(new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}},15));
//        System.out.println(new T3().searchMatrix(new int[][]{{-5}},-2));
//        System.out.println(new T3().searchMatrix(new int[][]{{1,3,5}},5));
//        System.out.println(new T3().searchMatrix(new int[][]{{1},{3},{5}},5));
//        System.out.println(new T3().searchMatrix(new int[][]{{1,4},{2,5}},6));
//          System.out.println(new T3().searchMatrix(new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}},25));
        System.out.println(new T3().searchMatrix(new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}},15));
    }

}
