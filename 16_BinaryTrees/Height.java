public class Height {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int height(Node root) {
        if(root == null) {
            return 0;
        }

        return Math.max(height(root.left), height(root.right)) + 1;
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

        System.out.println(height(root));
    }
}
