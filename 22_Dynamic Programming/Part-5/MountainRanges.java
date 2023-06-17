


import java.util.*;
public class MountainRanges{
      //tabulation  O(n*n) => O(n^2)
    public static int mountainRanges(int n){
        int dp[]=new int[n+1];
        //init
        dp[0]=1;
        dp[1]=1;

        //fill
        for(int i=2;i<=n;i++){
            //  (i pairs) => mountainrange => Ci
            for(int j=0;j<i;j++){
                // dp[i]+= dp[j] * dp[i-j-1]; // Ci = Ci * Ci-j-1
                int inside = dp[j];
                int outside = dp[i-j-1];
                dp[i]+= inside * outside; // Ci = Ci * Ci-j-1
            }
        }
        // n pairs
        return dp[n];
    }
    public static void main(String args[]){
        int n=4;
        System.out.println(mountainRanges(n)); //14
    }
}