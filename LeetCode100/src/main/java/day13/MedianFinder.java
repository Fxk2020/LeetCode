package day13;

import java.util.*;

/**
 * 实现 MedianFinder 类:
 *
 * MedianFinder() 初始化 MedianFinder 对象。
 *
 * void addNum(int num) 将数据流中的整数 num 添加到数据结构中。
 *
 * double findMedian() 返回到目前为止所有元素的中位数。与实际答案相差 10-5 以内的答案将被接受。
 */
class MedianFinder {

    //复杂度超了
//    ArrayList<Integer> valuse;
//
//    public MedianFinder() {
//        valuse = new ArrayList<>();
//    }
//
//    public void addNum(int num) {
//        valuse.add(num);
//    }
//
//    public double findMedian() {
//
//        Object[] res = valuse.toArray();
//        Arrays.sort(res);
//        int size = valuse.size();
//
//        if (size%2==0){
//            int tmp = (int) res[size / 2];
//            int tmp2 = (int) res[size / 2 - 1];
//            return (double) (tmp2+tmp) /2;
//        }else {
//            return (int) res[size/2];
//        }
//
//    }

    PriorityQueue<Integer> queryMin;
    PriorityQueue<Integer> queryMax;
    public MedianFinder() {
        queryMin = new PriorityQueue<>((a,b)->b-a);
        queryMax = new PriorityQueue<>();//默认是小根堆
    }

    public void addNum(int num) {
        if (queryMin.isEmpty()||num<queryMin.peek()){
            queryMin.add(num);
            if (queryMin.size()>queryMax.size()+1){
                queryMax.add(queryMin.poll());
            }
        }else {
            queryMax.add(num);
            if (queryMax.size()>queryMin.size()){
                queryMin.add(queryMax.poll());
            }
        }

    }

    public double findMedian() {

        if (queryMin.size()==queryMax.size()) return (double) (queryMin.peek() + queryMax.peek()) /2;
        else return queryMin.peek();

    }
}
