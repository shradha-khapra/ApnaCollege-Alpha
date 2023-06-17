
// Max/Min Element 
//Min bnana hai is code ko to Math.Max ki jghe min ker dege or Integer.MIN_VALUE ko bhi Integer.MAX_VALUE ker dege
public class Tut03{
    static int tree[]; 
    public static void init(int n){
        tree = new int[4*n];
    }
    //TC=> O(n)
    public static void buildST(int arr[],int i,int start,int end){
        if(start==end){
            tree[i]=arr[start];
            return;
        }
        int mid=(start+end)/2; // mid = start + (end-start)/2
        buildST(arr,2*i+1,start,mid); //left
        buildST(arr,2*i+2,mid+1,end); //right
        tree[i]=Math.max(tree[2*i+1],tree[2*i+2]);
        // tree[i]=Math.min(tree[2*i+1],tree[2*i+2]); //Min Elements ST ban Jayega
    }
    
    //O(logn)
    public static int getMaxUtil(int i,int si,int sj,int qi,int qj){ 
        if(qj < si || qi > sj){ // Non-Overlapping
            return Integer.MIN_VALUE; //-Infinite 
            //We Used this Because it is less than every -ve number like -1,-10 etc.
        }
        else if(si>=qi && sj<=qj){ // Complete Overlapping
            return tree[i];
        }
        else{  // Partial Overlapping
            int mid=(si+sj)/2;
            int left = getMaxUtil(2*i+1,si,mid,qi,qj);
            int right = getMaxUtil(2*i+2,mid+1,sj,qi,qj);
            return Math.max(left,right);
        }
    }

    public static void updateUtil(int i,int si,int sj,int idx,int newVal){  //O(logn)
        if(idx < si || idx > sj){
            return;
        }
        if(si==sj){
            tree[i]=newVal;
        }
        if(si != sj){ //Utill not Non-Leaf
            tree[i]=Math.max(tree[i],newVal);
            int mid=(si+sj)/2;
            updateUtil(2*i+1,si,mid,idx,newVal); //Left
            updateUtil(2*i+2,mid+1,sj,idx,newVal); //Right
        }
    }
    public static void update(int arr[],int idx,int newVal){
        int n = arr.length;
        arr[idx]=newVal;

        updateUtil(0,0,n-1,idx,newVal); //SegmentTree Updation
    }

    public static int getMax(int arr[],int qi,int qj){
        int n = arr.length;
        return getMaxUtil(0,0,n-1,qi,qj);
    }


    

    public static void main(String args[]){

        int arr[]={6,8,-1,2,17,1,3,2,4};
        int n= arr.length;
        init(n);
        buildST(arr,0,0,n-1);
        for(int i=0;i<tree.length;i++){
            System.out.print(tree[i]+" ");
        }

        //Query
        System.out.println();
        System.out.println(getMax(arr,0,3));
        System.out.println(getMax(arr,5,8));
        System.out.println(getMax(arr,2,3));
        System.out.println(getMax(arr,0,2));
        System.out.println(getMax(arr,4,8));
        update(arr,2,20); // here 2 is Index

        for(int i=0;i<tree.length;i++){
            System.out.print(tree[i]+" ");
        }
                System.out.println();

            // -1
        // {6,8,20,2,17,1,3,2,4}
        System.out.println(getMax(arr,0,3));
        System.out.println(getMax(arr,5,8));
        System.out.println(getMax(arr,2,3));
        System.out.println(getMax(arr,0,2));
        System.out.println(getMax(arr,4,8));
    }
}

/**  //OUTPUT
17 17 4 8 17 3 4 8 -1 2 17 1 3 2 4 6 8 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 
8
4
2
8
17
20 20 4 20 17 3 4 8 20 2 17 1 3 2 4 6 8 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 
20
4
20
20
17
 */