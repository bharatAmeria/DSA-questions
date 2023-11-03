package Print_allHamiltonian_paths_present_in_a_graph;
import Graph_Coloring_Problem.Edge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Main {
    public static void hamiltonianPaths(Graph1 graph, int v, boolean[] visited, List<Integer> path, int n) {
        if (path.size() == n) {
            System.out.println(path);
            return;
        }
        for (int w: graph.adjList.get(v)) {
            if (!visited[w]) {
                visited[w] = true;
                path.add(w);
                hamiltonianPaths(graph, w, visited, path, n);
                visited[w] = false;
                path.remove(path.size() - 1);
            }
        }
    }
    public static void findHamiltonian(Graph1 graph, int n) {
        for (int start = 0; start < n; start++) {
            List<Integer> path = new ArrayList<>();
            path.add(start);
            boolean[] visited = new boolean[n];
            visited[start] = true;
            hamiltonianPaths(graph, start, visited, path, n);
        }
    }

    public static void main(String[] args) {
        List<Edge> edges = Arrays.asList(
                new Edge(0, 1), new Edge(0, 2), new Edge(0, 3),
                new Edge(1, 2), new Edge(1, 3), new Edge(2, 3) );
        int n = 4;
        Graph1 graph = new Graph1(edges, n);
        findHamiltonian(graph, n);
    }
}
