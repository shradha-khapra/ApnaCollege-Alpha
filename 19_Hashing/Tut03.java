/*
LinkedHashMap:
{India=200, China=200, US=50}
TreeMap:
{China=200, India=200, US=50}
HashMap:
{China=200, US=50, India=200}
 */
//LinkedHashMap => jis order m keys ko put kre ge ussi order m milege ye Best Property h iskeme
//TreeMap => keys are sorted.
import java.util.*;
public class Tut03{
    public static void main(String args[]){
        System.out.println("LinkedHashMap:");
        LinkedHashMap<String,Integer> lhm = new LinkedHashMap<>();

        lhm.put("India",200);
        lhm.put("China",200);
        lhm.put("US",50);

        System.out.println(lhm);  //Insertion Order =>(jo phle put hua vhi phle order m aayega)

        System.out.println("TreeMap:");
        TreeMap<String,Integer> tm = new TreeMap<>();

        tm.put("India",200);
        tm.put("China",200);
        tm.put("US",50);

        System.out.println(tm); //Sorted (here alphabatically Because keys are String type) 

        System.out.println("HashMap:");
        HashMap<String,Integer> hm = new HashMap<>();

        hm.put("India",200);
        hm.put("China",200);
        hm.put("US",50);

        System.out.println(hm); //Unordered 
    }
}