package heap;

public class MaxHeap {

    private int[] nums;

    public MaxHeap(int[] nums) {
        //从1开始
        this.nums = nums;
        int tail = nums.length-1;

        /**
         * 自底向上的重新堆
         */
        for (int root = tail/2; root >= 1; root--) {

            int rootElement = nums[root];
            int child = root*2;
            while (child<=tail){

                if (child<tail&&nums[child+1]>nums[child]) child++;//选取两个孩子中大的一个
                if (rootElement>=nums[child]) break;
                else {
                    nums[child/2] = nums[child];
                }
                child*=2;
            }
            nums[child/2] = rootElement;//合适的位置
        }
    }


    public void push(int num){

        int currentNode = this.nums.length;
        while (currentNode!=1&&this.nums[currentNode/2]<num){
            this.nums[currentNode] = this.nums[currentNode/2];
            currentNode/=2;
        }
        this.nums[currentNode] = num;
    }

    /**
     * 自顶向下的重新堆
     */
    public void pop(){

        int currentNode = 1;
        int lastElement = nums[nums.length-1];
        this.nums[nums.length-1] = this.nums[1];
        int child = 2;
        while (child<=this.nums.length-2){
            if (child<this.nums.length-2&&nums[child+1]>nums[child]) child++;//选一个大孩子
            if (lastElement>=nums[child]) break;
            else {
                nums[currentNode] = nums[child];
                currentNode=child;
                child*=2;
            }
        }
        nums[child/2] = currentNode;
    }



}
