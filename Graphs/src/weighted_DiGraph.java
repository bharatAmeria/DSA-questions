import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class weighted_DiGraph {
    public static void main(String[] args) {
        List<Edges> edges = Arrays.asList(
                new Edges(0, 1, 6), new Edges(1, 2, 7), new Edges(2, 0, 5),
                new Edges(2, 1, 4), new Edges(3, 2, 10), new Edges(4, 5, 1),
                new Edges(5, 4, 3)
        );

        Graphs graph = new Graphs(edges);
        Graphs.printGraph(graph);
    }
}
class Edges {
    int src, dest, weight;

    Edges(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

class Node {
    int value, weight;

    Node(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
    @Override
    public String toString() {
        return this.value + "(" + this.weight + ")";
    }
}

class Graphs {
    List<List<Node>> adjList = new ArrayList<>();

    public Graphs(List<Edges> edges) {
        int n = 0;
        for (Edges e : edges) {
            n = Integer.max(n, Integer.max(e.src, e.dest));
        }

        for (int i = 0; i <= n; i++) {
            adjList.add(i, new ArrayList<>());
        }
        for (Edges e: edges) {
            adjList.get(e.src).add(new Node(e.dest, e.weight));
        }
    }
    public static void printGraph(Graphs graph) {
        int src = 0;
        int n = graph.adjList.size();

        while (src < n) {
            for (Node edge : graph.adjList.get(src)) {
                System.out.printf("%d ——> %s\t", src, edge);
            }
            System.out.println(n);
            src++;
        }
    }
}
