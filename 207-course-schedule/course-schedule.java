// class Solution {
//     public boolean canFinish(int n, int[][] prerequisites) {
//         List<Integer>[] adj = new List[n];
//         int[] indegree = new int[n];
//         List<Integer> ans = new ArrayList<>();

//         for (int[] pair : prerequisites) {
//             int course = pair[0];
//             int prerequisite = pair[1];
//             if (adj[prerequisite] == null) {
//                 adj[prerequisite] = new ArrayList<>();
//             }
//             adj[prerequisite].add(course);
//             indegree[course]++;
//         }

//         Queue<Integer> queue = new LinkedList<>();
//         for (int i = 0; i < n; i++) {
//             if (indegree[i] == 0) {
//                 queue.offer(i);
//             }
//         }

//         while (!queue.isEmpty()) {
//             int current = queue.poll();
//             ans.add(current);

//             if (adj[current] != null) {
//                 for (int next : adj[current]) {
//                     indegree[next]--;
//                     if (indegree[next] == 0) {
//                         queue.offer(next);
//                     }
//                 }
//             }
//         }

//         return ans.size() == n;
//     }

// }

import java.util.*;
class Solution{
    public boolean canFinish(int numCourses, int[][] prerequisities){
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());

        }
        int indegree[]=new int[numCourses];
        for(int [] p : prerequisities ){
            int course=p[0];
            int pre=p[1];
            adj.get(pre).add(course);
            indegree[course]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i]==0)
                q.offer(i);
        }
        int count=0;
        while(!q.isEmpty()){
            int node=q.poll();
            count++;
            for(int nei :adj.get(node)){
                indegree[nei]--;
                if(indegree[nei]==0){
                    q.offer(nei);
                }
            }
        }
        return count == numCourses;
    }
}