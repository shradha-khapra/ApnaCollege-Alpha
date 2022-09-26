import java.util.ArrayList;

public class Classroom {
    //Brute Force
    // public static boolean pairSum1(ArrayList<Integer> list, int target) {

    //     for(int i=0; i<list.size(); i++) {
    //         for(int j=i+1; j<list.size(); j++) {
    //             if(list.get(i) + list.get(j) == target) {
    //                 return true;
    //             }
    //         }
    //     }

    //     return false;
    // }

    //2 pointer approach
    public static boolean pairSum1(ArrayList<Integer> list, int target) {
        int lp = 0;
        int rp = list.size()-1;

        while(lp != rp) {
            //case 1
            if(list.get(lp)+list.get(rp) == target) {
                return true;
            }

            //case 2
            if(list.get(lp)+list.get(rp) < target) {
                lp++;
            } else {
                //case 3
                rp--;
            }
        }

        return false;
    }

    //O(n)
    public static boolean pairSum2(ArrayList<Integer> list, int target) {
        int bp = -1;
        int n = list.size();
        for(int i=0; i<list.size(); i++) {
            if(list.get(i) > list.get(i+1)) { //breaking point
                bp = i;
                break;
            }
        }

        int lp = bp+1; //smallest
        int rp = bp; //largest

        while(lp != rp) {
            //case1
            if(list.get(lp) + list.get(rp) == target) {
                return true;
            }

            //case 2
            if(list.get(lp) + list.get(rp) < target) {
                lp = (lp+1) % n;
            } else {
                //case 3
                rp = (n+rp-1) % n;
            }
        }

        return false;
    }

    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<>();
        //11, 15, 6, 8, 9, 10 - Sorted & Rotated
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        int target = 100;
        System.out.println(pairSum2(list, target));
        
    }
}
