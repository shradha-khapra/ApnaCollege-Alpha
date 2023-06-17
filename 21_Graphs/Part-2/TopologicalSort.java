
//Topological Sorting (USING DFS)
import java.util.*;
public class TopologicalSort{
    static class Edge{
        int src;
        int dest;
        public Edge(int s,int d){
            this.src=s;
            this.dest=d;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,1));

        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));

        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,2));
    }

    //TIME COMPLEXITY: O(V+E)
    public static void topoSort(ArrayList<Edge> graph[]){
        boolean visit[]=new boolean[graph.length];
        Stack<Integer> s= new Stack<>();

        for(int i=0;i<graph.length;i++){
            if(!visit[i]){
                topoSortUtil(graph,i,visit,s);  //modified DFS
            }
        }

        while(!s.isEmpty()){
            System.out.print(s.pop()+" ");
        }
    }

public static void topoSortUtil(ArrayList<Edge> graph[],int curr,boolean visit[],Stack<Integer>s){
        visit[curr]=true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e= graph[curr].get(i);
            if(!visit[e.dest]){
                topoSortUtil(graph,e.dest,visit,s);
            }
        }
        s.push(curr);
}
    public static void main(String args[]){
        /*
        // DIRECTED ACYCLIC GRAPH (DAG)
         5 -------> 0 <--------- 4
         |                       |                  
         |                       |        
         |                       |                     ⬇
         ⬇                       ⬇
         2---------> 3 --------> 1                       

         */
         int V=6;
         ArrayList<Edge> graph[]=new ArrayList[V];
         createGraph(graph);
         topoSort(graph);
         //5 4 2 3 1 0 
    }
}