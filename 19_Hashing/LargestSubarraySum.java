
// Largest Subarray with Sum 0    => // TC O(n)

import java.util.*;
public class LargestSubarraySum{
    public static void main(String args[]){  //O(n)
        int arr[]={15,-2,2,-8,1,7,10};
        HashMap<Integer,Integer> map = new HashMap<>();
        // < sum , index >
        int sum=0;
        int len=0;
        for(int j=0;j<arr.length;j++){
            sum+=arr[j];
            if(map.containsKey(sum)){
                len = Math.max( len, j-map.get(sum) );
            }
            else{
                map.put(sum,j);
            }
        }

        System.out.println("Largest Subarray With Sum as 0 => "+len);
        //op
        //Largest Subarray With Sum 0 => 5
    }
}