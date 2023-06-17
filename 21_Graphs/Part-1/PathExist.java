

// Question HasPath : if path exist b/w src and dest than return true else false .
import java.util.*;
public class PathExist{
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
        }

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

public static boolean hasPath(ArrayList<Edge> graph[],int src,int dest,boolean visit[]){//O(V+E)
        if(src == dest){
            return true;
        }
        visit[src]=true;

        for(int i=0;i<graph[src].size();i++){
            Edge e = graph[src].get(i);
            //e.dest = neighbour(yani pdosi visit nhi kiya to kerlo)
            if(!visit[e.dest] && hasPath(graph,e.dest,dest,visit)){
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]){
             /*

            1 --- 3
           /      | \
          0       |  5 -- 6
           \      | /
            2 --- 4

         */

         int V =7;
         ArrayList<Edge> graph[] = new ArrayList[V];
         boolean visit[]=new boolean[V];
         createGraph(graph);
         System.out.print("Path Exist b/w Src And Dest : "+ hasPath(graph,0,5,visit));

         //src = 0 , dest = 5
         //Path Exist b/w Src And Dest : true
     
    }
}