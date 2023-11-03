package Print_allHamiltonian_paths_present_in_a_graph;
import Graph_Coloring_Problem.Edge;
import java.util.ArrayList;
import java.util.List;

public class Graph1 {
    List<List<Integer>> adjList = null;

    Graph1(List<Edge> edges, int n) {
        adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (Edge edge: edges) {
            int src = edge.src;
            int dest = edge.dest;

            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }
    }
}
