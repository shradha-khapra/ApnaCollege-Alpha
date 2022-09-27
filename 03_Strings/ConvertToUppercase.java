import java.util.*;

//Problem : Convert all first letters of words to UPPERCASE
public class ConvertToUppercase {
    public static String getUppercase(String str) {
        StringBuilder newStr = new StringBuilder("");
        char firstChar = Character.toUpperCase(str.charAt(0));
        newStr.append(firstChar);
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == ' ' && i != str.length()-1) {
                newStr.append(str.charAt(i));
                i++;
                char ch = Character.toUpperCase(str.charAt(i));
                newStr.append(ch);
            } else {
                newStr.append(str.charAt(i));
            }
        }
        
        return newStr.toString();
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(str);

        System.out.println(getUppercase(str));
    }
}
