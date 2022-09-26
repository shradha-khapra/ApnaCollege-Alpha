public class FindSubsets {
    //using StringBuilder
    public static void findSubsets(String str, int i, StringBuilder ans) {
        //base case
        if(i == str.length()) {
            if(ans.length() == 0) {
                System.out.println("null");
                return;
            }
            System.out.println(ans);
            return;
        }

        //recursion - make choice
        findSubsets(str, i+1, ans.append(str.charAt(i)));
        ans.deleteCharAt(ans.length()-1);
        findSubsets(str, i+1, ans);
    }

    //using string
    public static void findSubsets(String str, int i, String ans) {
        if(i == str.length()) {
            if(ans.length() == 0) {
                System.out.println("null");
            } else {
                System.out.println(ans);
            }
            return;
        }
        
        findSubsets(str, i+1, ans);
        findSubsets(str, i+1, ans+str.charAt(i));
    }
    public static void main(String args[]) {
        String str = "abc";
        findSubsets(str, 0, new StringBuilder(""));
        System.out.println("--------------------");
        findSubsets(str, 0, "");
    }
}
