package week1;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 */
public class T1 {
    public void moveZeroes1(int[] nums) {

        int end = nums.length-1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==0){
                for (int j = i; j < end; j++) {
                    nums[j] = nums[j+1];
                }
                nums[end] = 0;
                end--;
                i--;//提上来的数字不一定不是零
            }
            if (end==i){

                return;
            }
        }

    }

    public void moveZeroes(int[] nums) {
        /**
         * 双指针
         */

        int b = 0;//不是零的个数
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=0){
                nums[b] = nums[i];
                b++;
            }
        }

        for (int i = b; i < nums.length; i++) {
            nums[i] = 0;
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1};
        new T1().moveZeroes(nums);
    }
}
