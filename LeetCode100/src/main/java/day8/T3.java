package day8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 *
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 *
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 */
public class T3 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Queue<Integer> queue = new LinkedList<>();

        List<List<Integer>> adjacency = new ArrayList<>();
        int[] indegrees = new int[numCourses];

        int unFinishCourse = numCourses;
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }

        for (int[] i:
             prerequisites) {
            indegrees[i[0]]++;
            adjacency.get(i[1]).add(i[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i]==0) queue.add(i);
        }

        while (!queue.isEmpty()){
            int tmp = queue.poll();
            unFinishCourse--;

            for (Integer course:
                 adjacency.get(tmp)) {
                if (--indegrees[course]==0) {
                    queue.add(course);
                }
            }
        }
        return unFinishCourse==0;
    }

}
