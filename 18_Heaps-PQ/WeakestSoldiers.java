
/*
You are given an m x n binary matrix mat of 1's (representing soldiers) and 0's (representing civilians). The soldiers are positioned in front of the civilians. That is, all the 1's will appear to the left of all the 0's in each row.

A row i is weaker than a row j if one of the following is true:

The number of soldiers in row i is less than the number of soldiers in row j.
Both rows have the same number of soldiers and i < j.
Return the indices of the k weakest rows in the matrix ordered from weakest to strongest.
 */


import java.util.*;
public class WeakestSoldiers{

    static class Row implements Comparable<Row>{
        int soldiers;
        int idx;

        public Row(int soldiers,int idx){
            this.soldiers=soldiers;
            this.idx=idx;
        }

        @Override
        public int compareTo(Row r2){
            if(this.soldiers==r2.soldiers){
                return this.idx - r2.idx;
            }
            return this.soldiers-r2.soldiers;
        }
    }
    public static void main(String args[]){
        int army[][]={
            {1,0,0,0},
            {1,1,1,1},
            {1,0,0,0},
            {1,0,0,0}
        };

        int k=2;

        PriorityQueue<Row> pq= new PriorityQueue<>();

        for(int i=0;i<army.length;i++){
            int count=0;
            for(int j=0;j<army[0].length;j++){
                if(army[i][j]==1){
                    count+=1;
                }
            }
            pq.add(new Row(count,i));
        }

        System.out.println("Weakest Soilders Row:");

        for(int i=0;i<k;i++){
            System.out.print("R"+pq.remove().idx+"\n");
        }

        // Weakest Soilders Row:
        // R0
        // R2
    }
}