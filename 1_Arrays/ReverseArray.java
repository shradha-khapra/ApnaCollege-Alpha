//Question : Reverse an Array
package Arrays;

public class ReverseArray {
    public static void reverse(int arr[]) {
        int start = 0;
        int end = arr.length-1;

        while(start <= end) {
            //swap
            int t = arr[start];
            arr[start] = arr[end];
            arr[end] = t;

            start++;
            end--;
        }
    }

    public static void printArray(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = {1, 2, 3, 4, 5, 6};
        printArray(arr);
        reverse(arr);
        printArray(arr);
    }
}
