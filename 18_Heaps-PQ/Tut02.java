

//Priority Queue For Objects
import java.util.*;
public class Tut02{

    static class Student implements Comparable<Student>{
        String name;
        int rank;

        public Student(String name,int rank){
            this.name=name;
            this.rank=rank;
        }

        @Override
        public int compareTo(Student s2){
            return this.rank - s2.rank;
        }
        /* //comparsion on the basic of name yani Lexicographically
        public int compareTo(Student s2){
            return this.name.compareToIgnoreCase(s2.name);
            // return this.name.compareTo(s2.name);
        }
         */
    }
    public static void main(String args[]){
        PriorityQueue<Student> pq = new PriorityQueue<>();
        // PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder());

        pq.add(new Student("k",7));
        pq.add(new Student("B",2));
        pq.add(new Student("f",5));
        pq.add(new Student("D",1));

        while(!pq.isEmpty()){
            System.out.println(pq.peek().name +" -> "+ pq.peek().rank);
            pq.remove();
        }

        // D -> 1
        // B -> 2
        // C -> 5
        // A -> 7
        //If we want reverse of this order then we write,
        //PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder());

    }
}