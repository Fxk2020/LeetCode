package day22;

import java.util.*;

public class T2 {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> solutions = new ArrayList<List<String>>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        //三个集合存储那个列放皇后了，row+col放皇后了，row-col放皇后了
        Set<Integer> columns = new HashSet<Integer>();
        Set<Integer> diagonals1 = new HashSet<Integer>();
        Set<Integer> diagonals2 = new HashSet<Integer>();
        backtrack(solutions, queens, n, 0, columns, diagonals1, diagonals2);
        return solutions;
    }

    private void backtrack(List<List<String>> res, int[] queens, int n, int row,
                           Set<Integer> columns,Set<Integer> diagonals1,Set<Integer> diagonals2) {

        if (row==n){
            res.add(new ArrayList<>(getQ(queens, n)));
        }else {
            for (int col = 0; col < n; col++) {
                if (columns.contains(col)) ;
                else {
                    int diagonal1 = row-col;
                    if (diagonals1.contains(diagonal1)) continue;
                    int diagonal2 = row+col;
                    if (diagonals2.contains(diagonal2)) continue;

                    //1.尝试
                    columns.add(col);
                    diagonals1.add(diagonal1);
                    diagonals2.add(diagonal2);
                    queens[row] = col;
                    //2.进一步尝试
                    backtrack(res, queens, n, row+1, columns, diagonals1, diagonals2);
                    //3.回溯
                    queens[row]=-1;
                    diagonals2.remove(diagonal2);
                    diagonals1.remove(diagonal1);
                    columns.remove(col);
                }
            }
        }


    }

    private ArrayList<String> getQ(int[] queens, int n) {

        ArrayList<String> res = new ArrayList<>();
        for (int queue:
             queens) {

            char[] tmp = new char[n];
            Arrays.fill(tmp, '.');
            tmp[queue] = 'Q';
            res.add(new String(tmp));
        }

        return res;

    }


}
