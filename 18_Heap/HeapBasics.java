import java.util.ArrayList;

public class HeapBasics {
    public static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {// O(logn)
            // add at last idx
            arr.add(data);

            int x = arr.size() - 1; // child index
            int par = (x - 1) / 2; // parent index

            while (arr.get(x) < arr.get(par)) { // O(logn)
                // swap
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                // updating the value
                x = par;
                par = (x - 1) / 2;
            }
        }

        public int peek() {
            return arr.get(0);
        }

        public int remove() {
            int data = arr.get(0);

            // swap root and last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);

            // remove the last element
            arr.remove(arr.size() - 1);

            // calling hepify
            heapify(0);

            return data;
        }

        private void heapify(int i) {
            int minIdx = i;
            int left = (2 * i) + 1;
            int right = (2 * i) + 2;

            if (left < arr.size() && arr.get(left) < arr.get(minIdx)) {
                minIdx = left;
            }

            if (right < arr.size() && arr.get(right) < arr.get(minIdx)) {
                minIdx = right;
            }

            if (minIdx != i) {
                // swappping
                int temp = arr.get(i);
                arr.set(i, arr.get(arr.size() - 1));
                arr.set(arr.size() - 1, temp);

                heapify(minIdx);
            }
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap();
        // heap.add(10);
        // heap.add(2);
        // heap.add(3);
        // heap.add(4);
        // heap.add(5);
        // heap.add(1);

        // // System.out.println(heap.peek());

        // System.out.println(heap.remove());

        // System.out.println(heap.peek());

        // Apna College

        // heap.add(3);
        // heap.add(4);
        // heap.add(1);
        // heap.add(5);

        while (!heap.isEmpty()) {
            System.out.println(heap.peek());
            heap.remove();
        }
    }
}
