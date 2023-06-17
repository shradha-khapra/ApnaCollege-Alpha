

//Priority Queue in JCF
import java.util.*;
public class Tut01{
    public static void main(String args[]){
        // PriorityQueue<Integer> pq = new PriorityQueue<>();  //1 3 5 7 9 (BY DEFAULT)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        //9 7 5 3 1 


        pq.add(5);
        pq.add(3);
        pq.add(9);
        pq.add(1);
        pq.add(7);

        while(!pq.isEmpty()){
            System.out.print(pq.peek()+" ");
            pq.remove();
        }

        // o/p
        //1 3 5 7 9
        //9 7 5 3 1  
    }
}