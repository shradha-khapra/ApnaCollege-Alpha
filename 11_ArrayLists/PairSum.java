import java.util.ArrayList;
public class PairSum {
    //2 Pointer for Sorted Array
    public static boolean findSum1(ArrayList<Integer> list, int target) {
        int lp = 0, rp = list.size()-1;
        while(lp < rp) {
            if(lp+rp == target) {
                return true;
            }
            if(lp+rp < target) {
                lp++;
            } else {
                rp--;
            }
        }

        return false;
    }

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
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        int target = 5;

        System.out.println(findSum1(list, target));
    }
}
