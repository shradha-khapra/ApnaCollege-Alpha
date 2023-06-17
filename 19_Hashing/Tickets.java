
//Find Itinerary(Journey) from Tickets

import java.util.*;
public class Tickets{

    public static String getStart(HashMap<String,String> tickets){
        HashMap<String,String> revMap = new HashMap<>();

        for(String key : tickets.keySet()){
            revMap.put(tickets.get(key),key);
        }

        for(String key : tickets.keySet()){ //iteration kiya tickets map per
            if(!revMap.containsKey(key)){//check kiya h tickets map key,kya revMap ki keys m hai
                return key;//starting point
            }
        }

        return null; 
    }
    public static void main(String args[]){
        HashMap<String ,String > tickets = new HashMap<>();
        tickets.put("Chennai","Bengaluru");
        tickets.put("Mumbai","Delhi");
        tickets.put("Goa","Chennai");
        tickets.put("Delhi","Goa");

        String start = getStart(tickets);

        System.out.print(start);
        for(String key:tickets.keySet()){
            System.out.print(" -> "+ tickets.get(start));
            start = tickets.get(start); //update start
        }
        //O/P
        //Mumbai -> Delhi -> Goa -> Chennai -> Bengaluru
    }
}