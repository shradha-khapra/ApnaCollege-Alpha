
import java.util.*;
public class BFS{
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int s,int d,int w){ 
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
            //sab ArrayList Null this ab vo empty hai , null or empty dono alag hai null hota hai Undefined
        }

 //By default Weight 1 liya kuyki diya nhi hai
        graph[0].add(new Edge(0,1,1));
        graph[0].add(new Edge(0,2,1));

        graph[1].add(new Edge(1,0,1));
        graph[1].add(new Edge(1,3,1));

        graph[2].add(new Edge(2,0,1));
        graph[2].add(new Edge(2,4,1));

        graph[3].add(new Edge(3,1,1));
        graph[3].add(new Edge(3,4,1));
        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,2,1));
        graph[4].add(new Edge(4,3,1));
        graph[4].add(new Edge(4,5,1));

        graph[5].add(new Edge(5,3,1));
        graph[5].add(new Edge(5,4,1));
        graph[5].add(new Edge(5,6,1));

        graph[6].add(new Edge(6,5,1));
    }

    public static void bfs(ArrayList<Edge> graph[]){  // O(V+E)  V -> vertices, E -> edge
    //BFS => Go to immediate neighbour first
        Queue<Integer> q = new LinkedList<>();
        boolean visit[] = new boolean[graph.length];
        q.add(0); //src = 0 (kuch or bhi maan skate hai)

        while(!q.isEmpty()){
            int curr = q.remove();

            if(!visit[curr]){
                System.out.print(curr+" ");
                visit[curr]=true;

            //Now add immediate neighbours
            for(int i=0;i<graph[curr].size();i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest); //dest hi neighbours hoga src ka
                }
            }
        }
    }

    public static void main(String args[]){
        /*
    //By default Weight 1 liya kuyki diya nhi hai

            1 --- 3
           /      | \
          0       |  5 -- 6
           \      | /
            2 --- 4

         */

         int V =7;
         ArrayList<Edge> graph[] = new ArrayList[V];
         createGraph(graph);
         bfs(graph);
         // 0 1 2 3 4 5 6 
         // ye vse hi Order m aaye hai jse Dry Run kerne per aaye the
    }
}