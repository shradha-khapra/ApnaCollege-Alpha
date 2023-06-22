public class MaxMinSegmentTreeCreation {
    static int tree[];

    public static void init(int n) {
        tree = new int[4 * n];
    }

    public static void buildBST(int arr[], int i, int start, int end) { // O(n)
        if (start == end) {
            tree[i] = arr[start];
            return;
        }

        int mid = (start + end) / 2;
        buildBST(arr, 2 * i + 1, start, mid); // left subtree -> (2*i) + 1
        buildBST(arr, 2 * i + 2, mid + 1, end); // right subtree -> (2*i) + 2

        tree[i] = Math.max(tree[2 * i + 1], tree[2 * i + 2]);
    }

    public static void main(String[] args) {
        int[] arr = { 6, 8, -1, 2, 17, 1, 3, 2, 4 };
        int n = arr.length;

        init(n);
        buildBST(arr, 0, 0, n - 1);

        for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i] + " ");
        }
    }
}
