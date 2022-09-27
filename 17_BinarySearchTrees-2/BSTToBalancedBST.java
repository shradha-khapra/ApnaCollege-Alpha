import java.util.*;

public class BSTToBalancedBST {
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

    public static Node convertToBST(ArrayList<Integer> arr, int st, int end) {
        if(st > end) {
            return null;
        }
        
        int mid = (st+end)/2;
        Node curr = new Node(arr.get(mid));
        curr.left = convertToBST(arr, st, mid-1);
        curr.right = convertToBST(arr, mid+1, end);
        return curr;
    }

    public static void getInorder(Node root, ArrayList<Integer> arr) {
        if(root == null) {
            return;
        }
        getInorder(root.left, arr);
        arr.add(root.data);
        getInorder(root.right, arr);
    }

    public static Node balanceBST(Node root) {
        ArrayList<Integer> arr = new ArrayList<>();
        getInorder(root, arr);
        return convertToBST(arr, 0, arr.size()-1);
    }
    public static int height(Node root) {
        if(root == null)
            return 0;
        
        return Math.max(height(root.left), height(root.right)) + 1;
    }
    public static void main(String args[]) {
        /*
                     8
                   /   \
                  6     10
                 /       \
                5         11 
               /           \
              3             12
            given BST
         */
        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);

        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);

        /*
                     8
                   /   \
                  5     11
                 / \    / \
                3   6  10 12   
            expected BST
         */

         root = balanceBST(root);
         preorder(root);
    }
}
