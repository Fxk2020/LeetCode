package day10;

public class T1 {

    public boolean canJump(int[] nums) {

        int maxRight = 0;
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            if (i<=maxRight){
                maxRight = Math.max(maxRight, nums[i]+i);//i位置能到达的最远处与maxRight取一个大的值。
                if (maxRight>=length-1) return true;
            }else {
                break;//左边到达不了了，右边更无法到达
            }
        }

        return false;

    }



}
