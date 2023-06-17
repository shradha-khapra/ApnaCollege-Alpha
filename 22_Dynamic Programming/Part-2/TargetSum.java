


import java.util.*;
public class TargetSum{
    //Time Complexity: O(n*sum)
    //Tabulation
    public static boolean targetSumSubset(int arr[],int sum){
        int n=arr.length;
        boolean dp[][]=new boolean[n+1][sum+1];
        // i => items and j => target sum
        for(int i=0;i<n+1;i++){
            dp[i][0]=true;
            for(int j=1;j<sum+1;j++){
                dp[0][j]=false;  // java m to ye false kerne ki jarut nhi likin c++ m jarut hai 
                //java default false store kerta hai boolean m
            }
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                int v=arr[i-1];
               // include
               if(v<=j && dp[i-1][j-v]==true){
                    dp[i][j]=true;
               }
               //exclude
               else if(dp[i-1][j]==true){
                    dp[i][j]=true;
               }
            }
        }
        print(dp);
        System.out.println();
        return dp[n][sum];
    }

    public static void print(boolean dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+"  ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        int arr[]={4, 2, 7, 1, 3};
        int targetSum=10;
        System.out.println(targetSumSubset(arr,targetSum));  //true
/**
true  false  false  false  false  false  false  false  false  false  false  
true  false  false  false  true   false  false  false  false  false  false   
true  false  true   false  true   false  true   false  false  false  false     
true  false  true   false  true   false  true   true   false  true   false       
true  true   true   true   true   true   true   true   true   true   true  
true  true   true   true   true   true   true   true   true   true   true
 */ 
    } 
}