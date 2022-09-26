import java.util.*;

public class SlidingWindowMax {
    public static void slidingWindowMax(int nums[], int k) {
        Deque<Integer> q = new LinkedList<>();

        for(int i=0; i<k; i++) {
            while(!q.isEmpty() && nums[q.getLast()] < nums[i]) {
                q.removeLast();
            }
            q.addLast(i);
        }

        // for(int i=k; i<nums.length; i++) {
        //     System.out.print(nums[q.getLast()] + " ");

        //     while(!q.isEmpty() && )
        // }

    }
    public static void main(String args[]) {
        int nums[] = {1, 3, -1, -3, 5, 3, 6, 7};
        int k=3;


    }
}
