


import java.util.*;
public class MinimumJumps{
    public static int minJumps(int arr[]){
        int n = arr.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        //initialization
        dp[n-1]=0; // Reached At Destintion(arr[n-1])

        //bottom up
        for(int i=n-2;i>=0;i--){
            int ans=Integer.MAX_VALUE;
            int steps = arr[i];
            for(int j=i+1;j<=i+steps && j<n;j++){
                if(dp[j]!=-1){  // Way(jump) Exist from this idx
                    ans = Math.min(ans,dp[j]+1);
                }
            }
            if(ans != Integer.MAX_VALUE){
                dp[i]=ans;
            }
        }
        print(dp);
        return dp[0];
    }

    public static void print(int dp[]){
        for(int i=0;i<dp.length;i++){
            System.out.print(dp[i]+" ");
        }
        System.out.println();
    }
    public static void main(String args[]){
        int nums[]={2,3,1,1,4};
        System.out.println(minJumps(nums)); // 2
    }
}