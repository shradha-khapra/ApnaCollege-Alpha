public class Diameter {
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

    //Approach-1
    public static int diameter1(Node root) {
        if(root == null) {
            return 0;
        }

        int diamRoot = height(root.left) + height(root.right) + 1;
        int diamLeft = diameter1(root.left);
        int diamRight = diameter1(root.right);

        return Math.max(diamRoot, Math.max(diamLeft, diamRight));
    }   

    static class Info {
        int ht;
        int diam;

        public Info(int ht, int diam) {
            this.ht = ht;
            this.diam = diam;
        }
    }

    public static Info diameter2(Node root) {
        if(root == null) {
            return new Info(0, 0);
        }

        Info left = diameter2(root.left);
        Info right = diameter2(root.right);

        int diamRoot = left.ht + right.ht + 1;

        int ht = Math.max(left.ht, right.ht) + 1;
        int diam = Math.max(diamRoot, Math.max(left.diam, right.diam));

        return new Info(ht, diam);
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

        System.out.println(diameter1(root));
        System.out.println(diameter2(root).diam);
    }
}