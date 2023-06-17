

import java.util.*;
public class EditDistance{
    //O(n*m)
    //tabulation
    public static int editDistance(String str1,String str2){
        int n=str1.length();
        int m=str2.length();
        int dp[][]=new int[n+1][m+1];
        //initialization
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0){  //ager str1 empty huii
                    dp[i][j]=j;
                }
                if(j==0){  //ager str2 empty huii
                    dp[i][j]=i;
                }
            }
        }

        //bottom up
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                //nth and mth char is same
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                else{
                    int add= dp[i][j-1] + 1;
                    int remove= dp[i-1][j] + 1;
                    int replace= dp[i-1][j-1] + 1;
                    dp[i][j]=Math.min(add,Math.min(remove,replace));
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
        String word1="intention";
        String word2="execution";
/**
0 1 2 3 4 5 6 7 8 9 
1 1 2 3 4 5 6 6 7 8 
2 2 2 3 4 5 6 7 7 7
3 3 3 3 4 5 5 6 7 8
4 3 4 3 4 5 6 6 7 8
5 4 4 4 4 5 6 7 7 7
6 5 5 5 5 5 5 6 7 8
7 6 6 6 6 6 6 5 6 7 
8 7 7 7 7 7 7 6 5 6
9 8 8 8 8 8 8 7 6 5
*/
        System.out.println(editDistance(word1,word2));  // 5

        System.out.println(editDistance("abc","sbd"));  // 2
/**
0 1 2 3
1 1 2 3
2 2 1 2 
3 3 2 2
 */
    }
}