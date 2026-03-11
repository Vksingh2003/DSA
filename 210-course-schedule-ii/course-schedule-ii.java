import java.util.*;

class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<numCourses;i++)
            adj.add(new ArrayList<>());

        int indegree[] = new int[numCourses];

        for(int[] p : prerequisites){

            int course = p[0];
            int pre = p[1];

            adj.get(pre).add(course);
            indegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0)
                q.offer(i);
        }

        int result[] = new int[numCourses];
        int index = 0;

        while(!q.isEmpty()){

            int node = q.poll();
            result[index++] = node;

            for(int nei : adj.get(node)){

                indegree[nei]--;

                if(indegree[nei]==0)
                    q.offer(nei);
            }
        }

        if(index == numCourses)
            return result;

        return new int[0];
    }
}