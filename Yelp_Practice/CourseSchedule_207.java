import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prereqs) {
        int[][] matrix = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];

        for(int i=0;i<prereqs.length;i++) {
            int course = prereqs[i][0];
            int pre = prereqs[i][1];
            if(matrix[pre][course] == 0)
                indegree[course]++;
            matrix[pre][course] = 1;
        }

        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<indegree.length;i++) {
            if(indegree[i] == 0)
                q.offer(i);
        }
        while(!q.isEmpty()) {
            int course = q.poll();
            count++;
            for(int i=0;i<numCourses;i++) {
                if(matrix[course][i] != 0) {
                    if(--indegree[i] == 0)
                        q.offer(i);
                }
            }
        }
        return count == numCourses;
    }
}