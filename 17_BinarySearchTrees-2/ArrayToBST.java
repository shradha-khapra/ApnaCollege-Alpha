public class ArrayToBST {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static void preorder(Node root) {
        if(root == null) {
            return;
        }

        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static Node convertToBST(int arr[], int st, int end) {
        if(st > end) {
            return null;
        }

        int mid = (st+end)/2;
        Node curr = new Node(arr[mid]);
        curr.left = convertToBST(arr, st, mid-1);
        curr.right = convertToBST(arr, mid+1, end);
        return curr;
    }
    public static void main(String args[]) {
        int arr[] = {3, 5, 6, 8, 10, 11, 12};
        /*
                     8
                   /   \
                  5     11
                 / \    / \
                3   6  10 12   
            expected BST
         */

         Node root = convertToBST(arr, 0, arr.length-1);
         preorder(root);
    }
}
