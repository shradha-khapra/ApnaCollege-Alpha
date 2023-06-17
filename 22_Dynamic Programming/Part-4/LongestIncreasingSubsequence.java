

//Time Complexity of this questionn code: O(n*m)

import java.util.*;
public class LongestIncreasingSubsequence{

    //tabulation 
    public static int lcs(int arr[],int arr2[]){
        int n=arr.length;
        int m=arr2.length;
        int dp[][]=new int[n+1][m+1];

        //initialization
        for(int i=0;i<n+1;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<n+1;j++){
            dp[0][j]=0;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                //same
                if(arr[i-1]==arr2[j-1]){
                    dp[i][j]=dp[i-1][j-1] + 1;
                }
                else{ //diff
                    int ans1=dp[i-1][j];
                    int ans2=dp[i][j-1];
                    dp[i][j]=Math.max(ans1,ans2);
                }
            }
        }
        print(dp);
        return dp[n][m];
    }

    //LongestIncreasingSubsequence
    public static int lic(int arr[]){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }

        int arr2[]=new int[set.size()]; //sorted unique elements
        int i=0;
        for(int num : set){
            arr2[i]=num;
            i++;
        }

        Arrays.sort(arr2); //sorting in ascending
        return lcs(arr,arr2);

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
        int arr[]={50,3,10,7,40,80};
        System.out.println(lic(arr));  // 4

/**
0 0 0 0 0 0 0 
0 0 0 0 0 1 1
0 1 1 1 1 1 1
0 1 1 2 2 2 2
0 1 2 2 2 2 2
0 1 2 2 3 3 3 
0 1 2 2 3 3 4
 */
    }
}