


import java.util.*;
public class StringConversion{
    //Time complexity: O(n*m)
    public static int lcs(String str1,String str2){
        int n = str1.length();
        int m = str2.length();
        int dp[][]=new int[n+1][m+1];
        //initialization
        for(int i=0;i<n+1;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<m+1;j++){
                dp[0][j]=0;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                //same
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1] + 1;
                }
                else{ //diff
                    int ans1=dp[i-1][j];
                    int ans2=dp[i][j-1];
                    dp[i][j]=Math.max(ans1,ans2);
                }
            }
        }
        return dp[n][m];
    }
    public static int strConversion(String str1,String str2){
        int n = str1.length();
        int m = str2.length();
        int lcsAns = lcs(str1,str2);

        System.out.println("Total delete Operation Used: "+ (n-lcsAns));
        System.out.println("Total add Operation Used: "+ (m-lcsAns));

        return (n-lcsAns+m-lcsAns);
    }
    public static void main(String args[]){
        String str1="pear";
        String str2="sea";
        System.out.println("Total Operations Used: "+strConversion(str1,str2));

        // Total delete Operation Used: 2
        // Total add Operation Used: 1
        // Total Operations Used: 3
    }
}