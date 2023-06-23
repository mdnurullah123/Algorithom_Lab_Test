/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfs;
import java.util.*;

public class BFS {
    private int vertices; 
    private LinkedList<Integer>[] adjacencyList;

    public BFS(int v) {
        vertices = v;
        adjacencyList = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
    }

    public void breadthFirstSearch(int startVertex) {
        boolean[] visited = new boolean[vertices]; // Array to track visited vertices

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<>();

        // Mark the current vertex as visited and enqueue it
        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            // Dequeue a vertex from the queue and print it
            int currentVertex = queue.poll();
            System.out.print(currentVertex + " ");

            // Get all adjacent vertices of the dequeued vertex
            // If an adjacent vertex has not been visited, mark it as visited and enqueue it
            Iterator<Integer> iterator = adjacencyList[currentVertex].listIterator();
            while (iterator.hasNext()) {
                int adjacentVertex = iterator.next();
                if (!visited[adjacentVertex]) {
                    visited[adjacentVertex] = true;
                    queue.add(adjacentVertex);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFS graph = new BFS(6); // Create a graph with 6 vertices

        // Add edges between vertices
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);

        System.out.println("BFS Traversal (starting from vertex 0):");
        graph.breadthFirstSearch(0);
    }
}