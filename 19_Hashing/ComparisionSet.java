import java.util.*;

public class ComparisionSet {
    public static void main(String[] args) {
        HashSet<String> city = new HashSet<>();

        city.add("Delhi");
        city.add("Mumbai");
        city.add("Bulandshahr");
        city.add("Vellore");

        System.out.println(city);
        System.out.println();

        LinkedHashSet<String> lhs = new LinkedHashSet<>();

        lhs.add("Delhi");
        lhs.add("Mumbai");
        lhs.add("Bulandshahr");
        lhs.add("Vellore");

        System.out.println(lhs);
        System.out.println();

        TreeSet<String> ts = new TreeSet<>();

        ts.add("Delhi");
        ts.add("Mumbai");
        ts.add("Bulandshahr");
        ts.add("Vellore");

        System.out.println(ts);
        System.out.println();
    }
}
