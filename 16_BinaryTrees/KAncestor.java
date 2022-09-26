public class KAncestor {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int KthAncestor(Node root, int n, int k) {
        if(root == null) {
            return -1;
        }

        if(root.data == n) {
            return 0;
        }
        int leftDist = KthAncestor(root.left, n, k);
        int rightDist = KthAncestor(root.right, n, k);

        if(leftDist == -1 && rightDist == -1) {
            return -1;
        }

        int dist = Math.max(leftDist, rightDist);
        if(dist+1 == k) {
            System.out.println(root.data);
        }
        return dist + 1;
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

        KthAncestor(root, 3, 1);
    }
}
