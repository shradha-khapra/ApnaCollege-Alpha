

import java.util.*;
public class MinimumPartitioning{
    // O(n*W)
    public static int minPartitioning(int arr[]){
        int n = arr.length;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum += arr[i];  //Sum of all Elements
        }

        int W = sum/2;

        int dp[][]=new int[n+1][W+1];
        //init
        for(int i=0;i<dp.length;i++){
            dp[i][0]=0;     //0th col
            for(int j=0;j<dp[0].length;j++){
                dp[0][j]=0; //0th row
            }
        }

        //bottom up
        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                int v=arr[i-1];  //ith item val
                int w=arr[i-1];  // ith item wt
                if(w<=j){//valid
                    int inclProfit= v+dp[i-1][j-w];
                    int exclProfit= dp[i-1][j];
                    dp[i][j]=Math.max(inclProfit,exclProfit);
              }
              else{ // invalid
              int exclProfit=dp[i-1][j];
                dp[i][j]=exclProfit;
              }
            }
        }
        print(dp);
        int sum1 = dp[n][W];
        int sum2 = sum - sum1;
        return Math.abs(sum1 - sum2);
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
        int nums[] = {1, 6, 11, 5};
        System.out.println(minPartitioning(nums));// 1

        // ye 2D array bta rha hai max wt in Set1 Bag for W=SUM/2 At dp[n][W]
        //Yani 11 hi wt aa paya Set1 Bag m or bcha huaa jayega Set2 bag m
/**
0 0 0 0 0 0 0 0 0 0 0 0 
0 1 1 1 1 1 1 1 1 1 1 1
0 1 1 1 1 1 6 7 7 7 7 7 
0 1 1 1 1 1 6 7 7 7 7 11
0 1 1 1 1 5 6 7 7 7 7 11
 */
    }
}