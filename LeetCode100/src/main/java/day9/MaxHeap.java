package day9;

/**
 * 大根堆的相关操作
 * 1.初始化
 * 2.删除
 * 3.新增
 */
public class MaxHeap {

    int heapSize;
    public int findKthLargest(int[] nums, int k) {

        this.heapSize = nums.length;
        initMaxHeap(nums);
        for (int i = 0; i < k-1; i++) {
            pop(nums);
        }
        return nums[0];
    }

    public int[] topKFrequent(int[] nums, int k) {
        this.heapSize = nums.length;
        initMaxHeap(nums);
        if (k<=0) return null;
        int[] tmp = new int[k];
        tmp[0] = nums[0];
        for (int i = 1; i < k; i++) {
            pop(nums);
            tmp[i] = nums[0];
        }
        return tmp;
    }

    public void initMaxHeap(int[] nums){

        int haveChild = (this.heapSize-2)/2;
        for (int i = haveChild; i >=0 ; i--) {

            int element = nums[i];
            int children = 2*i+1;//左孩子
            while (children<=this.heapSize-1){

                if (children<this.heapSize-1&&nums[children+1]>nums[children]){
                    children++;//取两个孩子中大的值
                }

                if (nums[children]<=element){
                    break;
                }

                //孩子比element大1.将大孩子设为根，2.继续看element是否大于大孩子的孩子
                nums[(children-1)/2] = nums[children];
                children = children*2+1;

            }
            nums[(children-1)/2] = element;
        }
    }

    public void pop(int[] nums){
        this.heapSize--;
        int element = nums[heapSize];
        nums[heapSize] = nums[0];

        int start = 0;
        int children = 1;
        while (children<heapSize){

            if (children<heapSize-2&&nums[children+1]>nums[children]){
                children++;//取两个孩子中大的值
            }

            if (nums[children]<=element){
                break;
            }

            //孩子比element大1.将大孩子设为根，2.继续看element是否大于大孩子的孩子
            nums[start] = nums[children];
            start = children;
            children = children*2+1;

        }
        nums[start] = element;
    }

    public void push(int[] nums){
        //需要长度可以变化
        return;
    }


}
