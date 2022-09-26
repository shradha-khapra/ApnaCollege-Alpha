import java.util.*;

public class AreaInHistogram {
    public static void print(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void maxArea(int arr[]) {
        int nls[] = new int[arr.length]; //Next Left Smallest
        int nrs[] = new int[arr.length]; //Next Right Smallest
        Stack<Integer> s = new Stack<>();

        //Next Right Smallest
        for(int i=arr.length-1; i>=0; i--) {
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nrs[i] = arr.length;
            } else {
                nrs[i] = s.peek();
            }
            s.push(i);
        }

        //Next Left Smallest
        s = new Stack<>();
        for(int i=0; i<arr.length; i++) {
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nls[i] = -1;
            } else {
                nls[i] = s.peek();
            }
            s.push(i);
        }

        //Calculate Rectangle
        int max = 0;
        for(int i=0; i<arr.length; i++) {
            int curr = arr[i]*(nrs[i]-nls[i]-1);
            max = Math.max(max, curr);
        }

        System.out.println("max area of histogram = " + max);
    }
    public static void main(String args[]) {
        int arr [] = {2,1,5,6,2,3};
        maxArea(arr);
   }
}
