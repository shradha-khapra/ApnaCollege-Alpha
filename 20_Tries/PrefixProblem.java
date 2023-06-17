


public class PrefixProblem{
    static class Node{
        Node children[]=new Node[26];
        boolean eow=false;
        int freq;

        public Node(){
            for(int i=0;i<children.length;i++){
                children[i]=null;
            }
            freq=1;
        }
    }
    public static Node root = new Node();

    //insert
    public static void insert(String word){
        Node curr=root;
        for(int level=0;level<word.length();level++){
            int idx=word.charAt(level) - 'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
            }
            else{
                curr.children[idx].freq++;
            }

            curr=curr.children[idx];
        }
        curr.eow=true;
    }

    public static void findPrefix(Node root, String ans){ // O(L) largest word length

        if(root==null){
            return;
        }
        if(root.freq == 1){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<root.children.length;i++){  // i < 26
            if(root.children[i] != null){
                findPrefix(root.children[i],ans+(char)(i+'a'));
            }
        }
    }
    public static void main(String args[]){
        String arr[]={"zebra", "dog", "duck", "dove"};
        for(int i=0;i<arr.length;i++){
            insert(arr[i]);
        }

        root.freq = -1; 
        //jha freq word ki 1 hogi vha rukna hai ager iski bhi 1 krege freq to root per hi ruke rhe ge aage trie m to ja hi nhi paaye ge isliye root.freq= -1
        findPrefix(root,"");
        /*
        dog
        dov
        du
        z
        */
    }
}