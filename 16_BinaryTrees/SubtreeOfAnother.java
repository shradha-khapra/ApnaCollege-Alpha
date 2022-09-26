public class SubtreeOfAnother {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static boolean isIdentical(Node root, Node subRoot) {
        if(root == null && subRoot == null) {
            return true;
        } else if(root == null || subRoot == null || root.data != subRoot.data) {
            return false;
        }
        
        return isIdentical(root.left, subRoot.left) 
                && isIdentical(root.right,subRoot.right);
    }
    
    public static boolean isSubtree(Node root, Node subRoot) {
        if(root == null) {
            return false;
        } 
        
            
        if(root.data == subRoot.data) {
            if(isIdentical(root, subRoot)) {
                return true;
            }
        }
        
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    public static void main(String args[]) {
        /*
                    1
                   / \
                  2   3
                 / \   \
                4   5   6  
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        /**
                  2   
                 / \   
                4   5
         */
        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);

        System.out.println(isSubtree(root, subRoot));
    }
}
