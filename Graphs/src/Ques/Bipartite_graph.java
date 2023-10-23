package Ques;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Bipartite_graph {
    public static boolean isBipartite(Graph graph) {
        int n = graph.n;

        int v = 0;
        boolean[] discovered = new boolean[n];
        int[] level = new int[n];

        discovered[v] = true;
        level[v] = 0;

        Queue<Integer> q = new ArrayDeque<>();
        q.add(v);

        while (!q.isEmpty()) {
            v = q.poll();

            for (int u: graph.adjList.get(v)) {
                if (!discovered[u]) {
                    discovered[u] = true;
                    level[u] = level[v] + 1;
                    q.add(u);
                }
                else if (level[v] == level[u]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<Edge> edges = Arrays.asList(
                new Edge(0, 1), new Edge(1, 2), new Edge(1, 7), new Edge(2, 3),
                new Edge(3, 5), new Edge(4, 6), new Edge(4, 8), new Edge(7, 8)
        );
        int n  = 9;
        Graph graph = new Graph(edges, n);
        if(isBipartite(graph)) {
            System.out.println("yes");
        }
        else {
            System.out.println("not");
        }
    }
}


