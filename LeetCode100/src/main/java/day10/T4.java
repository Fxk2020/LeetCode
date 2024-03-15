package day10;

/**
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 */
public class T4 {

    public void sortColors(int[] nums) {

        int length = nums.length;
        if (length==1) return;
        int left = 0;
        int right = length-1;

        while (nums[left]==0&&left<length-1) left++;
        while (nums[right]==2&&right>0) right--;

        int i = left;
        while (i <= right) {

            if (i<left){
                i = left;
            }

            if (nums[i]==0) {
                swapMy(left, i, nums);
                while (nums[left]==0&&left<length-1) left++;
            }
            if (nums[i]==2) {
                swapMy(right, i, nums);
                while (nums[right]==2&&right>0) right--;
                while (nums[left]==0&&left<length-1) left++;
            }
            if (nums[i]==1) i++;
        }


    }

    private void swapMy(int j, int i, int[] nums) {
        if (i==j) return;
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;

    }

    public static void main(String[] args) {
        new T4().sortColors(new int[]{2,0,2,1,1,0});
    }


}
