/*  
@SuppressWarnings("unchecked") line likne ka kaarn,ye line h this.buckets = new LinkedList[4]; 
Kyukii java k kuch versions k ander us line m LinkedList nhi likh skte vha LinkedList ka type btana pde ga kii ager aap array of LinkedList bna bhi rhe hoo to LinkedList kis type ki us array k ander vo hme bnata padta hai isliye java hamre code ko run nhi kerne dega ager hum sirf ye line likte hai this.buckets = new LinkedList[4]; 
code run nhi hoga java k kuch versions k ander error(*Warning) aa sktii hai isliye us Error ko rokne k liye hum hum   @SuppressWarnings("unchecked") ye line likh dete hai or ye faltu  errors ko Supress ker deta hai or unchecked likne ka kaarn hai ki vo error aaye gi jo LinkedList ka type na btane per vo unchecked type ki error hai yani check hi nhi kiya ki kis type ki LinkedList form hogi
jab bhi ye vali line likhe ge this.buckets = new LinkedList[4]; to hume uper simply ye bhi linkna hoga @SuppressWarnings("unchecked") 
 */



//Implementation Of HashMap

import java.util.*;
public class Tut02{

    static class HashMap< K,V >{//generic
        private class Node{
            K key;
            V value;

            public Node(K key,V value){
                this.key=key;
                this.value=value;
            }
        }

        private int n; // n => nodes/pair
        private int N; // N => buckets
        private LinkedList<Node> buckets[];  // N => buckets.length

        @SuppressWarnings("unchecked")
        public HashMap(){ //Constructor
            this.N=4;
            this.buckets = new LinkedList[4]; //is line k kaarn uper @SuppessW... linka Reason:L1
            for(int i=0;i<4;i++){   //her ak idx(Bucket) per jake khali LL ko create ker liya hai
                this.buckets[i] = new LinkedList<>(); 
            }
        }

        private int hashFunction(K key){
            int hc = key.hashCode();
            return Math.abs(hc) % N;
        }

        private int searchInLL(K key,int bi){
            LinkedList<Node> ll = buckets[bi];
            int di=0;
            for(int i=0;i<ll.size();i++){
                Node node=ll.get(i);
                if(node.key==key){ //key already exist
                    return di;
                }

                di++;
            }
            return -1; //key not exits in bucket
        }

        @SuppressWarnings("unchecked")
        public void rehash(){
            LinkedList<Node> oldBucket[] = buckets; //Store old bucket 
            buckets = new LinkedList[N*2];//bucket ko khali kerke,Create ki bucket of double size 
            N = N*2; //size of buckets ko bhi update ker dege

            for(int i=0;i<buckets.length;i++){
                buckets[i] = new LinkedList<>(); //her bucket ki LL create ker di
            }

            //node -> add in bucket (jo store kerva diye the oldBucket m)
            for(int i=0;i<oldBucket.length;i++){
                LinkedList<Node> ll =oldBucket[i];
                for(int j=0;j<ll.size();j++){
                    Node node = ll.remove();
                    put(node.key,node.value);
                }
            }
        }

        public void put(K key,V value){ //TC=>  O(lamda) lamda-> contant So O(1)
            int bi = hashFunction(key); //Bucket Index => 0 to n-1
            int di = searchInLL(key,bi); // idx for key [di=> data idx]

            if(di != -1){ //Key already exits So update the value
                Node node= buckets[bi].get(di);
                node.value=value;
            }else{
                buckets[bi].add(new Node(key,value));
                n++;
            }

            double lamda = (double)n/N;
            if(lamda > 2.0){
                rehash();
            }
        }

        public boolean containsKey(K key){ //O(lamda) -> O(1)
            int bi = hashFunction(key); 
            int di = searchInLL(key,bi); 

            if(di != -1){ //Key already exist
               return true;
            }

            return false; //key not exist
        }

        public V remove(K key){ //O(lamda) -> O(1)
            int bi = hashFunction(key); 
            int di = searchInLL(key,bi); 

            if(di != -1){ //Key already exits
                Node node = buckets[bi].remove(di);
                n--;//nodes size - 1
                return node.value;
            }

            return null; //key not exist
        }

        public V get(K key){ //O(lamda) -> O(1)
            int bi = hashFunction(key); 
            int di = searchInLL(key,bi); 

            if(di != -1){ //Key already exits
                Node node = buckets[bi].get(di);
                return node.value;
            }

            return null; //key not exist
        }

        public ArrayList<K> keySet(){
            ArrayList<K> keys= new ArrayList<>();

            for(int i=0;i<buckets.length;i++){
                LinkedList<Node> ll =buckets[i];
                for(Node node : ll){
                    keys.add(node.key);
                }
            } 
            return keys;
        }

        public boolean isEmpty(){
            return n==0; //if nodes(n) zero huii to True return nhi to False
        }
    }


    public static void main(String args[]){
        HashMap<String,Integer> hm = new HashMap<>();//this is my class HashMap not in-built HashM
        hm.put("India",150);
        hm.put("Austalia",150);
        hm.put("USA",50);
        hm.put("Uk",40);

        ArrayList<String> keys = hm.keySet();
        //Iteration
        for(String key : keys){
            System.out.println(key);
        }

        System.out.println("Value of India:"+hm.get("India"));
        System.out.println(hm.remove("USA"));
        System.out.println(hm.get("USA"));

        System.out.println(hm.containsKey("India"));
    }
}