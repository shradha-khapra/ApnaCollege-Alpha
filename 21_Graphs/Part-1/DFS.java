
import java.util.*;
public class DFS{
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

 //By default Weight 1 liya kuyki diya nhi hai Graph m Likhna jruri nhi h,Bus Standard hota hai wt bhi likne ka 
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

    public static void dfs(ArrayList<Edge> graph[],int curr,boolean visit[]){  //O(V+E)
    //DFS => Keep going to the 1st neighbour
        //Visit
        System.out.print(curr+" ");
        visit[curr]=true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!visit[e.dest]){
                dfs(graph,e.dest,visit);
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
         dfs(graph, 0, new boolean[V]); 
         //V ki jaghe per graph.length bhi ker skte hai Kykui graph li Length bhi V hai
         // 0 1 3 4 2 5 6 
         // ye vse hi Order m aaye hai jse Dry Run kerne per aaye the
    }
}