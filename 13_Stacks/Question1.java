import java.util.*;
//To push an element at the bottom of a stack
public class Question1 {
    public static void pushAtBottom(Stack<Integer> s, int data) {
        if(s.isEmpty()) {
            s.push(data);
            return;
        }

        int temp = s.pop();
        pushAtBottom(s, data);
        s.push(temp);
    }

    public static void main(String args[]) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        pushAtBottom(stack, 4);

        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
