import java.util.*;

public class BacktrackonStrings {
    public static void changeStr(String str, int i, char val, int n) {
        //base case
        if(i == n) {
            System.out.println(str);
            return;
        }

        //recursion
        str = str + val;
        changeStr(str, i+1, (char)(val+1), n); //fnx call
        str.replace(val, Character.toUpperCase(val));//backtracking step
    }

    public static void main(String args[]) {
        String str = "";
        changeStr(str, 0, 'a', 5);
        System.out.println(str);
    }
}
