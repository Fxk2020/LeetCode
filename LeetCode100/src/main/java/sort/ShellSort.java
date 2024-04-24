package sort;

public class ShellSort {

    public static void shellSort(int[] nums){

        int n = nums.length;
        int gap = n/2;

        while (gap>0){
            for (int i = gap; i < n; i++) {

                int current = nums[i];
                int preNode = i-gap;
                while (preNode>=0&&nums[preNode]>current){

                    nums[preNode+gap] = nums[preNode];
                    preNode-=gap;
                }
                nums[preNode+gap] = current;
            }
            gap/=2;
        }
    }

}
