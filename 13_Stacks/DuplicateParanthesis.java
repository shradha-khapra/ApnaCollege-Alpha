import java.util.*;

public class DuplicateParanthesis {
    public static boolean checkDuplicate(String str) {
        Stack<Character> s = new Stack<>();
        int i=0;
        while(i<str.length()) {
            char ch = str.charAt(i);
            if(ch == ')') {
                
                int countItems = 0;
                while(s.pop() != '(') {
                    countItems++;
                }

                if(countItems < 1) {
                    return true;
                }

            } else {
                s.push(ch);
            }

            i++;
        }
       
        return false;
    }
    public static void main(String args[]) {
         //String str = "(a+b)"; //false
         //String str = "((a+b)+(c))"; //false
         //String str = "(((a+b))+c)"; //true
        //String str = "((a+b))"; //true
        String str = "(((a+(b))+(c+d)))"; //true
        System.out.println(checkDuplicate(str));
    }
}
