package day12;

import java.util.List;

public class T2 {

    public int searchInsert(int[] nums, int target) {

        int n = nums.length;

        int res = search(0, n-1, nums, target);

        return res;
    }

    private int search(int start, int end, int[] nums, int target) {

        if (start>=end){
            if (nums[start]>target||nums[start]==target) return start;
            else return start+1;
        }

        int mid = (start+end)/2;
        if (nums[mid]==target) return mid;
        if (nums[mid]>target) return search(start, mid-1, nums,target);
        else return search(mid+1, end, nums, target);
    }


    public static void main(String[] args) {
        new T2().searchInsert(new int[]{1,3,5,6}, 5);
    }


}
