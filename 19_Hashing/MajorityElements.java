
//MajorityElements => O(n) because of loop,other used operations TC is O(1)

import java.util.*;
public class MajorityElements{
    public static void main(String args[]){
        int arr[]={1,2}; //1,2
        // int arr[]={1,2,5,3,1,3,1,5,1};  //1
        int n= arr.length;

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            int num=arr[i];
            /*if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }
            else{
                map.put(num,1);
            }*/
            map.put(num,map.getOrDefault(num,0)+1);
//getOrDefault() -> isme ager key exits kertii hai to uski value return kerge nhi to default value hum jo dege vo return krega yha ager key exits nhi kerti to 0 return krega
        }

        // Set<Integer> keys = map.keySet();
        for(Integer key:map.keySet()){
            if(map.get(key) > (n/3)){
                System.out.print(key+" ");
            }
        }

    }
}