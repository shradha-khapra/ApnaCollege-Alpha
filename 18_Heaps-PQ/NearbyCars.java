
import java.util.*;
public class NearbyCars{
    static class Point implements Comparable<Point>{
        int x;
        int y;
        int distSq;  //x^2 + y^2
        int idx;

        public Point(int x,int y,int distSq,int idx){
            this.x=x;
            this.y=y;
            this.distSq=distSq;
            this.idx=idx;
        }

        @Override
        public int compareTo(Point p2){
            return this.distSq - p2.distSq; //asending order (Yani phle mini dist vala aage hoga)
        }
    }
    public static void main(String args[]){
        int pts[][]={ { 3,3},   // C0
                      {5,-1},   // C1
                      {-2,4}};  // C2 
        int k=2; //Find Nearest Kth Cars

        PriorityQueue<Point> pq = new PriorityQueue<>();
        for(int i=0;i<pts.length;i++){
            int distSq= pts[i][0]*pts[i][0] + pts[i][1]*pts[i][1] ;  //x^2 + y^2
            pq.add(new Point(pts[i][0],pts[i][1],distSq,i));
        }

            System.out.println("Nearest "+k+"(Kth) Cars:");
        for(int i=0;i<k;i++){
            System.out.print("C"+ pq.remove().idx);
            System.out.println();
        }

        // Nearest 2(Kth) Cars:
        // C0
        // C2

    }
}