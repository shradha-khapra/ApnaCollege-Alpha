

import java.util.*;
public class KruskalsAlgo{
    static class Edge implements Comparable<Edge>{
        int src;
        int dest;
        int wt;

        public Edge(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
        @Override
        public int compareTo(Edge e2){
            return this.wt - e2.wt; //asending 
        }
    }

    public static void createGraph(ArrayList<Edge> edges){
        //edges
        edges.add(new Edge(0,1,10));
        edges.add(new Edge(0,2,15));
        edges.add(new Edge(0,3,30));
        edges.add(new Edge(1,3,40));
        edges.add(new Edge(2,3,50));
    }

    static int n=4; //Equal to Vertices(V)
    static int par[]=new int[n];
    static int rank[]=new int[n];

    //initialization
    public static void init(){
        for(int i=0;i<n;i++){
            par[i]=i; 
            rank[i]=0; 
        }
    }

    public static int find(int x){  //O(1)
        if(x==par[x]){
            return x;
        }
        return par[x]=find(par[x]);  //Path Compression
    }

    public static void union(int a,int b){  //O(1)
        int parA=find(a);
        int parB=find(b);
        
        if(rank[parA]==rank[parB]){
            par[parB]=parA;
            rank[parA]++;
        }else if(rank[parA]<rank[parB]){
            par[parA]=parB;
        }else{
            par[parB]=parA;
        }
    }

//Total Time Complexity:O(V + ElogE)
    public static void kruskalsAlgo(ArrayList<Edge> edges,int V){
        Collections.sort(edges);  //Time Complexity:O(ElogE)
        int mstCost=0; //answer
        int count=0;

        for(int i=0;count<V-1;i++){ //Time Complexity:O(V)
            Edge e=edges.get(i);
            //src,dest,wt
            int parA=find(e.src); // src = a
            int parB=find(e.dest);// dest = b
            if(parA!=parB){
                union(e.src,e.dest);
                mstCost+=e.wt;
                count++;
            }
        }
        System.out.println(mstCost);
    }

    public static void main(String args[]){
        init();
        int V=4;
        ArrayList<Edge> edges = new ArrayList<>();
        createGraph(edges); 
        kruskalsAlgo(edges,V);  //55
    }
}