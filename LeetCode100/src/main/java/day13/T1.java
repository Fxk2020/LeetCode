package day13;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 */
public class T1 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;

        int index1 = (m+n)/2;
        int index2 = (m+n-1)/2;

        int i = 0;
        int j = 0;
        int index = 0;
        int res = 0;

        if (index2==index1){
            //一共奇数个数--index1就够了

            while (index<=index1){
                if (j>=n){
                    //num2到头了
                    if (index==index1) res=nums1[i];
                    i++;
                    index++;
                    continue;
                }
                if (i>=m){
                    //num1到头了
                    if (index==index1) res=nums2[j];
                    j++;
                    index++;
                    continue;
                }

                if (nums1[i]<nums2[j]) {
                    //j到头了j就不会+了
                    if (index==index1) res = nums1[i];
                    i++;
                } else {
                    //num1到头了+或者num2_j>=num1_i
                    if (index==index1) res = nums2[j];
                    j++;
                }
                index++;
            }

            return res;

        }else {
            //一共偶数个数--（index1+index2）/2

            while (index<=index1){
                if (j>=n){
                    //num2到头了
                    if (index==index2) res+=nums1[i];
                    if (index==index1) res+=nums1[i];
                    i++;
                    index++;
                    continue;
                }
                if (i>=m){
                    //num1到头了
                    if (index==index1) res+=nums2[j];
                    if (index==index2) res+=nums2[j];
                    j++;
                    index++;
                    continue;
                }


                if (nums1[i]<nums2[j]) {
                    if (index==index2) res+=nums1[i];
                    if (index==index1) res+=nums1[i];
                    i++;
                } else {
                    if (index==index2) res+=nums2[j];
                    if (index==index1) res+=nums2[j];
                    j++;
                }
                index++;
            }
            return (double) res /2;

        }

    }


}
