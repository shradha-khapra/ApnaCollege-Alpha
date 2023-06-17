

import java.util.*;
public class UnboundedKnapsack{
    //Time Complexity: O(n*W)
    //Tabulation
    public static int unboundedKnapsack(int val[],int wt[],int W){
        int n=val.length; //total items
        int dp[][]=new int[n+1][W+1];
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
                if(w<=j){  //valid //choice of Yes
                    // int inclProfit = v + dp[i][j-w];
                    // int exclProfit = dp[i-1][j];
                    dp[i][j]=Math.max(v + dp[i][j-w],dp[i-1][j]);
                }
                else{ //invalid  //choice of No
                    // int exclProfit = dp[i-1][j];
                    dp[i][j]=dp[i-1][j];
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
        System.out.println(unboundedKnapsack(val,wt,W)); //100
/**
0 0  0  0  0  0  0  0 
0 0  15 15 30 30 45 45
0 0  15 15 30 30 45 45
0 10 20 30 40 50 60 70 
0 10 20 45 55 65 90 100
0 10 20 45 55 65 90 100
 */
    }
}