
//Cycle Dectection In Directed Graph

import java.util.*;
public class CycleDetection1{
    static class Edge{
        int src;
        int dest;  //wt diya nhi to likha nhi likh bhi skte the by default 1
        public Edge(int s,int d){
            this.src=s;
            this.dest=d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0,2));
        graph[1].add(new Edge(1,0));
        graph[2].add(new Edge(2,3));
        graph[3].add(new Edge(3,0));
    }

    //TIME COMPLEXITY: O(V+E)
    public static boolean isCycle(ArrayList<Edge> graph[]){
        boolean visit[]=new boolean[graph.length];
        boolean stack[]=new boolean[graph.length];

        for(int i=0;i<graph.length;i++){
            if(!visit[i]){
                if(isCycleUtil(graph,i,visit,stack)){
                    return true;
                }
            }
        }
        return false;
    }

public static boolean isCycleUtil(ArrayList<Edge>graph[],int curr,boolean visit[],boolean stack[]){
        visit[curr]=true;
        stack[curr]=true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(stack[e.dest]){ //cycle
                return true;
            }
            else if(!visit[e.dest] && isCycleUtil(graph,e.dest,visit,stack)){
                return true;
            }
        }
        stack[curr]=false;
        return false;
    }
    public static void main(String args[]){
        /*
        //DIRECTED GRAPH
         1 ---------> 0
                      | ↖
                      |  \
                      |   \ 
                      |    3
                      |   ↗
                      |  /
                      ⬇ /
                      2
         */
        int V=4;
        ArrayList<Edge> graph[]=new ArrayList[V];
        createGraph(graph);
        System.out.println(isCycle(graph)); //true
    }
}