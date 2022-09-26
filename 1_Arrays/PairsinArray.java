//Question : Print all pairs in an Array
package Arrays;

public class PairsinArray {
    public static void printPairs(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                System.out.print("("+arr[i]+","+arr[j]+")  ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]) {
        int arr[] = {1, 2, 3, 4, 5, 6};
        printPairs(arr);
    }
}
