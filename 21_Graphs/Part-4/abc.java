
//BELLMAN FORD Pratice

import java.util.*;
// import java.util.ArrayList;
public class abc{

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
    //edges
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }

        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));

        graph[1].add(new Edge(1,2,-4));

        graph[2].add(new Edge(2,3,2));

        graph[3].add(new Edge(3,4,4));

        graph[4].add(new Edge(4,1,-1));

        graph[5].add(new Edge(5,6,1));  // src se is node tak ka shortest dist nhi likal skte kukii src se yha tak aane ka path hi nhi hai ye to ak type se diconnected hai or yha tak ka distance to infinity hi hoga
    }
//DISTANCE FROM SRC:
//0 2 -2 0 4 2147483647

    public static void bellmanFord(ArrayList<Edge> graph[],int src){
        int dist[]=new int[graph.length]; 
        
        for(int i=0;i<dist.length;i++){
            if(i != src){
                dist[i]=Integer.MAX_VALUE;
            }
        }
         dist[src] = 0;
         System.out.println(dist[2]+ 1+" *****");
        //  System.out.println(dist[0]+" *****");
        //  System.out.println(dist[0]+5+" *****");

        int V=graph.length;
        // algo - O(V)
        // for(int i=0;i<graph.length-1;i++){
            //edges -  O(E)
           for(int j=0;j<graph.length;j++){
                for(int k=0;k<graph[j].size();k++){
                    Edge e=graph[j].get(k);
                    // u, v, wt
                    int u=e.src;
                    int v=e.dest;
                    int wt=e.wt; 
                    // System.out.println(u+" *****");
                    //relaxation step
                    // if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]){
                    //     dist[v]=dist[u]+wt;
                    //                 // System.out.println(dist[u]+" *****");
                    //                 System.out.println(dist[v]+" *****");
                    //                 // System.out.println(wt+" *****");

                    // }
                }
            // }
        } 
        // for (int i = 0; i < V; ++i) {
        //     for (int j = 0; j < graph[i].size(); ++j) {
        //         Edge e=graph[i].get(j);
        //             // u, v, wt
        //             int u=e.src;
        //             int v=e.dest;
        //             int wt=e.wt; 
        //         // int u = Edge[j].src;
        //         // int v = Edge[j].dest;
        //         // int weight = Edge[j].wt;
        //         if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v])
        //             dist[v] = dist[u] + wt;
        //     }
        // }

        //Print
        for(int i=0;i<dist.length;i++){
            System.out.print(dist[i]+" ");
        }
    }
    public static void main(String args[]){
        /*
              1 <------------\
            ↗ |               \ (-1)
      (2)  /  |                \
          /   |                 \
         /    | (-4)             \
        0     |                   4
         \    |                  ↗
      (4) \   |                 / (4)
           \  V                /
            ↘ 2 -----------> 3
                    (2)
         */         

         int V = 6;
         ArrayList<Edge> graph[]=new ArrayList[V];
         createGraph(graph);
         bellmanFord(graph,0);

         //DISTANCE FROM SRC:
        //0 2 -2 0 4 2147483647
    }
}