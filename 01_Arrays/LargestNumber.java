//Question : Print largest number in array
package Arrays;

public class LargestNumber {
    public static void main(String args[]) {
        int arr[] = {1, 2, 3, 4, 8, 3, 2, 5};
        int largest = arr[0];
        for(int i=0; i<arr.length; i++) {
            largest = Math.max(largest, arr[i]);
        }

        System.out.println("Largest number is : " + largest);
    }
}
