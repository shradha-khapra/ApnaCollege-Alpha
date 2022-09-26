import java.util.*;

public class Chocola {
    public static void main(String args[]) {
        int n = 4, m = 6;
        Integer costVer[] = {2, 1, 3, 1, 4}; //m-1
        Integer costHor[] = {4, 1, 2}; //n-1

        int hp = 1, vp = 1; //Horizontal & Vertical Pieces
        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());


        int finalCost = 0;
        int h=0, v=0;
        while(h<n-1 && v<m-1) {
            if(costHor[h] < costVer[v]) { //vertical cut
                finalCost += costVer[v] * vp;
                hp++;
                v++;
            } else { //horizontal cut
                finalCost += costHor[h] * hp;
                vp++;
                h++;
            }
        }

        while(v<m-1) {
            finalCost += costVer[v] * vp;
            hp++;
            v++;
        }

        while(h<n-1) {
            finalCost += costHor[h] * hp;
            vp++;
            h++;
        }

        System.out.println("min cost of cutting = " + finalCost);

    }
}
