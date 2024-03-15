package day8;

import java.util.LinkedList;
import java.util.Queue;

public class T2 {

    public int orangesRotting(int[][] grid) {

        int count = 0;//记录新鲜橘子的个数
        int num = 0;//记录几min可以将橘子污染完

        int row = grid.length;
        int col = grid[0].length;

        Queue<int[]> orangesCorrupt = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j]==1){
                    count++;
                }else if (grid[i][j]==2){
                    orangesCorrupt.add(new int[]{i, j});
                }
            }
        }

        while (count>0&&!orangesCorrupt.isEmpty()){

            num++;
            int size = orangesCorrupt.size();

            for (int i = 0; i < size; i++) {

                int[] index = orangesCorrupt.poll();
                int r = index[0];
                int c = index[1];

                if (r-1>=0&&grid[r-1][c]==1){
                    grid[r-1][c]=2;
                    count--;
                    orangesCorrupt.add(new int[]{r-1, c});
                }
                if (r+1<row&&grid[r+1][c]==1){
                    grid[r+1][c]=2;
                    count--;
                    orangesCorrupt.add(new int[]{r+1,c});
                }
                if (c-1>=0&&grid[r][c-1]==1){
                    grid[r][c-1]=2;
                    count--;
                    orangesCorrupt.add(new int[]{r,c-1});
                }
                if (c+1<col&&grid[r][c+1]==1){
                    grid[r][c+1]=2;
                    count--;
                    orangesCorrupt.add(new int[]{r,c+1});
                }

            }

        }
        if (count==0){
            return num;
        }else {
            return -1;
        }


    }

}
