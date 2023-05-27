import java.util.*;

//Problem : Convert all first letters of words to UPPERCASE
public class ConvertToUppercase {
    public static String getUppercase(String str) {
        StringBuilder newStr = new StringBuilder();
        // space_found = true to capitalize first word
        boolean space_found = true;
        for (int i = 0; i < str.length(); i++) {
            if (space_found) {
                char ch = Character.toUpperCase(str.charAt(i));
                newStr.append(ch);
            } else {
                newStr.append(str.charAt(i));
            }
            // every new word starts after a space
            space_found = str.charAt(i) == ' ';
        }
        return s.toString();
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(str);

        System.out.println(getUppercase(str));
    }
}
