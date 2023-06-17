


import java.util.*;
public class BellmanFord{

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
    }

    public static void bellmanFord(ArrayList<Edge> graph[],int src){
        int dist[]=new int[graph.length]; 
        
        for(int i=0;i<dist.length;i++){
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }
         dist[src] = 0; //src se src tak ka distance to 0 hi hota hai
        int V=graph.length;


        // TOTAL time complexity: O(V*E) ✅
        // algo - O(V)
        for(int i=0;i<V-1;i++){
            //edges -  O(E)
            for(int j=0;j<graph.length;j++){
                for(int k=0;k<graph[j].size();k++){
                    Edge e=graph[j].get(k);
                    // u, v, wt
                    int u=e.src;
                    int v=e.dest;
                    int wt=e.wt;
                    //relaxation step
                    if(dist[u] != Integer.MAX_VALUE && dist[u]+wt < dist[v]){
                        dist[v]=dist[u]+wt;
                    }
                }
            }
        }

        //Print
            int node=0;
        for(int i=0;i<dist.length;i++){
                System.out.println("DISTANCE from Src to "+node+": "+dist[i]+" ");
                node++;
        }
    }

    //SECOND METHOD
        //edges
    public static void createGraph2(ArrayList<Edge> graph){

        graph.add(new Edge(0,1,2));
        graph.add(new Edge(0,2,4));

        graph.add(new Edge(1,2,-4));

        graph.add(new Edge(2,3,2));

        graph.add(new Edge(3,4,4));

        graph.add(new Edge(4,1,-1));
    }
    

    public static void bellmanFord2(ArrayList<Edge> graph,int src,int V){
        int dist[]=new int[V]; 
        
        for(int i=0;i<dist.length;i++){
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }
         dist[src] = 0; //src se src tak ka distance to 0 hi hota hai

        // TOTAL time complexity: O(V*E) ✅
        // algo - O(V)
        for(int i=0;i<V-1;i++){
            //edges -  O(E)
            for(int j=0;j<graph.size();j++){
                    Edge e=graph.get(j);
                    // u, v, wt
                    int u=e.src;
                    int v=e.dest;
                    int wt=e.wt;
                    //relaxation step
                    if(dist[u] != Integer.MAX_VALUE && dist[u]+wt < dist[v]){
                        dist[v]=dist[u]+wt;
                    }
                }
        }
        //Print
            int node=0;
        for(int i=0;i<dist.length;i++){
                System.out.println("DISTANCE from Src to "+node+": "+dist[i]+" ");
                node++;
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

         int V = 5;
        //  ArrayList<Edge> graph[]=new ArrayList[V];
        //  createGraph(graph);
        //  bellmanFord(graph,0);

        // Here Src is 0
        //DISTANCE from Src to 0: 0 
        //DISTANCE from Src to 1: 2 
        //DISTANCE from Src to 2: -2
        //DISTANCE from Src to 3: 0
        //DISTANCE from Src to 4: 4

        ArrayList<Edge> graph=new ArrayList<>();
        createGraph2(graph);
        bellmanFord2(graph,0,V);
        //DISTANCE from Src to 0: 0 
        //DISTANCE from Src to 1: 2 
        //DISTANCE from Src to 2: -2
        //DISTANCE from Src to 3: 0
        //DISTANCE from Src to 4: 4
    }
}