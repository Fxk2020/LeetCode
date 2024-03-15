package day12;

/**
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 */
public class T3 {

    public int[] searchRange(int[] nums, int target) {

        int n = nums.length;
        if (n==0) return new int[]{-1,-1};
        int res = search(0, n-1, nums, target);
        if (res==-1) return new int[]{-1,-1};

        int left = res;
        while (nums[left]==target) {
            left--;
            if (left<0) break;
        }
        int right = res;
        while (nums[right] == target){
            right++;
            if (right>n-1) break;
        }

        return new int[]{left+1, right-1};

    }

    private int search(int start, int end, int[] nums, int target) {

        if (start>=end){
            if (nums[start]==target) return start;
            else return -1;
        }

        int mid = (start+end)/2;
        if (nums[mid]==target) return mid;
        if (nums[mid]>target) return search(start, mid-1, nums,target);
        else return search(mid+1, end, nums, target);

    }


}
