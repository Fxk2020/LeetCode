package day14;

import java.util.ArrayList;
import java.util.List;

public class T2 {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> res = new ArrayList<>();
        int[][] nums= new int[numRows][numRows];
        nums[0][0] = 1;

        for (int i = 1; i < numRows; i++) {

            for (int j = 0; j <= i; j++) {

                if (j-1>=0&&j!=i) nums[i][j] = nums[i-1][j-1]+nums[i-1][j];
                else if (j-1<0){
                    //左侧元素
                    nums[i][j] = nums[i-1][j];
                }
                else {
                    //右侧元素
                    nums[i][j] = nums[i-1][j-1];
                }
            }
        }

        for (int[] num : nums) {

            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < num.length; j++) {
                if (num[j] != 0) tmp.add(num[j]);
            }
            res.add(new ArrayList<>(tmp));
            tmp.clear();
        }

        return res;
    }


}
