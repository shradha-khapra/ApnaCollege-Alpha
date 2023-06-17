


import java.util.*;
public class ClimbingStairs{
    public static int ways(int n){
           if(n==0){
            return 1;
        }
           if(n<0){
            return 0;
        }
        return ways(n-1)+ways(n-2);
    }

    public static int waysMemoization(int n,int dp[]){
        if(n==0){
            return 1;
        }
           if(n<0){
            return 0;
        }

        if(dp[n] != -1){ // already calculated.
            return dp[n];
        }
        dp[n]=waysMemoization(n-1,dp)+waysMemoization(n-2,dp);
        return dp[n];
    }

    public static int waysTabulation(int n){
        int dp[]=new int[n+1];
        dp[0]=1;

        for(int i=1;i<=n;i++){
            if(i==1){
                dp[i]=dp[i-1]+0;  //dp[1]=1
            }else{
                dp[i]=dp[i-1]+dp[i-2];
            }
        }
        return dp[n];
    }

    public static void main(String args[]){
        int n=5;
        System.out.println(ways(n));
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);  //Not Necessary.  dp[n] != 0 se bhi ker skte hai
        System.out.println(waysMemoization(n,dp));
        System.out.println(waysTabulation(n));
    }
}