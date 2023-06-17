


import java.util.*;
public class DisjointSet{
    static int n=7;
    static int par[]=new int[n];
    static int rank[]=new int[n];

    //initialization
    public static void init(){
        for(int i=0;i<n;i++){
            par[i]=i; //beginning m sab apne aap k hi parent hote hai
            rank[i]=0; //beginning m sab ka rank 0 hi hoga,kisi se koi connected nhi hai
        }
    }

    public static int find(int x){  //Time Complexity: O(4k) => constant O(1)
        if(x==par[x]){
            return x;
        }
        return par[x]=find(par[x]);  //Path Compression
    }

    public static void union(int a,int b){ //Time Complexity: O(4k) => constant O(1)
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

    
    public static void main(String args[]){
        init();
        System.out.println(find(3));  //3
        union(1,3);
        System.out.println(find(3));  //1
        union(2,4);
        union(3,6);
        union(1,4);
        System.out.println(find(3)); //1
        System.out.println(find(4)); //1
        union(1,5);
    }
}