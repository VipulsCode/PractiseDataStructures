package org.example.Graphs;

import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Creating the graph
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>()); // so initializing at every null index WITH EMPTY ARRAYList
        }


        for (int[] pr : prerequisites) {
            int fromCourse = pr[1];
            int toCourse = pr[0];
            List<Integer> ls = graph.get(fromCourse);
            ls.add(toCourse); // this gives the list and provides with the info of indegree for toCourse , i.e, how many from course ar approaching toCourse
            graph.putIfAbsent(fromCourse, ls);
        }

        int[] indegree = new int[numCourses]; // creates indegree course with 0 as default

        for (int i = 0; i < numCourses; i++) {
            for (int inDegreeNode : graph.get(i)) {// we can get the indegree data only after going inside the list
                indegree[inDegreeNode]++; // this gives the inDegreeNode if they are repeated indegree at that index will be incremented, so if the list is empty so indegree will no be populated
            }
        }

        // Now i have indegree, so there is always a possibility that at least 1 inDegree will be 0, there can be more, indegree being 0 means for that vertices there werent and incoming arraow

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);

            }
        }
        List<Integer> topSort = new ArrayList<>();
        while (!q.isEmpty()) {
            int x = q.poll();
            topSort.add(x);
            List<Integer> ls1 = graph.get(x);
            for (int iv : ls1) {
                indegree[iv]--;// why --, becaise we are removing node which are in queue , so the removed q data will be having outDegree sign to some other node, so once the data i removed, then the indegree should be lessen by one count
                if (indegree[iv] == 0) {
                    q.add(iv);
                }
            }
        }

        return topSort.size() == numCourses;
    }
}
