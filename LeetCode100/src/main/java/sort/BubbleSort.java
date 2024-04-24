package sort;

public class BubbleSort {


    public static void bubble(int[] nums){
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n -1 -i; j++) {
                if (nums[j]>nums[j+1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }

    }


}
