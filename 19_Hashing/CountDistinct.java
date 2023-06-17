
//count distinct element

import java.util.*;
public class CountDistinct{
    public static void main(String args[]){
        int arr[]={4,3,2,5,6,7,3,2,4,1};

        HashSet<Integer> set =new HashSet<>();
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }

        System.out.println("Total Distinct(Unique) Element:"+set.size()); // 7
    }
}