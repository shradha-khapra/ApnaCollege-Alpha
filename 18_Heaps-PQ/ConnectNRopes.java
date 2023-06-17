
//Connect N ropees with Minimum Cost, Cost of connecting two ropes equal to ropes length sum
import java.util.*;
public class ConnectNRopes{
    public static void main(String args[]){
        int ropes[]={4,6,2,3,3};

        PriorityQueue<Integer> pq =  new PriorityQueue<>();
        
        for(int i=0;i<ropes.length;i++){
            pq.add(ropes[i]);
        }

        int cost=0;
        while(pq.size() > 1){
            int min1=pq.remove(); 
            int min2=pq.remove();
            cost+= min1 + min2 ;
            pq.add(min1+min2);
        }
//priority queue default m asending order m ker deti hai values ko
//two mini values ko add krege,fir cost m bhi add ker dege,un two mini R ka sum or pq.add kerge
     /* 2 + 3 = 5
        4 + 3 = 7
        5 + 6 = 11
        11 + 7= 18
        total = 41 */

        System.out.println("Cost Of Connecting N Ropes:"+cost);
    }
}