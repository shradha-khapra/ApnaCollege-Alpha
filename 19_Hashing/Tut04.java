

import java.util.*;
public class Tut04{
    public static void main(String args[]){
        //create
        HashSet<Integer> hs=new HashSet<>();

        hs.add(8);
        hs.add(7);
        hs.add(55);
        hs.add(80);
        hs.add(47);
        System.out.println(hs); //[80, 7, 55, 8, 47]  Unordered

        if(hs.contains(7)){
            System.out.println("Yes conatins");
        }

        System.out.println("Removed element:"+hs.remove(80));//T  //Here remove() returns T or F
        System.out.println(hs); //[7, 55, 8, 47]

        System.out.println("Size of HashSet:"+hs.size()); // Size: 4  => [7, 55, 8, 47]
        hs.clear(); //HashSet cleared
        System.out.println("HashSet empty or not:"+hs.isEmpty()); //true



        //Iteration
        //(1) Using Iterators
        //(2) Using Enhanced for loop

        HashSet<String> cities = new HashSet<>();
        cities.add("Paris");
        cities.add("Delhi");
        cities.add("London");
        cities.add("Slicon-Vally");

        //(1)
         Iterator it = cities.iterator();  //Iterator is in-bulid class like Scanner
        while(it.hasNext()){
            System.out.println(it.next());
        }        
        //o/p  Unordered
        //Delhi
        //London
        //Paris
        //Slicon-Vally
        
        //(2)
        for(String key:cities){       //Syntax: for(key_type name : HashSet_name){    }
            System.out.println(key);
        }
        //o/p  Unordered
        //Delhi
        //London
        //Paris
        //Slicon-Vally
    }
}