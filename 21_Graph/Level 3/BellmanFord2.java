import java.util.*;

public class BellmanFord2 {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void CreateGraph(ArrayList<Edge> graph) {
        // 0 Vetex
        graph.add(new Edge(0, 1, 2));
        graph.add(new Edge(0, 2, 4));

        // 1 Vetex
        graph.add(new Edge(1, 2, -4));

        // 2 Vetex
        graph.add(new Edge(2, 3, 2));

        // 3 Vertex
        graph.add(new Edge(3, 4, 4));

        // 4 Vertex
        graph.add(new Edge(4, 1, -1));
    }

    public static void bellmanFord(ArrayList<Edge> graph, int src, int V) {
        int dist[] = new int[V];
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        // TC -> O(V*E)
        // algo -> O(V)
        for (int i = 0; i < V - 1; i++) {
            // edges -> O(E)
            for (int j = 0; j < graph.size(); j++) {
                Edge e = graph.get(j);

                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                // relaxation
                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        // print
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph = new ArrayList<>();
        CreateGraph(graph);
        bellmanFord(graph, 0, V);
    }
}
