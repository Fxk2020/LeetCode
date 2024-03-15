package day14;

import java.util.ArrayList;

/**
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 */
public class T4 {

    public int numSquares(int n) {

        int[] res = new int[n+1];
        if (n==0) return 0;
        if (n==1) return 1;
        if (n==2) return 2;

        res[1] = 1;
        res[2] = 2;

        for (int i = 3; i <= n; i++) {

            int j = (int) Math.sqrt(i);

            int min = Integer.MAX_VALUE;
            for (int k = 1; k <= j; k++) {
                min = Math.min(min, res[i-(int)Math.pow(k, 2)]);
            }

            res[i] = 1 + min;
        }

        return res[n];

    }

    public static void main(String[] args) {
        new T4().numSquares(13);
    }

    private int divide(ArrayList<Integer> squares, int i) {

        int min = Integer.MAX_VALUE;
        for (int j = 0; j < squares.size(); j++) {
            if (i%squares.get(j)==0) min = Math.min(min, i/squares.get(j));
        }

        if (min!=Integer.MAX_VALUE) return min;
        else return -1;//不存在整除
    }

    public boolean isSquare(int num) {
        double a = 0;
        try {
            a = Math.sqrt(num);
        } catch (Exception e) {
            return false;
        }
        int b = (int) a;
        return a - b == 0;
    }

}
