import java.util.*;

public class KruskalsAlgorithm {
    static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int wt) {
            this.src = s;
            this.dest = d;
            this.wt = wt;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.wt - e2.wt;
        }
    }

    static void createGraph(ArrayList<Edge> edges) {
        // edges
        edges.add(new Edge(2, 3, 50));
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
    }

    static int n = 4; // vertices
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void init() {
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
    }

    public static int find(int x) {
        if (x == par[x]) {
            return x;
        }

        return par[x] = find(par[x]);
    }

    public static void union(int x1, int x2) {
        int parA = find(x1);
        int parB = find(x2);

        if (rank[parA] == rank[parB]) {
            par[parB] = parA;
            rank[parA]++;
        } else if (rank[parA] < rank[parB]) {
            par[parA] = parB;
        } else {
            par[parB] = parA;
        }
    }

    public static void kruskalsMST(ArrayList<Edge> edges, int V) {
        Collections.sort(edges); // O(ElogE)
        int mstCost = 0;
        int count = 0;

        for (int i = 0; count < V - 1; i++) { // O(V)
            Edge e = edges.get(i);
            // src, dest, wt

            int parA = find(e.src); // src = a
            int parB = find(e.dest); // src = b

            if (parA != parB) {
                union(e.src, e.dest);
                mstCost += e.wt;
                count++;
            }
        }

        System.out.println(mstCost);
    }

    public static void main(String[] args) {
        init();
        int V = 4;
        ArrayList<Edge> edges = new ArrayList<>();
        createGraph(edges);
        kruskalsMST(edges, V);
    }
}
