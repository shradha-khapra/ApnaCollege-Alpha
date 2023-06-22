import java.util.*;

public class FirstPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(3); // O(logn)
        pq.add(1);
        pq.add(5);
        pq.add(4);

        while (!pq.isEmpty()) {
            System.out.println(pq.peek()); // O(1)
            pq.remove(); // O(logn)
        }

        System.out.println();
        PriorityQueue<Integer> pqreverse = new PriorityQueue<>(Collections.reverseOrder());

        pqreverse.add(3); // O(logn)
        pqreverse.add(1);
        pqreverse.add(5);
        pqreverse.add(4);

        while (!pqreverse.isEmpty()) {
            System.out.println(pqreverse.peek()); // O(1)
            pqreverse.remove(); // O(logn)
        }
    }
}
