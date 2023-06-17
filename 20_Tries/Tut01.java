
//Creating a Trie
//Insertion  O(L)  L = largest word length
//Searching  O(L)  L = largest word length
public class Tut01{
    //create
    static class Node{
        Node children[] = new Node[26]; //   'a' - 'z'
        boolean eow = false; //  eow = End Of Word(ye btaye ga kya word katam ho gya hai)

        Node(){
            for(int i=0;i<children.length;i++){
                children[i] = null;
            }
        }
    }
    public static Node root = new Node(); //root is always Empty by default in Tries.

    //Insert TC => O(L) 
    public static void insert(String word){
        Node curr = root;
        for(int level=0;level<word.length();level++){
            char ch=word.charAt(level);
            int idx = ch - 'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
            }
            curr = curr.children[idx];
        }
            curr.eow = true;
    }

    //Search TC => O(L)
    public static boolean search(String word){
        Node curr = root;
        for(int level=0;level<word.length();level++){
            int idx = word.charAt(level) - 'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr = curr.children[idx];
        }
          return curr.eow==true;
        /*if(curr.eow==false){
            return false;
        }
        return true;
        */
    }
    public static void main(String args[]){
        String words[]={"the", "a", "there", "their", "any", "three"};
        //insert 
        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }

        //search
        String key="th";//false
        System.out.println("Key \"" + key + "\" Exist in Trie:"+ search(key));
        
    }
}
