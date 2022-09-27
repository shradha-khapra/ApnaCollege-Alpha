public class RotatedSortedArray {
    //using recursion
    public static int search(int arr[], int tar, int si, int ei) {
        if(si > ei) {
            return -1;
        }

        int mid = (si+ei)/2;
        if(tar == arr[mid]) {
            return mid;
        }

        //mid on L1
        if(arr[si] <= arr[mid]) {
            if(arr[si] <= tar && tar <= arr[mid] ) { //go left
                return search(arr, tar, si, mid-1);
            } else { //go right
                return search(arr, tar, mid+1, ei);
            }
        }

        //mid on L2
        else {
            if(arr[mid] <= tar && tar <= arr[ei]) { //go right
                return search(arr, tar, mid+1, ei);
            } else { //go left
                return search(arr, tar, si, mid-1);
            }
        }
    }

    //using iteration
    public int search(int[] arr, int target) {
        int si = 0;
        int ei = arr.length-1;
        
        while(si <= ei) {
            int mid = (si+ei)/2;
            if(arr[mid] == target) {
                return mid;
            }
            //falls on L1
            if(arr[si] <= arr[mid]) {
                if(arr[si] <= target && target <= arr[mid]) {
                    //go left
                    ei = mid-1;
                } else {
                    //go right
                    si = mid+1;
                }
            }
            
            //falls on L2
            else {
                if(arr[mid] <= target && target <= arr[ei]) {
                    //go right
                    si = mid+1;
                } else {
                    //go left
                    ei = mid-1;
                }
            }
        }
        
        return -1;
    }
    public static void main(String args[]) {
        // int arr[] = {4,5,6,7,0,1,2};
        // int target = 0;
        //expected output = 4;
        int arr[] = {4, 5, 6, 1, 2, 3};
        int target = 3;
        //expected output = 5;
        System.out.println(search(arr, target, 0, arr.length-1));
        
    }
}