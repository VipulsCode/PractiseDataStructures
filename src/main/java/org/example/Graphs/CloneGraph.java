package org.example.Graphs;

import java.util.*;

public class CloneGraph {

/** Given Data in LEET CODE */
// Definition for a Node.
 class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}


    /** Done with the given Data in LEET CODE */

    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }

        Queue<Node> q = new LinkedList<>();
        Map<Node, Node> map = new HashMap<>(); // This is to check whether have i already considered that node or not

        q.add(node); // at first add the node given, which will take as a start point
        map.put(node, new Node(node.val, new ArrayList<>())); // at the start let the key be the 1st node,
        // and it's value as Node, with the node.val i.e., 1st val, but the array list is empty, what is this array list, remember Adjacency List concept
        // which has vertices and its List for eg vertices is 1 --> [2,4] 2,4 is its immediate neighbours, and this array list will be populated underneath

        while(!q.isEmpty()) {

            Node h = q.poll();// gives u a node
            // Now keeping Adjacency List concept in mind

            for (Node neighbour : h.neighbors) { // Here for every popped value, will have the Arraylist which will contain there
                // immediate neighbours details, i am fetching that list, through this i am getting to know the immediate neighbour,
                // and storing it in map as key
                if (!map.containsKey(neighbour)) {// i am checking by taking one node from the list of node, whether i
                    // have already passed through this node or not
                    map.put(neighbour, new Node(neighbour.val, new ArrayList<>()));// so if there isn't next neighbour for h node present in map
                    // we put it in map, as neighbour as key , and map value as neighbours value and a new arraylist, and this array list will be populated,
                    // in underneath code

                    q.add(neighbour); // add the Neighbour in Queue at every iteration
                }

                map.get(h).neighbors.add(map.get(neighbour));// what we are doing here is, as the iteration goes we are getting
                // the list associated to the actual node right,and these list will contain details about the neighbouring node of the actual node. here h is actual node
                // we need to populate these list, stating there is 2 way traversal so if the question contain
                /*1   2   actual node 1 will have neighbouring node as [2,4] and actual node 2 will also have {1,3}, so this has to be populated in the list
                  4   3 */

            }

        }

        return map.get(node); // This will return the value as we framed value as the clone of the given question, node is a key

    }
}
