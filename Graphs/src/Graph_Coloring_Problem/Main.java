package Graph_Coloring_Problem;

import java.util.*;

class Main {
    private static final String[] color = {
            "", "BLUE", "GREEN", "RED", "YELLOW", "ORANGE", "PINK",
            "BLACK", "BROWN", "WHITE", "PURPLE", "VOILET" };

    public static void colorGraph(Graph graph, int n) {
        Map<Integer, Integer> result = new HashMap<>();

        for (int i = 0; i < n; i++) {
            Set<Integer> assigned  = new TreeSet<>();
            for (int u: graph.adjList.get(i)) {
                if (result.containsKey(u)) {
                    assigned.add(result.get(u));
                }
            }
            int color = 1;
            for (Integer c: assigned ) {
                if (color != c) {
                    break;
                }
                color++;
            }
            result.put(i, color);
        }
        for (int j = 0; j < n; j++) {
            System.out.println("The colour assigned to vertex " + j + " is " + color[result.get(j)]);
        }
    }
    public static void main(String[] args) {
        List<Edge> edges = Arrays.asList(
                new Edge(0, 1), new Edge(0, 4), new Edge(0, 5), new Edge(4, 5),
                new Edge(1, 4), new Edge(1, 3), new Edge(2, 3), new Edge(2, 4) );
        int n = 6;
        Graph graph = new Graph(edges, n);
        colorGraph(graph, n);
    }
}
