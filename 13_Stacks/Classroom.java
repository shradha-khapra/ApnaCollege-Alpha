import java.util.*;

public class Classroom {
    public static boolean isValid(String str) { // O(n)
        Stack<Character> s = new Stack<>();
        
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            
            if(ch == '(' || ch == '{' || ch == '[') {//opening
                s.push(ch);
            } else {
                //closing
                if(s.isEmpty()) {
                    return false;
                }
                if( (s.peek() == '(' && ch == ')') //() 
                    || (s.peek() == '{' && ch == '}') //{}
                    || (s.peek() == '[' && ch == ']') ) { //[]
                        s.pop();
                } else {
                    return false;
                }
            }
        }

        if(s.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean isDuplicate(String str) { //O(n)
        Stack<Character> s = new Stack<>();

        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            
            //closing
            if(ch == ')') {
                int count = 0;
                while(s.pop() != '(') {
                    count++;
                }
                if(count < 1) {
                    return true; //duplicate
                } 

            } else {
                //opening
                s.push(ch);
            }
        }

        return false;
    }


    public static void maxArea(int arr[]) { //O(n) - optimized
        int maxArea = 0;
        int nsr[] = new int[arr.length];
        int nsl[] = new int[arr.length];

        //Next Smaller Right = O(n)
        Stack<Integer> s = new Stack<>();

        for(int i=arr.length-1; i>=0; i--) {
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nsr[i] = arr.length;
            } else {
                nsr[i] = s.peek();
            }
            s.push(i);
        }

        //Next Smaller Left - O(n)
        s = new Stack<>();

        for(int i=0; i<arr.length; i++) {
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = s.peek();
            }
            s.push(i);
        }

        //Current Area : width = j-i-1 = nsr[i]-nsl[i]-1 - O(n)
        for(int i=0; i<arr.length; i++) {
            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1;
            int currArea = height * width;
            maxArea = Math.max(currArea, maxArea);
        }

        System.out.println("max area in histogram = " + maxArea);
    }
    public static void main(String args[]) { 
        int arr[] = {2, 4}; //heights in histogram
        maxArea(arr);
    }
}
