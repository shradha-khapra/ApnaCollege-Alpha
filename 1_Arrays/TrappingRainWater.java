package Arrays;
/* 
    DSA Sheet No. 22 
    Topic - Arrays
    Level - Medium
*/
public class TrappingRainWater {
    public static int trapWater(int height[]) {
        int n = height.length;
        int leftMax[] = new int[n] ;
        int rightMax[] = new int[n];
        leftMax[0] = height[0];
        rightMax[n-1] = height[n-1];
        
        for(int i=1; i<n; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }
        
        for(int i=n-2; i>=0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }
        
        int water = 0;
        for(int i=0; i<n; i++) {
            water += (Math.min(leftMax[i], rightMax[i]) - height[i]);
        }
        return water;
    }

    public static void main(String args[]) {
        int height[] = {4,2,0,3,2,5};
        System.out.println(trapWater(height));
    }
}
