


import java.util.*;
public class WildcardMatching{
    // time complexity: O(n*m)
    public static boolean isMatch(String s,String p){
        int n = s.length();
        int m = p.length();
        boolean dp[][]=new boolean[n+1][m+1];
        //initialization
        dp[0][0]=true;   // s=" "  p=" "

        //Pattern is empty
        for(int i=1;i<n+1;i++){
            dp[i][0]=false; // p=" "
        }
        //Given s is empty
        for(int j=1;j<m+1;j++){
            if(p.charAt(j-1)=='*'){
                dp[0][j]=dp[0][j-1];
            }
        //bakki case ko false kerne ki jarut nhi kyuki JAVA m by default false hota hai boolean type,Ager c++ m ker rhe hote ye code to false vale case nhi kerne the
       /* else{
            dp[0][j]=false;  // if charAt() ye '?' ya fir koi char(a,b...etc.) aa gya to
        }*/
        }
        
        //Bottom Up
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }
                else if(p.charAt(j-1)=='*'){
                            // ignore    // match kerva diya
                    dp[i][j]=dp[i][j-1] || dp[i-1][j];
                }
                else{
                    dp[i][j]=false;  //ex. s="ab"  p="cd"
                }
            }
        }
        print(dp);
        return dp[n][m];
    }
    public static void print(boolean dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        String s = "baaabab"; //Given String
        String p = "**b*****ab"; //Pattern
        System.out.println(isMatch(s,p)); //true
/**
true  true true false false false false false false false false 
false true true true  true  true  true  true  true  false false
false true true false true  true  true  true  true  true  false
false true true false true  true  true  true  true  true  false
false true true false true  true  true  true  true  true  false
false true true true  true  true  true  true  true  false true
false true true false true  true  true  true  true  true  false 
false true true true  true  true  true  true  true  false true
 */

        System.out.println(isMatch("abc","**d")); // false
/**
true true true false
false true true false
false true true false
false true true false
 */

    }
}