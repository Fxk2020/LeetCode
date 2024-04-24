package sort;

public class Main {

    public static void main(String[] args) {

        int[] nums = new int[]{1,2,3,5,69,8,5,7,1,2,213,3};
//        HeapSort.heapSort(nums);
//        QuickSort.quicksort(nums, 0, nums.length-1);
//        int[] nums2 = MergeSort.merge(nums);
        ShellSort.shellSort(nums);
//        SelectionSort.selection(nums);

//        BubbleSort.bubble(nums);
        for (int num:
             nums) {
            System.out.println(num);
        }
//        System.out.println("==========================");
//        for (int num :
//                nums2) {
//            System.out.println(num);
//        }
        Integer a=3,b=3;
        System.out.println(a==b);
    }

}
