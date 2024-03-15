package day12;

public class T5 {

    public int findMin(int[] nums) {

        int n = nums.length;
        int res = search(0, n-1, nums);
        return res;
    }


    private int search(int start, int end, int[] nums) {

        if (start>=end){
            return nums[start];
        }

        int mid = (start+end)/2;
        if (nums[mid]>nums[end]) return search(mid+1, end, nums);
        else return search(start, mid, nums);

    }


    public static void main(String[] args) {
        System.out.println(new T5().findMin(new int[]{3,4,5,1,2}));
    }


}
