package week1;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水
 */
public class T6 {

    public static int findMaxIndex(int[] arr) {
        int maxIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static int sumLeft(int[] height, int[] left){
        int max_index = left[0]+1;
        while (left[0]>0) {
            if (height[--left[0]]>=height[left[1]]){
                left[1]=left[0];
            }
        }
        int sum = 0;
        for (int k = left[1]+1; k < max_index; k++) {
            sum += height[left[1]]-height[k];
        }
        return sum;
    }

    public static int sumRight(int[] height, int[] right){
        int max_index = right[0]-1;
        while (right[0] < height.length-1) {
            if (height[++right[0]]>=height[right[1]]) {
                right[1] = right[0];
            }
        }

        int sum2 = 0;

        for (int k = max_index+1; k < right[1]; k++) {
            sum2+= height[right[1]] - height[k];
        }
        return sum2;
    }

    public int trap(int[] height) {

        int max_index = findMaxIndex(height);
//        int i = max_index-1;
//        int i2 = max_index+1;
//        int j = i;
//        int j2 = i2;
        int[] left = new int[]{max_index-1, max_index-1};
        int[] right = new int[]{max_index+1, max_index+1};

        int sum = sumLeft(height, left);
        int sum2 = sumRight(height, right);
        while (left[1]>0){
            left[0] = --left[1];
            sum+=sumLeft(height, left);
        }
        while (right[1]<height.length-1){
            right[0] = ++right[1];
            sum2+=sumRight(height, right);
        }

        return sum+sum2;

    }

    public static void main(String[] args) {
        System.out.println(new T6().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(new T6().trap(new int[]{4,2,0,3,2,5}));
    }
}
