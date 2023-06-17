
//Find Total Elements in Union and Intersection of 2 arrays

import java.util.*;
public class UnionIntersection{
    public static void main(String args[]){
        int arr1[]={7,3,9};
        int arr2[]={6,3,9,2,9,4};

        HashSet<Integer> union=new HashSet<>();
        for(int i=0;i<arr1.length;i++){
            union.add(arr1[i]);
        }
        for(int i=0;i<arr2.length ;i++){
            union.add(arr2[i]);
        }

        System.out.println("Total elements of Union:"+union.size());

        HashSet<Integer> intersection = new HashSet<>();
        for(int i=0;i<arr1.length;i++){
            intersection.add(arr1[i]);
        }
        int count=0;
        for(int i=0;i<arr2.length;i++){
            if(intersection.contains(arr2[i])){
                count++;
                intersection.remove(arr2[i]);
            }
        }

        System.out.println("Total elements of Intersection:"+count);

        //Total elements of Union:6
        //Total elements of Intersection:2

    }
}