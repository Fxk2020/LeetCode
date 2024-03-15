package day11;

/**
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，
 * 那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 */

public class T1 {

    public void nextPermutation(int[] nums) {

        int length = nums.length;
        if (length==0||length==1) return;
        int i = length-2;
        int j = length-1;
        while (!(nums[j]>nums[i])){
            i--;
            j--;

            if (i<0) {
                reverseArray(nums, 0, length-1);
                return;
            }
        }

        for (int k = length-1; k >= j; k--) {

            if (nums[k]>nums[i]){
                int tmp = nums[k];
                nums[k] = nums[i];
                nums[i] = tmp;
                break;
            }
        }

        reverseArray(nums, j, length-1);
    }

    private void reverseArray(int[] arr, int left , int right) {
        int i = left, j = right;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }


}
