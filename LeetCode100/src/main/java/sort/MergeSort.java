package sort;

import java.util.Arrays;

public class MergeSort {

    public static int[] merge(int[] nums){
        if (nums.length<=1){
            return nums;
        }
        int middle = nums.length/2;
        int[] arr1 = Arrays.copyOfRange(nums, 0, middle);
        int[] arr2 = Arrays.copyOfRange(nums, middle, nums.length);
        return mergeSort(merge(arr1), merge(arr2));
    }

    private static int[] mergeSort(int[] arr1, int[] arr2) {

        int[] res = new int[arr1.length+arr2.length];
        int ind = 0,ind1 = 0,ind2 = 0;

        while (ind1<arr1.length&&ind2<arr2.length){

            if (arr1[ind1]>arr2[ind2]){
                res[ind++] = arr2[ind2++];
            }else {
                res[ind++] = arr1[ind1++];
            }
        }

        if (ind1<arr1.length){
            while (ind1<arr1.length){
                res[ind++] = arr1[ind1++];
            }
        }else {
            while (ind2<arr2.length){
                res[ind++] = arr2[ind2++];
            }
        }
        return res;
    }

}
