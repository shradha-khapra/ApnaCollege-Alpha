

import java.util.*;
public class FloodFill{

    //Time Complexity: O(m*n)   m=image.length ,n =image[0].length
 public static void helper(int[][] image,int sr,int sc,int color,boolean vis[][],int OrgColor){

        if(sr<0 || sc<0 || sr>=image.length || sc>=image[0].length
         || vis[sr][sc]  || image[sr][sc]!= OrgColor){
            return;
         }
         image[sr][sc]=color;
        //left
        helper(image,sr,sc-1,color,vis,OrgColor);
        //right
        helper(image,sr,sc+1,color,vis,OrgColor);
        //up
        helper(image,sr-1,sc,color,vis,OrgColor);
        //down
        helper(image,sr+1,sc,color,vis,OrgColor);
    }
    public static int[][] floodFill(int[][] image,int sr,int sc,int color){
        boolean vis[][]=new boolean[image.length][image[0].length];
        helper(image, sr, sc, color, vis, image[sr][sc]);
        return image;
    }

    public static void print2D(int image[][]){
        for(int row[]:image){ //way to print 2D array
            System.out.println(Arrays.toString(row));
        }
        // System.out.println(Arrays.deepToString(image)); //way to print 2D array
    }
    public static void main(String args[]){
        int[][] image =  {{1,1,1},
                          {1,1,0},
                          {1,0,1}};
        
        int sr=1,sc=1,color=2;
        floodFill(image,sr,sc,color);
        print2D(image);
        // [2, 2, 2]
        // [2, 2, 0]
        // [2, 0, 1]
    }
}