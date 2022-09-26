import java.util.*;

public class ValidParentheses {
    public static boolean isValid(String str) {
        Stack<Character> s = new Stack<>();
        int i=0;
        while(i<str.length()) {
            char ch = str.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            } else {
                if(s.isEmpty()) {
                    return false;
                }
                char top = s.peek();
                if((top == '(' && ch == ')') 
                    || (top == '{' && ch == '}')
                    || (top == '[' && ch == ']')) {
                        s.pop();
                } else {
                    return false;
                }
            }

            i++;
        }
        if(!s.isEmpty()) {
            return false;
        }
        return true;
    }

    public static void main(String args[]) {
        // String str = "(([{}])()[])";
        String str = "(([{}])))[])";
        System.out.println(isValid(str));
    }
}
