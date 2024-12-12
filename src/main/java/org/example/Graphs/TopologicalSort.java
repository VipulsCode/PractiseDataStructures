package org.example.Graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LINK : https://www.youtube.com/watch?v=73sneFXuTEg
 *
 * The primary idea of Topological sort is
 *  1. You'll be given the adjacency list, which is a collection of unordered lists used to represent a finite graph.
 *  2. You'll be given the vertices
 *  3 . Create the indegree using adjacency list, and check if any index of indegree has the value as 0 , push that index (not the index value, just index) to the Queue
 *  4. Now retrieve that data from the Queue, and check if the retrieved integer is an incoming to some other vertices, if yes decrease the indegree value of that vertices(which will be acting as index) by 1
 *  5. once you remove the integer from the queue , the same integer can be pushed in a new topo sort created array
 *  6. Once retrieved from the Queue, and decreasing the indegree index value by 1(the index is the retrieved integer from queue), again check in the indegree,
 *  if any index has value 0, if yes add that in QUEUE.
 *
 *  SO TOPOLOGICAL SORT SAYS , IF THERE ARE TWO EDGES U & V EXISTS, THE LINEAR ORDERING OF THE TWO EDGES WILL BE PLACED IN SUCH A WAY THAT U APPEARS BEFORE V
 */
public class TopologicalSort {
    public static int[] topoSort(int v , List<List<Integer>> adj) {

        // creating indegree array
        int[] inDegree = new int[v];

        for (int i = 0; i < v; i++) { // so iterating till the given vertices, and the adjacency list will have list of data against this vertex,
            // for eg vertex 2 --> (3,4) so i can say vertex 2 is entering vertex 3 and 4
            for (int adjSingleData : adj.get(i)) { // now every individual i has list of vertex mentioned to which i enters to, as said above.

                inDegree[adjSingleData]++; // as i said i'll be treating these individual vertex retrieved from adjacency list, as the index of indegree
                // (and the index value will be the number of times any other vertex enters the said individual vertex retrieved from adjacency list)

            }
        }
        // creation of inDegree is done

        // Now we know that there will be at least one indegree index whose value will be 0, in other there wouldn't be any other vertex entering this index, use that index and insert it in Queue

        Queue<Integer> q  = new LinkedList<>();

        for (int i = 0 ; i < v; i++) {
            if (inDegree[i] == 0) {
                q.add(i); // so here i am adding the index not the indegree index val remember that
            }
        }

        // Now there will be atleast one indegree which has 0 incoming vertex, pop that from queue

        int[] topo = new int[v]; // this will the collection of linear ordering and sorted topologically
        int i = 0;

        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();

            topo[i++]= node;

            // now the removed indegree index (node)from the Queue would be someone's incoming vertex , read carefully i am not saying they have incoming request ,
            // as the indegree index value which is zero only those index feature in Queue. Soi am telling the node will be someone's incoming vertex, now reduce the count value in indegree of that someone's index

            // so to get the vertices for which the above obtained node is an incoming node, obtain it from adjacency list and iterate that list to get the individual
            // nodes and use the node as index for indegree and reduce the count val, why reducing this incoming , coz i have removed the node which was incoming from the queue
            for (int it : adj.get(node)) {
                inDegree[it]--;

                if (inDegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        return topo;
    }
}
