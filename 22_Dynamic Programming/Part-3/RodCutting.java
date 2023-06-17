


    // Time Complexity: O(n*totRod)  
import java.util.*;
public class RodCutting{
    //Tabulation DP
    //wt => length , val => price , W => totRod
    public static int rodCutting(int lengths[],int price[],int totRod){
        int n=lengths.length; //price.length  (dono ak hi length dege)
        int dp[][]=new int[n+1][totRod+1];
        //initialization
        for(int i=0;i<n+1;i++){
            for(int j=0;j<totRod+1;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
    //ye sab krne k jarut to nhi kyuki JAVA m ye 0 by default hota hai
                }
            }
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<totRod+1;j++){
                int len=lengths[i-1];  //wt
                int pri=price[i-1]; //v
                if(len<=j){ //valid 
                    //include and exclude
                    dp[i][j]=Math.max(pri+dp[i][j-len],dp[i-1][j]);
                }
                else{  //exclude
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        print(dp);
        return dp[n][totRod];
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
        int lengths[]={1,2,3,4,5, 6, 7, 8}; //Length of Pieces
        int price[] = {1,5,8,9,10,17,17,20}; // price of pieces lengths
        int totRod=8;
        System.out.println(rodCutting(lengths,price,totRod));// 22
/**
0 0 0 0 0  0  0  0  0 
0 1 2 3 4  5  6  7  8
0 1 5 6 10 11 15 16 20
0 1 5 8 10 13 16 18 21
0 1 5 8 10 13 16 18 21 
0 1 5 8 10 13 16 18 21
0 1 5 8 10 13 17 18 22
0 1 5 8 10 13 17 18 22 
0 1 5 8 10 13 17 18 22 */
    }
}