
//Subarray sum equal to K

import java.util.*;
public class SubarraySumK{
    public static void main(String args[]){
        int arr[]={10, 2, -2, -20, 10};
        int k= -10;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        // (sum, count)
        map.put(0,1);  // default put kiya h ye kyuki ager arr[] m K ki value aa gyi to sum 0 hogaa isliye us subarray ko count kerne k liye 

        int sum = 0;
        int ans = 0;

        for(int j=0; j<arr.length; j++){
            sum+= arr[j]; //sum(j)
            if(map.containsKey(sum-k)){
                ans += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum,0) + 1);
        }

        System.out.println(ans);  // 3
    }
}