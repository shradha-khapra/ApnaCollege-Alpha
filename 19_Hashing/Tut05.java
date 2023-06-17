/*
LinkedHashSet:
[8, 7, 55, 80, 47]
TreeSet:
[7, 8, 47, 55, 80]
HashSet:
[80, 7, 55, 8, 47]
 */

import java.util.*;
public class Tut05{
    public static void main(String args[]){
        //create
        System.out.println("LinkedHashSet:");
        LinkedHashSet<Integer> lhs=new LinkedHashSet<>();

        lhs.add(8);
        lhs.add(7);
        lhs.add(55);
        lhs.add(80);
        lhs.add(47);
    System.out.println(lhs); //[8, 7, 55, 80, 47]  Order Inseration(jis order m dala usmi m aaya)

        System.out.println("TreeSet:");
        TreeSet<Integer> ts=new TreeSet<>();

        ts.add(8);
        ts.add(7);
        ts.add(55);
        ts.add(80);
        ts.add(47);
        System.out.println(ts); //[7, 8, 47, 55, 80]  Sorted in ascending by default

        System.out.println("HashSet:");
        HashSet<Integer> hs=new HashSet<>();

        hs.add(8);
        hs.add(7);
        hs.add(55);
        hs.add(80);
        hs.add(47);
        System.out.println(hs); //[80, 7, 55, 8, 47]  Unordered

     
    }
}