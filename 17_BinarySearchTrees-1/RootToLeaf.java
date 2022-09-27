import java.util.*;

public class RootToLeaf {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insert(Node root, int val) {
        if(root == null) {
            root = new Node(val);
            return root;
        }

         if(root.data > val) { //go to left subtree
            root.left = insert(root.left, val);
         } else { // go to right subtree
             root.right = insert(root.right, val);
         }

         return root;
    }

    public static void printPath(ArrayList<Integer> path) {
        for(int i=0; i<path.size(); i++) {
            System.out.print(path.get(i)+" ");
        }
        System.out.println();
    }

    public static void printRoot2Leaf(Node root, ArrayList<Integer> path) {
        if(root == null) {
            return;
        }

        path.add(root.data);
        
        if(root.left == null && root.right == null) {
            printPath(path);
        }
        printRoot2Leaf(root.left, path);
        printRoot2Leaf(root.right, path);
        
        path.remove(path.size()-1);
    }

    public static void main(String args[]) {
        Node root = null;
        int values[] = {8, 5, 3, 6, 10, 11, 14};
        for(int i=0; i<values.length; i++) {
            root = insert(root, values[i]);
        }

        printRoot2Leaf(root, new ArrayList<>());
    }
}
