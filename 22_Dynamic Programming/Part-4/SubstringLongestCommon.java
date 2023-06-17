


import java.util.*;
public class SubstringLongestCommon{
    //Tabulation Time complexity: O(n*m)
    public static int lcSubstring(String str1,String str2,int n,int m){
        int dp[][]=new int[n+1][m+1];

        //initialization
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
            }
        }

        //bottom up
        int ans=0;
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                //SAME
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                    ans=Math.max(ans,dp[i][j]);
                }
                else{ //DIFF
                    dp[i][j]=0;
                }
            }
        }
        print(dp);
        return ans;
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
        String str1="abcde";
        String str2="abgce";
        int n=str1.length();
        int m=str2.length();

        System.out.println(lcSubstring(str1,str2,n,m));  // 2
/**
0 0 0 0 0 0 
0 1 0 0 0 0
0 0 2 0 0 0
0 0 0 0 1 0
0 0 0 0 0 0 
0 0 0 0 0 1
 */
    }
}