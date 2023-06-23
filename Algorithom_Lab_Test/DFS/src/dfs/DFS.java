/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dfs;

import java.util.*;

public class DFS {
    private int vertices; 
    private LinkedList<Integer>[] adjacencyList; 

    public DFS(int v) {
        vertices = v;
        adjacencyList = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
    }

    public void depthFirstSearch(int startVertex) {
        boolean[] visited = new boolean[vertices]; // Array to track visited vertices

        dfsUtil(startVertex, visited);
    }

    private void dfsUtil(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        Iterator<Integer> iterator = adjacencyList[vertex].listIterator();
        while (iterator.hasNext()) {
            int adjacentVertex = iterator.next();
            if (!visited[adjacentVertex]) {
                dfsUtil(adjacentVertex, visited);
            }
        }
    }

    public static void main(String[] args) {
        DFS graph = new DFS(6); // Create a graph with 6 vertices

        // Add edges between vertices
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);

        System.out.println("DFS Traversal (starting from vertex 0):");
        graph.depthFirstSearch(0);
    }
}
