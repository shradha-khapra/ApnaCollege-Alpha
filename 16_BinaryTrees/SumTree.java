public class SumTree {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int convertToSumTree(Node root) {
        if(root == null) {
            return 0;
        }
        
        int leftVal = convertToSumTree(root.left);
        int rightVal = convertToSumTree(root.right);
        int leftSubtree = root.left == null ? 0 : root.left.data;
        int rightSubtree = root.right == null ? 0 : root.right.data;
        
        int myData = root.data;
        root.data = leftSubtree + leftVal + rightSubtree + rightVal;
        return myData;
    }

    public static void preorder(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String args[]) {
        /*
                    1
                   / \
                  2   3
                 / \ / \
                4  5 6  7   

                expected sum tree is :
                    
                    27
                   /  \
                  9    13
                 / \   / \
                0   0 0   0 
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        convertToSumTree(root);
        preorder(root);
    }
}
