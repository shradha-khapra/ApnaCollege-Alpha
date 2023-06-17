


import java.util.*;
public class MatrixChainMultiplication{
    public static int mcm(int arr[],int i,int j){
        if(i==j){ //Single Matrix Multiplication Vale case m
            return 0; 
        }
        int minCost=Integer.MAX_VALUE; //+infinty
        for(int k=i; k<=j-1; k++){
            int cost1 = mcm(arr,i,k); // set1 ke matrices multiplication ki COST
            int cost2 = mcm(arr,k+1,j);// set2 ke matrices multiplication ki COST
            //dono SETs(set1 or set2) ko multiple kerne ki cost
            int cost3 = arr[i-1] * arr[k] * arr[j]; // cost =  a*b*d
            int finalCost= cost1+cost2+cost3;
            minCost = Math.min(minCost,finalCost);
        }
        // System.out.println(minCost);
        return minCost;
    }

    //Memoization O(n^2)
    public static int mcmMemo(int arr[],int i,int j,int dp[][]){
        if(i==j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int ans = Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            int cost1 = mcmMemo(arr,i,k,dp);
            int cost2 = mcmMemo(arr,k+1,j,dp);
            int cost3 = arr[i-1] * arr[k] * arr[j];
            int finalCost = cost1+cost2+cost3;
            ans = Math.min(ans,finalCost);
        }
            return dp[i][j] = ans;
    }

    //tabulation
    public static int mcmTabo(int arr[]){
        int n = arr.length;
        int dp[][]=new int[n][n];

        //initialization
        for(int i=0;i<n;i++){
            dp[i][i]=0;  // Single matrix k liye
        }

        //bottom up
        for(int len=2;len<=n-1;len++){
            for(int i=1;i<=n-len;i++){
                int j= i+len-1; // col
                dp[i][j]=Integer.MAX_VALUE;
                for(int k=i;k<=j-1;k++){
                    int cost1 = dp[i][k];
                    int cost2 = dp[k+1][j];
                    int cost3 = arr[i-1] * arr[k] * arr[j];
                    int finalCost = cost1+cost2+cost3;
                    dp[i][j] = Math.min(dp[i][j],finalCost);
                }
            }
        }
        print(dp);
        return dp[1][n-1];
    }

      public static void print(int dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }


    public static void main(String args[]){
        int arr[]={1,2,3,4,3};
        int n = arr.length;
        System.out.println(mcm(arr,1,n-1)); // 30

        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1); // 1d arrays ko nikalte rhege,fir -1 dal dege
        }
        System.out.println(mcmMemo(arr,1,n-1,dp)); // 30
        print(dp);
/**
-1 -1 -1 -1 -1 
-1 -1 6 18 30
-1 -1 -1 24 48
-1 -1 -1 -1 36
-1 -1 -1 -1 -1
 */
        //tabulation
        System.out.println(mcmTabo(arr)); // 30
/**
0 0 0 0 0
0 0 6 18 30
0 0 0 24 48
0 0 0 0 36 
0 0 0 0 0
 */
    }
}