package day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 */
public class T2 {
    public int[][] merge2(int[][] intervals) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(0);
        for (int i = 0; i < intervals.length-1; i++) {
            arrayList.add(i+1);
            for (int j = i+1; j < intervals.length; j++) {

                if (intervals[i][1]>=intervals[j][0]&&intervals[j][1]>=intervals[i][0]){
                    //将合并后的放在后边出现的位置
                    intervals[j][0] = Math.min(intervals[i][0], intervals[j][0]);
                    intervals[j][1] = Math.max(intervals[i][1], intervals[j][1]);
                    arrayList.remove(arrayList.indexOf(i));
                    break;
                }
            }
        }
        int[][] result = new int[arrayList.size()][1];
        for (int i = 0; i < arrayList.size(); i++) {
            result[i] = intervals[arrayList.get(i)];
        }
        return result;
    }

    public int[][] merge(int[][] intervals) {
        //2. lambda表达式--进行二维数据按列排序
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> merge = new ArrayList<int[]>();

        int[] tmp = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0]>tmp[1]){
                merge.add(tmp);
                tmp = intervals[i];
            }else {
                tmp = new int[]{tmp[0], Math.max(tmp[1], intervals[i][1])};
            }
        }
        merge.add(tmp);
        return merge.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        System.out.println(new T2().merge(new int[][]{{1,4},{0,2},{3,5}}));
    }
}
