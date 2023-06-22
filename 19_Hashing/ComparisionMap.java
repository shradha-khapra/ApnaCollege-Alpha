import java.util.*;

public class ComparisionMap {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();

        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);
        hm.put("Indonesia", 6);
        hm.put("Nepal", 5);

        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();

        lhm.put("India", 100);
        lhm.put("China", 150);
        lhm.put("US", 50);
        lhm.put("Indonesia", 6);
        lhm.put("Nepal", 5);

        TreeMap<String, Integer> tm = new TreeMap<>();

        tm.put("India", 100);
        tm.put("China", 150);
        tm.put("US", 50);
        tm.put("Indonesia", 6);
        tm.put("Nepal", 5);

        System.out.println();
        System.out.println(hm);
        System.out.println();
        System.out.println(lhm);
        System.out.println();
        System.out.println(tm);
        System.out.println();
    }
}