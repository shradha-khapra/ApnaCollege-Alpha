//Question : Binary Search in an Array
package Arrays;

public class BinarySearch {
    public static int binSearch(int arr[], int key) {
        int start = 0;
        int end = arr.length-1;

        while(start <= end) {
            int mid = (end + start)/2;
            //case 1
            if(arr[mid] == key) {
                return mid;
            } 
            else if(arr[mid] < key) {
                start = mid + 1;
            }
            else {
                end = mid-1;
            }
        }

        return -1;
    }
    public static void main(String args[]) {
        int arr[] = {1, 2, 3, 4, 5, 6};
        int idx = binSearch(arr, 4);
        System.out.println("index is : " + idx);
    }
}
