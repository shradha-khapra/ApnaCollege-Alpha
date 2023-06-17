
//Query => O(logn)
import java.util.*;
public class Tut02{
    static int tree[];
    public static void init(int n){
        tree = new int[4*n]; //Size of Tree Array
    }

    public static int buildST(int arr[],int i,int start,int end){ //O(n)
        if(start == end){
            tree[i]=arr[start];
            return arr[start];
        }

        int mid = (start+end)/2;
        buildST(arr,2*i+1,start,mid); // left subtree - 2*i+1
        buildST(arr,2*i+2,mid+1,end);// right subtree -2*i+2
        tree[i] = tree[2*i+1] + tree[2*i+2];
        return tree[i];
    }

    public static int getSumUtil(int i,int si,int sj,int qi,int qj){ //O(logn)
        if(qj < si || qi > sj){ // Non-Overlapping
            return 0;
        }
        else if(si>=qi && sj<=qj){ // Complete Overlapping
            return tree[i];
        }
        else{  // Partial Overlapping
            int mid=(si+sj)/2;
            int left = getSumUtil(2*i+1,si,mid,qi,qj);
            int right = getSumUtil(2*i+2,mid+1,sj,qi,qj);
            return left+right;
        }
    }

    public static int getSum(int arr[],int qi,int qj){
        int n = arr.length;
        // si=0 ,sj=n-1  // Kyuki root node 0 se n-1 tak ka Sum rakta hai
        return getSumUtil(0,0,n-1,qi,qj);
    }

    public static void updateUtil(int i,int si,int sj,int idx,int diff){  //O(logn)
        if(idx<si || idx>sj){
            return;
        }
        tree[i]+=diff;
        if(si != sj){ //Utill not Non-Leaf
            int mid=(si+sj)/2;
            updateUtil(2*i+1,si,mid,idx,diff); //Left
            updateUtil(2*i+2,mid+1,sj,idx,diff); //Right
        }
    }
    public static void update(int arr[],int idx,int newVal){
        int n = arr.length;
        int diff = newVal-arr[idx];
        arr[idx]=newVal;

        updateUtil(0,0,n-1,idx,diff); //SegmentTree Updation
    }
    public static void main(String args[]){
        int arr[]={1,2,3,4,5,6,7,8};
        int n = arr.length;
        init(n);
        buildST(arr,0,0,n-1);
// 36 10 26 3 7 11 15 1 2 3 4 5 6 7 8 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 

        System.out.println(getSum(arr,0,3)); //10  //Query
        System.out.println(getSum(arr,2,5)); //18

        update(arr,2,2); // UPDATE
// 35 9 26 3 6 11 15 1 2 2 4 5 6 7 8 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 
        for(int i=0;i<tree.length;i++){
            System.out.print(tree[i]+" ");
        }
    }
}