
//Construct ST => O(n) // Bulid
//Query => O(logn)
//Update => O(logn)
import java.util.*;
public class Tut01{
    static int tree[];
    public static void init(int n){
        tree = new int[4*n]; //Size of Tree Array
    }

    public static int buildST(int arr[],int i,int start,int end){
        if(start == end){
            tree[i]=arr[start];
            return arr[start];
        }

        int mid = (start+end)/2;
        buildST(arr,2*i+1,start,mid); // left subtree - 2*i+1
        buildST(arr,2*i+2,mid+1,end);// right subtree -2*i+2
        tree[i] = tree[2*i+1] + tree[2*i+2];
        // tree[i]=left=right;
        return tree[i];
    }
    public static void main(String args[]){
        int arr[]={1,2,3,4,5,6,7,8};
        int n = arr.length;
        init(n);
        buildST(arr,0,0,n-1);

        for(int i=0;i<tree.length;i++){
            System.out.print(tree[i]+" ");
        }
    //36 10 26 3 7 11 15 1 2 3 4 5 6 7 8 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 
    }
}