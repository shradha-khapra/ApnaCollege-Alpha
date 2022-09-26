import java.util.*;

//Problem : Compress the given string
public class StringCompression {
    public static String compressString(String str) {
        String newStr = "";

        for(int i=0; i<str.length(); i++) {
            Integer count = 1;

            while(i < str.length()-1 && str.charAt(i) == str.charAt(i+1)) {
                count++;
                i++;
            }

            newStr += str.charAt(i);
            newStr = count > 1 ? newStr + count.toString() : newStr;
        }

        return newStr;
    }
    public static void main(String args[]) { 
        String str = "aaabbcccdd";
        System.out.println(compressString(str));
    }
}
