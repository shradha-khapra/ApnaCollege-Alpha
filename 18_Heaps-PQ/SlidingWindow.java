

//Revision of This Code at 22:10 in video
import java.util.*;
public class SlidingWindow{

    static class Pair implements Comparable<Pair>{
        int val;
        int idx;
        public Pair(int val,int idx){
            this.val=val;
            this.idx=idx;
        }

        @Override
        public int compareTo(Pair p2){
            // return this.val-p2.val; //asending order
            return p2.val-this.val;  //decending order
        }
    }
    public static void main(String args[]){
        // int arr[]={1,2,3,4,5,6,7,8,9,10};
        int arr[]={1,3,-1,-3,5,3,6,7}; // ans=> 3 3 5 5 6 7 
        int k=3; //Window size
        int res[]=new int[arr.length-k+1]; //n-k+1
//ager array ka size n hai to uske ander n-k+1 windows hi Exist ker sktii hai
        PriorityQueue<Pair> pq= new PriorityQueue<>();

        //1st Window
        for(int i=0;i<k;i++){
            pq.add(new Pair(arr[i],i));
        }

        res[0]=pq.peek().val;

        for(int i=k;i<arr.length;i++){
            while(/*pq.size() > 0 &&*/ pq.peek().idx <= (i-k)){ //(i-k) is curr val idx of arr 
//yani vo meri currwindow se phle aata hai,ab vali window m exist nhi kerta element isliye remove
                pq.remove();
            }
            
            pq.add(new Pair(arr[i],i));
            res[i-k+1]=pq.peek().val;
        }

        //print result
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }

        // O/P
        //3 4 5 6 7 8 9 10 
    }
}