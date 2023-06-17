
//Operations of HashMap

import java.util.*;
public class Tut01{
    public static void main(String args[]){
        //Create
        // HashMap< KeyType, ValType > name= new HashMap<>();
        HashMap< String, Integer > hm= new HashMap<>();

        //Insert - O(1)
    //  name.put(key,val);
        hm.put("India",150);
        hm.put("China",150);
        hm.put("US",50);
        hm.put("India",200);

        System.out.println(hm);

        //Get - O(1)
    //  name.get(key);
        int popul=hm.get("India");
        System.out.println(popul);
        System.out.println(hm.get("Pakistan")); //not exist in HashMap

        //Remove -  O(1)
    //  name.remove(key);
        System.out.println(  hm.remove("China")  );
        System.out.println(  hm.remove("Pakistan")  ); //not exits in HashMap

        //containsKey() - O(1)
        System.out.println( hm.containsKey("India") );
        System.out.println( hm.containsKey("UK") );

        //Size Of HashMap - O(n)
        System.out.println("Size Of HashMap: "+  hm.size());

        //Clear - O(n)
        hm.clear();

        //isEmpty() - O(1)
        System.out.println( hm.isEmpty() );

        /* //Output

        {China=150, US=50, India=200}
        200
        null
        150
        null
        true
        false
        Size Of HashMap: 2
        true

         */

         
         HashMap<String,Integer> hm1= new  HashMap<>();
         hm1.put("India",150);
         hm1.put("Aus",100);
         hm1.put("USA",50);

         //Iteration
         Set<String> population= hm1.keySet();
         System.out.println(population);
         //[USA, Aus, India]

         for(String k:population){
            System.out.println("For Key->"+ k +",population is "+hm1.get(k));
         }
         /*
        For Key->USA,population is 50
        For Key->Aus,population is 100
        For Key->India,population is 150
          */
    }
}