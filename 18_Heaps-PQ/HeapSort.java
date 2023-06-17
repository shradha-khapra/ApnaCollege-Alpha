
// TIME Complexity: O(nLogn)
public class HeapSort{

    public static void heapify(int arr[], int n, int i) { // n is Size

      // Find largest among root, left child and right child
      int largest = i; //MaxIndex
      int l = 2 * i + 1; //left idx
      int r = 2 * i + 2; //right idx
  
      if (l < n && arr[l] > arr[largest]){
        largest = l;
      }
  
      if (r < n && arr[r] > arr[largest]){
        largest = r;
      }
  
      // Swap and continue heapifying if root is not largest
      if (largest != i) {
        int temp = arr[i];
        arr[i] = arr[largest];
        arr[largest] = temp;
  
        heapify(arr, n, largest);
      }
    }

    public static void heapSort(int arr[]){
        //step 1 - Bulid MaxHeap (If ascending order)
        int n = arr.length;
  
        // Build max heap
      for (int i = n / 2 - 1; i >= 0; i--) {
           heapify(arr, n, i);
        }

        //Step 2 - Push Largest at End
         // Heap sort
      for (int i = n - 1; i >= 0; i--) {
        //Swap (Largest with last element)
          int temp = arr[0];
          arr[0] = arr[i];
          arr[i] = temp;
  
          // Heapify root element
          heapify(arr, i, 0);
      }

    }
    public static void main(String args[]){
        int arr[]={1,2,4,5,3}; //ArrayList bhi use ker skte the
        heapSort(arr);

        System.out.println("Heap Sort:");
        //Print
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }

            // Heap Sort: (Ascending order)
            //  1 2 3 4 5 

            //Decending order kerna hota to yaa to is print loop ko unlta chla do ya fir MaxHeap ki jaghe per MinHeap bnoo fir print kerva do O/P hogi => 5 4 3 2 1 
    }
}