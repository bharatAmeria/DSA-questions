package Ques;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Arrival_and_departure_time_of_vertices {
    public static int DFS (Graph graph, int v, boolean[] discovered, int[] arrival, int[] departure, int time) {
        arrival[v] = ++time;

        discovered[v] = true;
        for (int i : graph.adjList.get(v)) {
            if (!discovered[i]) {
                time = DFS(graph, i, discovered, arrival, departure, time);
            }
        }
        departure[v] = ++time;
        return time;
    }

    public static void main(String[] args) {
        List<Edge> edges = Arrays.asList(
                new Edge(0, 1), new Edge(0, 2), new Edge(2, 3), new Edge(2, 4),
                new Edge(3, 1), new Edge(3, 5), new Edge(4, 5), new Edge(6, 7)
        );
        int n = 8;
        Graph graph = new Graph(edges, n);

        int[]  arrival = new int[n];
        int[] departure = new int[n];

        boolean[] discovered = new boolean[n];
        int time = -1;

        for (int i = 0; i < n; i++) {
            if (!discovered[i]) {
                time = DFS(graph, i, discovered, arrival, departure, time);
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(i + "(" + arrival[i] + "," + departure[i] + ")");
        }
    }
}
class Edge {
    int source, dest;

    public Edge(int source, int dest) {
        this.source = source;
        this.dest = dest;
    }
}

class Graph {

    int n;
    List<List<Integer>> adjList = null;

    Graph(List<Edge> edges, int n) {
        adjList  = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (Edge edge: edges) {
            adjList.get(edge.source).add(edge.dest);
        }
    }
}
