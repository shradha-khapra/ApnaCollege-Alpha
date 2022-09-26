import java.util.ArrayList;

public class MergeBSTs {
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

    public static void getInorder(Node root, ArrayList<Integer> arr) {
        if(root == null)
            return;

        getInorder(root.left, arr);
        arr.add(root.data);
        getInorder(root.right, arr);
    }

    public static Node constructBST(ArrayList<Integer> arr, int st, int end) {
        if(st > end) {
            return null;
        }

        int mid = (st+end)/2;
        Node curr = new Node(arr.get(mid));
        curr.left = constructBST(arr, st, mid-1);
        curr.right = constructBST(arr, mid+1, end);

        return curr;
    }

    public static Node merge(Node root1, Node root2) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorder(root1, arr1);
        getInorder(root2, arr2);

        ArrayList<Integer> finalArr = new ArrayList<>();
        int i=0, j=0;
        while(i < arr1.size() && j < arr2.size()) {
            if(arr1.get(i) <= arr2.get(j)) {
                finalArr.add(arr1.get(i++));
            } else {
                finalArr.add(arr2.get(j++));
            }
        }

        while(i<arr1.size()) {
            finalArr.add(arr1.get(i++));
        }

        while(j < arr2.size()) {
            finalArr.add(arr2.get(j++));
        }

        return constructBST(finalArr, 0, finalArr.size()-1);
    }

    public static void main(String args[]) {
        /*     
                  2     
                 / \    
                1   4   
                BST1
         */
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);
        
        /*     
                  9    
                 / \    
                3   12   
                BST2
         */
        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);


        /* 2 possible expected balanced BSTs can be formed
                     4
                    /  \ 
                   2    9
                  / \    \
                 1   3   12 
            
                      3
                    /   \ 
                   1      9
                    \    / \
                     2  4  12 
                final ans is our 2nd BST
        */

        preorder(merge(root1, root2));
    }
}
