package sort;

public class QuickSort {

    public static void quicksort(int[] nums, int start, int end){

        if (start<end){

            int position = getPartition(nums, start, end);
            quicksort(nums, start, position-1);
            quicksort(nums, position+1, end);
        }
    }

    private static int getPartition(int[] nums, int start, int end) {

        int pivot = nums[end];
        int point = start;//在point左侧的元素都是<=pivot的
        for (int i = start; i < end; i++) {
            if (nums[i]<=pivot){
                int tmp = nums[point];
                nums[point++] = nums[i];
                nums[i] = tmp;
            }
        }
        int tmp = nums[point];
        nums[point] = pivot;
        nums[end] = tmp;
        return point;
    }


}
