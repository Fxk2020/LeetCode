package sort;

import java.util.PriorityQueue;

public class HeapSort {

    public static void heapSort(int[] nums){
        int n = nums.length;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            minHeap.add(nums[i]);
        }

        while (!minHeap.isEmpty()){
            System.out.println(minHeap.poll());
        }

    }
}
