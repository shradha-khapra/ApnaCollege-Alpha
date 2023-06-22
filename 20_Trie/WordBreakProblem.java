public class WordBreakProblem {
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

    public static boolean WordBreak(String key) {
        if (key.length() == 0) {
            return true;
        }
        for (int i = 1; i <= key.length(); i++) {
            if (Search(key.substring(0, i)) && WordBreak(key.substring(i))) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String words[] = { "i", "like", "sam", "samsung", "ice", "mobile" };
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        String key = "ilikesamsung";
        System.out.println(WordBreak(key));
    }
}
