public class validateBST {
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

    public boolean isValidBST(Node root) {
        return isValidUtil(root, null, null);
    }
    
    public boolean isValidUtil(Node root, Node leftMax, Node rightMin) {
        if(root == null) {
            return true;
        }
        
        if(leftMax != null && root.data <= leftMax.data) {
            return false;
        }
        
        if(rightMin != null && root.data >= rightMin.data) {
            return false;
        }
        
        return isValidUtil(root.left, leftMax, root) 
            && isValidUtil(root.right, root, rightMin);
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
