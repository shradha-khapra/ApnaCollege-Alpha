
// 0-1 knapsack

import java.util.*;
public class Knapsack01{
    //Recursion O(2^n)
    public static int knapsack(int val[],int wt[],int W,int n){ // n = items
        if(W==0 || n==0){
            return 0;
        }

        if(wt[n-1] <= W){ //Valid 
            //include
            int ans1= val[n-1]+knapsack(val,wt,W-wt[n-1],n-1);
            //exclude
            int ans2= knapsack(val,wt,W,n-1);
            return Math.max(ans1,ans2);
        }
        else{//Not Valid
            return knapsack(val,wt,W,n-1);
        }
    }

    //Memoization => O(n*W)
    public static int knapsackMemo(int val[],int wt[],int W,int n,int dp[][]){ // n = items
        if(W==0 || n==0){
            return 0;
        }
        if(dp[n][W] != -1){// Already calculated.
            return dp[n][W];
        }
        if(wt[n-1] <= W){ //Valid 
            //include
            int ans1= val[n-1]+knapsackMemo(val,wt,W-wt[n-1],n-1,dp);
            //exclude
            int ans2= knapsackMemo(val,wt,W,n-1,dp);
            dp[n][W]= Math.max(ans1,ans2);
            return dp[n][W];
        }
        else{//Not Valid
            dp[n][W]= knapsackMemo(val,wt,W,n-1,dp);
            return dp[n][W];
        }
    }

    public static int knapsackTabu(int val[],int wt[],int W){
        int n=val.length; //total items
        int dp[][]=new int[n+1][W+1];
        //init
        for(int i=0;i<dp.length;i++){
            dp[i][0]=0;     //0th col
            for(int j=0;j<dp[0].length;j++){
                dp[0][j]=0; //0th row
            }
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                int v=val[i-1];  //ith item val
                int w=wt[i-1];  // ith item wt
                if(w<=j){  //valid
                    int inclProfit = v + dp[i-1][j-w];
                    int exclProfit = dp[i-1][j];
                    dp[i][j]=Math.max(inclProfit,exclProfit);
                }
                else{ //invalid
                    int exclProfit = dp[i-1][j];
                    dp[i][j]=exclProfit;
                }

            }
        }
        print(dp);
        return dp[n][W];
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
        int val[]={15,14,10,45,30};
        int wt[]={2,5,1,3,4};
        int W=7;
        System.out.println(knapsack(val,wt,W,val.length)); //75

        //Memoization
        int dp[][]=new int[val.length+1][W+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]= -1;
            }
        }

        System.out.println(knapsackMemo(val,wt,W,val.length,dp)); //75
        System.out.println(knapsackTabu(val,wt,W)); //75
/**
0 0  0  0  0  0  0  0 
0 0  15 15 15 15 15 15 
0 0  15 15 15 15 15 29 
0 10 15 25 25 25 25 29
0 10 15 45 55 60 70 70 
0 10 15 45 55 60 70 75
 */
    }
}
