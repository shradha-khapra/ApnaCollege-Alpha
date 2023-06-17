


import java.util.*;
public class LongestCommonSubsequence{
    //Recursion  O(2^n)
    public static int lcs(String str1,String str2,int n,int m){
        if(n==0 || m==0){  //base case
            return 0;
        }
        //SAME
        if(str1.charAt(n-1) == str2.charAt(m-1)){
            return lcs(str1,str2,n-1,m-1) + 1;
        }
        else{ //DIFF
            int ans1=lcs(str1,str2,n-1,m);
            int ans2=lcs(str1,str2,n,m-1);
            return Math.max(ans1,ans2);
        }
    }

    //Memoization O(n*m)
    public static int lcsMemo(String str1,String str2,int n,int m,int dp[][]){
        if(n==0 || m==0){  //base case
            return 0;
        }

        if(dp[n][m]!=0){ //already calculated.
            return dp[n][m];
        }
         //SAME
        if(str1.charAt(n-1) == str2.charAt(m-1)){
            dp[n][m] = lcsMemo(str1,str2,n-1,m-1,dp) + 1;
            return dp[n][m];
        }
        else{ //DIFF
            int ans1=lcsMemo(str1,str2,n-1,m,dp);
            int ans2=lcsMemo(str1,str2,n,m-1,dp);
            dp[n][m] = Math.max(ans1,ans2);
            return dp[n][m];
        }
    }

    //Tabulation O(n*m)
    public static int lcsTabu(String str1,String str2,int n,int m){
        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;   //Base Case
                }
            }
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1] + 1;  //same char of str1 and str2
                }
                else{  //diff
                    int ans1=dp[i-1][j];
                    int ans2=dp[i][j-1];
                    dp[i][j]=Math.max(ans1,ans2);
                }
            }
        }
        print(dp);
        return dp[n][m];
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
        String str1="abcdge";
        String str2="abedg"; //lcs = "abdg" => length=4
        int n=str1.length();
        int m=str2.length();
        int dp[][]=new int[n+1][m+1];
       
        System.out.println(lcs(str1,str2,n,m));  // 4

        System.out.println(lcsMemo(str1,str2,n,m,dp));  // 4
        print(dp);
/**
0 0 0 0 0 0 
0 1 1 1 0 0
0 1 2 2 0 0
0 1 2 2 0 0
0 1 2 2 3 0
0 1 2 2 3 4 
0 0 0 3 3 4
 */
        System.out.println();  // 4
        System.out.println(lcsTabu(str1,str2,n,m));  // 4
/**
0 0 0 0 0 0
0 1 1 1 1 1
0 1 2 2 2 2
0 1 2 2 2 2
0 1 2 2 3 3 
0 1 2 2 3 4
0 1 2 3 3 4
 */
    }
}