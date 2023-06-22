public class UniqueSubstring {
    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word) { // O(L)
        Node curr = root;
        int idx;
        for (int i = 0; i < word.length(); i++) {
            idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }

        curr.eow = true;
    }

    public static Boolean Search(String word) { // O(L)
        Node curr = root;
        int idx;
        for (int i = 0; i < word.length(); i++) {
            idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow == true;
    }

    public static int CountNode(Node root) {
        if (root == null) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                count += CountNode(root.children[i]);
            }
        }

        return count + 1;
    }

    public static void main(String[] args) {
        String str = "ababa"; // ans = 10

        // suffix -> insert in trie
        for (int i = 0; i < str.length(); i++) {
            String suffix = str.substring(i);
            insert(suffix);
        }

        System.out.println(CountNode(root));
    }
}
