
//Time complexity: O(n)

import java.util.*;
public class VaildAnagram{

    public static boolean isAnagram(String s,String t){
        if(s.length()!=t.length()){
            return false;
        }
        HashMap<Character,Integer> map=new HashMap<>();

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            if(map.get(ch) != null){ //ager exist kerta hai s string m to
                if(map.get(ch)==1){ //ager char ki value sirf ak hi rhti hai to remove
                    map.remove(ch);
                }
                else{
                    map.put(ch , map.get(ch)-1);  //count-- (yani freq. m se ak kam kr diya)
                }
            }
            else{
                return false; //yani ch exist hi nhi kerta s string m
            }
        }

        return map.isEmpty(); 
        //ager anagram hoga to map khali hogya hoga or true return hoga nhi to false
    }
    public static void main(String args[]){
        String s="race";
        String t="care";

        System.out.println("String \""+s+"\" and String \""+t+"\" is Anagram:"+ isAnagram(s,t));

        //O/P
        //String "race" and String "care" is Anagram:true
    }
}