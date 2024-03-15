package day12;

/**
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
 *
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]
 * （下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 *
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 */
public class T4 {

    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n==0) return -1;
        if (n==1){
            if (nums[0]==target) return 0;
            else return -1;
        }
        int res = searchTarget(0, n-1, nums, target);
        return res;
    }


    private int searchTarget(int start, int end, int[] nums, int target) {

        if (start>=end){
            if (nums[start]==target) return start;
            else return -1;
        }

        int mid = (start+end)/2;
        if (nums[mid]==target) return mid;

        if (nums[mid]>nums[0]){
            //左边是有序的
            if (target>=nums[start]&&target<=nums[mid-1]){
                return searchTarget(start, mid-1, nums, target);
            }else {
                return searchTarget(mid+1, end, nums, target);
            }
        }else {
            //右边是有序的
            if (target>=nums[mid+1]&&target<=nums[end]){
                return searchTarget(mid+1, end, nums, target);
            }else {
                return searchTarget(start, mid-1, nums, target);
            }
        }


    }


}
