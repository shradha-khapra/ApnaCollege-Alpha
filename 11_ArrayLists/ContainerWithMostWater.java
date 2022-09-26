import java.util.ArrayList;
public class ContainerWithMostWater {
    //Brute Force - O(n^2)
    public static int FMWC(ArrayList<Integer> height) {
        int maxWater = 0;
        for(int i=0; i<height.size(); i++) {
            for(int j=i+1; j<height.size(); j++) {
                int ht = Math.min(height.get(i), height.get(j)); //container ht
                int width = j-i; //container width
                int currWater = ht * width;
                maxWater = Math.max(maxWater, currWater);
            }
        }

        return maxWater;
    }

    //Optimized (2 pointer) - O(n)
    public static int findMaxWaterContainer(ArrayList<Integer> height) {
        int leftPtr = 0, rightPtr = height.size()-1;
        int maxWater = 0;
        while(leftPtr < rightPtr) {
            int ht = Math.min(height.get(leftPtr), height.get(rightPtr));
            int width = rightPtr-leftPtr;
            int currWater = ht * width;
            maxWater = Math.max(currWater, maxWater);

            //move ptrs
            if(height.get(leftPtr) < height.get(rightPtr)) {
                leftPtr++;
            } else {
                rightPtr--;
            }
        }

        return maxWater;
    }
    public static void main(String args[]) {
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        System.out.println(FMWC(height));
        System.out.println(findMaxWaterContainer(height));
    }
}
