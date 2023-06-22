public class MaxMinSegmentTreeQueryUpdate {
    // for minimum.......do max -> min
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

    public static int getMax(int[] arr, int qi, int qj) {
        int n = arr.length;
        return getMaxUtil(0, 0, n - 1, qi, qj);
    }

    public static int getMaxUtil(int i, int si, int sj, int qi, int qj) {
        if (si > qj || sj < qi) { // no overlap
            return Integer.MIN_VALUE;
        } else if (si >= qi && sj <= qj) { // complete Overlap
            return tree[i];
        } else { // partial overlap
            int mid = (si + sj) / 2;
            int leftAns = getMaxUtil(2 * i + 1, si, mid, qi, qj);
            int rightAns = getMaxUtil(2 * i + 2, mid + 1, sj, qi, qj);
            return Math.max(leftAns, rightAns);
        }
    }

    public static void update(int[] arr, int idx, int newVal) { // O(logn)
        arr[idx] = newVal;
        int n = arr.length;

        updateUtil(0, 0, n - 1, idx, newVal); // segment tree updation
    }

    public static void updateUtil(int i, int si, int sj, int idx, int newVal) {
        if (idx < si || idx > sj) {
            return;
        }

        if (si == sj) {
            tree[i] = newVal;
        }

        if (si != sj) {
            tree[i] = Math.max(tree[i], newVal);
            int mid = (si + sj) / 2;
            updateUtil(2 * i + 1, si, mid, idx, newVal); // left
            updateUtil(2 * i + 2, mid + 1, sj, idx, newVal); // right
        }
    }

    public static void main(String[] args) {
        int[] arr = { 6, 8, -1, 2, 17, 1, 3, 2, 4 };
        int n = arr.length;

        init(n);
        buildBST(arr, 0, 0, n - 1);

        for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i] + " ");
        }

        System.out.println();

        int max = getMax(arr, 2, 5);
        System.out.println(max);

        update(arr, 2, 20);

        max = getMax(arr, 2, 5);
        System.out.println(max);
    }
}
