public class MinDistanceBtwNodes {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node lca(Node root, int n1, int n2) {
        if(root == null) {
            return null;
        }

        if(root.data == n1 || root.data == n2) {
            return root;
        }

        Node leftFound = lca(root.left, n1, n2);
        Node rightFound = lca(root.right, n1, n2);

        if(leftFound == null) {
            return rightFound;
        } else if(rightFound == null) {
            return leftFound;
        } else {
            return root;
        }
    }

    public static int getDist(Node root, int n) {
        if(root == null) {
            return -1;
        }

        if(root.data == n) {
            return 0;
        }

        int leftDist = getDist(root.left, n);
        if(leftDist != -1) {
            return leftDist+1;
        }

        int rightDist = getDist(root.right, n);
        if(rightDist != -1) {
            return rightDist+1;
        }

        return -1;
    }
    public static int minDist(Node root, int n1, int n2) {
        Node lca = lca(root, n1, n2);

        int d1 = getDist(lca, n1);
        int d2 = getDist(lca, n2);

        return d1+d2;
    }

    public static void main(String args[]) {
        /*
                    1
                   / \
                  2   3
                 / \ / \
                4  5 6  7   
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(minDist(root, 1, 1));
    }
}
