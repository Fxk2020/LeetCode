package day11;

public class T2 {

    public int findDuplicate(int[] nums) {

        int fast = 0, slow = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while (slow!=fast);

        fast = 0;//从零开始重新走
        do {
            slow = nums[slow];
            fast = nums[fast];
        }while (slow!=fast);

        return fast;
    }

}
