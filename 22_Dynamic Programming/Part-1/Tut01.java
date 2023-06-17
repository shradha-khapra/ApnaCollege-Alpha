


import java.util.*;
public class Tut01{
    public static int fib(int n){
        if(n==0 || n==1){
            return n;
        }
        return fib(n-1)+fib(n-2);
    }

    public static int fibMemoization(int n,int dp[]){
        if(n==0 || n==1){
            return n;
        }
        if(dp[n]!=0){  //already store hai ho gya hai us n value k liye
        // fib(n) is already calculated. video time=> 12:00
            return dp[n];
        }
        dp[n]=fibMemoization(n-1,dp)+fibMemoization(n-2,dp);
        return dp[n];
    }

    public static int fibTabulation(int n){
        int dp[]=new int[n+1];
        //Initialization
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n]; //answer
    }
    public static void main(String args[]){
        int n=6;
        System.out.println(fib(n));  //  TC => O(2^n) Exponentiation

        int dp[]=new int[n+1];
        System.out.println(fibMemoization(n,dp));  //  TC => O(n) linear

        System.out.println(fibTabulation(n));  //  TC => O(n) linear

    }
}