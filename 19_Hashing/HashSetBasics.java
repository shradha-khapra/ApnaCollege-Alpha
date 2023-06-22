import java.util.*;

public class HashSetBasics {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();

        set.add(1);
        set.add(2);
        set.add(4);
        set.add(2);
        set.add(1);

        System.out.println(set);

        if (set.contains(2)) {
            System.out.println("2 is there in the set");
        }
        if (set.contains(3)) {
            System.out.println("3 is there in the set");
        }

        set.remove(2);
        if (set.contains(2)) {
            System.out.println("2 is there in the set");
        }

        System.out.println(set.size());

        set.clear();

        System.out.println(set.isEmpty());

        System.out.println();
        System.out.println();
        // Iteration

        HashSet<String> city = new HashSet<>();

        city.add("Delhi");
        city.add("Mumbai");
        city.add("Bulandshahr");
        city.add("Vellore");

        Iterator it = city.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println();
        System.out.println();
        // or

        for (String cities : city) {
            System.out.println(cities);
        }

    }
}
