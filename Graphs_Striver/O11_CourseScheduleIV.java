// import java.util.*;

// public class O11_CourseScheduleIV {
//     public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
//         List<List<Integer>> adj = new ArrayList<>();
//         int[] indegree = new int[numCourses];
//         for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());

//         for (int[] pre : prerequisites) {
//             adj.get(pre[0]).add(pre[1]);
//             indegree[pre[1]]++;
//         }
//         List<Set<Integer>> prereq = new ArrayList<>();
//         for (int i = 0; i < numCourses; i++) prereq.add(new HashSet<>());

//         Queue<Integer> q = new LinkedList<>();
//         for (int i = 0; i < numCourses; i++) {
//             if (indegree[i] == 0) q.offer(i);
//         }

//         while (!q.isEmpty()) {
//             int curr = q.poll();
//             for (int next : adj.get(curr)) {
//                 prereq.get(next).add(curr);
//                 prereq.get(next).addAll(prereq.get(curr)); 
//                 if (--indegree[next] == 0) {
//                     q.offer(next);
//                 }
//             }
//         }
//         List<Boolean> res = new ArrayList<>();
//         for (int[] query : queries) {
//             res.add(prereq.get(query[1]).contains(query[0]));
//         }
//         return res;
//     }
// }
