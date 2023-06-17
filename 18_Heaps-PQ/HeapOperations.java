

//MaxHeap m convert kerne k liye line 18,38 or 41 line m < iska > ye ker do or > iska < ye && k baad vali m bus 38,41

import java.util.*;
public class HeapOperations{

    static class Heap{
        ArrayList<Integer>arr = new ArrayList<>();

        public void add(int data){ //O(logN)
            //add at last idx
            arr.add(data);

            int x = arr.size()-1; //x is a child index
            int par = (x-1)/2; //parent idx

            while(arr.get(x) < arr.get(par)){ //arr.get(x) > arr.get(par) => MAXheap
                //O(logN) kuykii child se parent tak jayge WorstC me
                //swap
                int temp=arr.get(x);
                arr.set(x,arr.get(par));
                arr.set(par,temp);

                x=par;
                par=(x-1)/2;
            }
        }

        public int peek(){
            return arr.get(0);
        }

        private void heapify(int idx){ //O(logN)
            int left=2*idx+1;
            int right=2*idx+2;
            int minIdx=idx;

if(left<arr.size() && arr.get(minIdx) > arr.get(left)){ //arr.get(minIdx)<arr.get(left) in MaxHeap
                minIdx=left;
            }
if(right<arr.size() && arr.get(minIdx)>arr.get(right)){//arr.get(minIdx)<arr.get(right) inMaxHeap
                minIdx=right;
            }
            if(minIdx != idx){
                //swap
                int temp=arr.get(idx);
                arr.set(idx,arr.get(minIdx));
                arr.set(minIdx,temp);

                heapify(minIdx);
            }
        }

        public int remove(){ //O(logN)
            int data=arr.get(0); //first

            //step1 - swap first & last
            int temp=arr.get(0);
            arr.set(0,arr.get(arr.size()-1));
            arr.set(arr.size()-1,temp);

            //step2 - delete last
             arr.remove(arr.size()-1);

            //step3 -heapify
            heapify(0);
            return data;
        }

        public boolean isEmpty(){
            return arr.size()==0;  //jab size 0 hoga to True return ho jayega
        }
    }
    public static void main(String args[]){

        Heap h = new Heap();
        h.add(4);
        h.add(3);
        h.add(5);
        h.add(2);
        h.add(6);
        h.add(10);

        while(!h.isEmpty()){
            System.out.println(h.peek()+" ");
            h.remove();
        }

        /* //MinHeap            //MaxHeap
               2                    10   
               3                    6 
               4                    5  
               5                    4   
               6                    3   
               10                   2   
         */
        
    }
}