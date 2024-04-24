package sort;

public class SelectionSort {


    public static void selection(int[] nums){
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            int maxIndex = findMax(nums, n-i);
            int index = n-1-i;

            if (maxIndex!=index){
                int tmp = nums[index];
                nums[index] = nums[maxIndex];
                nums[maxIndex] = tmp;
            }
        }
    }

    private static int findMax(int[] nums, int length) {

        int maxIndex = 0;
        for (int i = 1; i < length; i++) {
            if (nums[i]>nums[maxIndex]){
                maxIndex = i;
            }
        }
        return maxIndex;
    }


}
