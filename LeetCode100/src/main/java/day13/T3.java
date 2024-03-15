package day13;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回 滑动窗口中的最大值 。
 */
public class T3 {

//    public int[] maxSlidingWindow(int[] nums, int k) {
//        if (k==1) return nums;
//        int n = nums.length;
//        int[] res = new int[n-k+1];
//
//        for (int i = 0; i <= n-k; i++) {
//            res[i] = maxK(i,k,nums);
//        }
//
//        return res;
//
//    }
//
//    private int maxK(int i, int k, int[] nums) {
//
//        int tmp = nums[i];
//        for (int j = 1; j < k; j++) {
//            if (nums[i+j]>tmp) tmp=nums[i+j];
//        }
//        return tmp;
//    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]==o2[0]?o2[1]-o1[1]:o2[0]-o1[0];// 返回大的，如果相同返回index大的
            }
        });

        for (int i = 0; i < k; i++) {
            priorityQueue.add(new int[]{nums[i], i});
        }
        int[] res = new int[n-k+1];
        res[0] = priorityQueue.peek()[0];

        for (int i = k; i < n; i++) {

            priorityQueue.add(new int[]{nums[i], i});
            while (priorityQueue.peek()[1]<=i-k){
                priorityQueue.poll();
            }
            res[i-k+1] = priorityQueue.peek()[0];

        }
        return res;
    }


}
