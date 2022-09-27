import java.util.*;
 
public class CompareStrings {
   public static void main(String args[]) {
       String name1 = "Tony";
       String name2 = "Tony";
 
       if(name1.equals(name2)) {
           System.out.println("They are the same string");
       } else {
           System.out.println("They are different strings");
       }
 
       //DO NOT USE == to check for string equality
       //Gives correct answer here
       if(name1 == name2) {
           System.out.println("They are the same string");
       } else {
           System.out.println("They are different strings");
       }
 
       //Gives incorrect answer here
       if(new String("Tony") == new String("Tony")) {
           System.out.println("They are the same string");
       } else {
           System.out.println("They are different strings");
       }
      
   }
}
