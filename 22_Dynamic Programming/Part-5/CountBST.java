

//SAME AS CATALAN'S NUMBER PROBLEM
import java.util.*;
public class CountBST{
     //tabulation  O(n*n) => O(n^2)
    public static int countTrees(int n){
        int dp[]=new int[n+1];
        //init
        dp[0]=1;
        dp[1]=1;

        //fill
        for(int i=2;i<=n;i++){
            // Ci => BST(i nodes) => dp[i]
            for(int j=0;j<i;j++){
                dp[i]+= dp[j] * dp[i-j-1]; // Ci = Ci * Ci-j-1
        // Left tree nodes kse arrange ho rhe hai ye bta rha hai dp[j]
        // Right tree nodes kse arrange ho rha hai ye bta rha hai dp[i-j-1]
            }
        }
        return dp[n];
    }
    public static void main(String args[]){
        int n=3;
        System.out.println(countTrees(n)); // 5
    }
}