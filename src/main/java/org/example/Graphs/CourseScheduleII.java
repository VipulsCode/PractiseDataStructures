package org.example.Graphs;

import java.util.*;

public class CourseScheduleII {

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        // need to construct a graph

        Map<Integer, List<Integer>> graph = new HashMap<>();

        // at this instance there isn't any data in List<Integer> it is null, so let's populate the empty data

        for(int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>()); // so now the Map will contain the vertices and there associated indegrees
            // values, but at time being they are all empty
        }

        for (int i = 0; i < numCourses; i++) {
            for (int[] preReq : prerequisites) { // prerequisites[i] = [ai, bi], so here prerequisites indicates that you must take course bi first if you want to take course ai.
                int from = preReq[1];// so we are mentioning from means first we need to finish up this course to go to "to" course
                int to = preReq[0];

                List<Integer> toNodeList = graph.get(from);// now here i am getting the index of from node , at first it will be empty, and now it will be populated, imagine adjacency list "aData --->  { list od indegree}"
                // so here "aData" is fromNode --> { toNodeList}
                toNodeList.add(to);

                graph.put(from, toNodeList); //Now the graph has from --> {toNodeList}, i mean 1 data holding it's inDegree values
            }
        }
        // Completion of creating the graph

        // Now getting to know how many indegrees, in other words noting down the neighbours or node which have incoming edges.

        int[] inDegree = new int[numCourses]; // creating an array to know which index will have how many numbers of indegree, and the indexed will be again 0 to numCourses length

        for (int i = 0; i < inDegree.length; i++) {
            // Now to get indegree we need to get the list of indegree value every key (which is a numerical val from 0 to numCourses length)
            // holds from map graph, and those list of indegree values will be iterated and be used as a index to ingree, and there counts will be the indexed value of indegree array

            List<Integer> nodesWithIncomingDirn = graph.get(i); // now the i is index ranging again from 0 to numCourses, and this index in graph will have a list which might be empty or have list of indegree nodes

            for (int node : nodesWithIncomingDirn) {
                inDegree[node]++; // now every node which has incoming dirn is nothing but indegree, and we want to know , how many incoming dirn does one particular node has,
                // that's the reason indegree[incomingDirnSingleNode]++
            }
        }

        // Now it's always possible that there will be atleast one node/neighbour with 0 indegree, means a node with 0 incoming dirn.
        // so now the index of inDegree/s which gives 0 as val, will be added in Queue, (remember index), as index with 0 indegee val,
        // can be said that this has to considered first before proceeding to the next

        Queue<Integer> q = new LinkedList<>();
        // finding the indegrees with 0 val
        for(int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                q.add(i); // Adding index to Queue
            }
        }

        // Now the below step is BFS, so what we are trying to do here is poll the data from q, as we know that at starting the q will not be empty
        // as there will be one indegree index with 0 val, now we poll the data, and the data we obtained will certainly have outgoing dirn, so
        // can i say outDegree will not be 0, now once we want to wipe this data out from Queue, we will also wipe the edge where 0 indegree val points to,
        // so in other way this data will be an incoming node to some other node, so we will eleminate the incoming dorn, by this the node, for which
        // the polled data was an incoming, will be gone, and the indegree node will lose one incoming node, so indegree -- for the node which was having the
        // polled val as incoming node, so the idealogy is to find the new indegree node with 0 val


        List<Integer> topoOrdering = new ArrayList<>(); // this has to be used to gather the ordering whicg will say the 1st index
        // should be performed first before going to 2nd one, so it will follow the question rule and layout the ordering in a
        // way , the number which had to be known first will be in left and the next one will be followed by the left and so on, so linearly.

        while (!q.isEmpty()) {
            int node = q.poll();

            topoOrdering.add(node);// the polled node will be on topoSorting

           List<Integer> outDegreeNode = graph.get(node);
           // now getting the indegree node for this OutdegreeNode
           for (int inDegreeNode : outDegreeNode) {
               inDegree[inDegreeNode]--; //decrementing the indegree count which was held by the OutDegreeNode, as this called polled, so removing the edge it self

               // at the same instance ill check if the indegree of that particular indegreeNode has turned to 0 or what,
               // since we decremented, and this decrementaion will be happening in for loop, as the outdegree node might be multiple nodes incoming dirn node

               if (inDegree[inDegreeNode] == 0) {
                   q.add(inDegreeNode);
               }

            }

        }
        System.out.println("The size of topoOrder is "+ topoOrdering.size());

        if (topoOrdering.size() != numCourses) {
            return new int[0];
        }

        int[] resArray = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            resArray[i] = topoOrdering.get(i);
        }

        return resArray;
    }

    public static void main(String[] args) {

        int numCourses = 2;

        int[][] prerequisites = {{0,1},{1,0}};

        System.out.println(Arrays.toString(findOrder(numCourses, prerequisites)));

    }
}
