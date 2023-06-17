


import java.util.*;
public class CatalanNumber{
    public static int catalanRecur(int n){
        if(n==0 || n==1){
            return 1;
        }
        int ans=0; // Cn
        for(int i=0;i<n;i++){
            ans+= catalanRecur(i) * catalanRecur(n-i-1);
        }
        return ans;
    }

    //Memoization
    public static int catalanMemo(int n,int dp[]){
        if(n==0 || n==1){
            return 1;
        }
        int ans=0; // Cn

        if(dp[n]!=-1){
            return dp[n];
        }
        for(int i=0;i<n;i++){
            ans+= catalanMemo(i,dp) * catalanMemo(n-i-1,dp); 
        }
        dp[n]=ans;
        return dp[n];
    }

    //tabulation  O(n*n) => O(n^2)
    public static int catalanTabu(int n){
        int dp[]=new int[n+1];
        //initialization
        dp[0]=1;
        dp[1]=1;

        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                dp[i]+= dp[j] * dp[i-j-1]; // Ci = Ci * Ci-j-1
            }
        }
        return dp[n];
    }
    public static void main(String args[]){
        int n = 4;
        System.out.println(catalanRecur(n)); // 14

        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(catalanMemo(n,dp)); // 14
        for(int i=0;i<n+1;i++){
            System.out.print(dp[i]+" "); // -1 -1 2 5 14 
        }

            System.out.println();
            System.out.print(catalanTabu(n)); // 14 
    }
}