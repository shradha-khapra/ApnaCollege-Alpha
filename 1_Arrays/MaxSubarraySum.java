//Question : Print maximum subarray sum
package Arrays;

public class MaxSubarraySum {
    //bruteforce
    public static void maxSubarraySum1(int arr[]) {
        int largestSum = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                int currSum = 0;
                for(int k=i; k<=j; k++) {
                    currSum += arr[k];
                }
                largestSum = Math.max(largestSum, currSum);
            }
        }
        
        System.out.println("max subarray sum is : " + largestSum);
    }

    //optimization1 : Prefix Sum array
    public static void maxSubarraySum2(int arr[]) {
        int maxSum = Integer.MIN_VALUE;

        int prefix[] = new int[arr.length];
        prefix[0] = arr[0];
        for(int i=1; i<arr.length; i++) {
            prefix[i] = prefix[i-1] + arr[i];
        }

        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                int currSum = i==0 ? prefix[j] : prefix[j] - prefix[i-1];
                maxSum = Math.max(maxSum, currSum);
            }
        }
        
        System.out.println("max subarray sum is : " + maxSum);
    }

    //Kadane's Algorithm
    public static void maxSubarraySum3(int arr[]) {
        int cs = 0;
        int ms = 0;

        for(int i=0; i<arr.length; i++) {
            cs = cs + arr[i];
            ms = Math.max(ms, cs);
            if(cs < 0) {
                cs = 0;
            } 
        }

        System.out.println("max subarray sum is : " + ms);
    }
    public static void main(String args[]) {
        int arr[] = {1, -2, 6, -1, 3};
        maxSubarraySum1(arr); 
        maxSubarraySum2(arr);
        maxSubarraySum3(arr);
    }
}
