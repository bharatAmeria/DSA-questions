import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Directed_graphs_digraph {
    public static void main(String[] args) {
        List<Edge> edges = Arrays.asList(new Edge(0, 1), new Edge(1, 2),new Edge(2, 0), new Edge(2, 1), new Edge(3, 2),
                new Edge(4, 5), new Edge(5, 4));

        Graph graph = new Graph(edges);
        Graph.printGraph(graph);
    }

}
class Edge {
    int src, dest;

    Edge(int src, int edge) {
        this.src = src;
        this.dest = edge;
    }
}
class Graph {
    List<List<Integer>> adjList = new ArrayList<>();

    public Graph(List<Edge> edges) {
        int n = 0;
        for (Edge e: edges) {
            n = Integer.max(e.src, e.dest);
        }

        for (int i = 0; i <= n; i++) {
            adjList.add(i, new ArrayList<>());
        }

        for (Edge current: edges) {
            adjList.get(current.src).add(current.dest);
        }
    }

    public static void printGraph(Graph graph) {
        int src = 0;
        int n = graph.adjList.size();

        while (src < n) {
            for (int dest : graph.adjList.get(src)) {
                System.out.println("(" + src + "-->" + dest + ")");
            }
            System.out.println();
            src++ ;
        }
    }

}
