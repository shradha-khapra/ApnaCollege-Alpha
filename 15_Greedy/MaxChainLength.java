import java.util.Arrays;
import java.util.Comparator;

public class MaxChainLength {
    public static void main(String args[]) {
        int pairs[][] = {{5, 24}, {39, 60}, {5, 28}, {27, 40}, {50, 90}};

        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        int maxLen = 1;
        int prevEnd = pairs[0][1];
        for(int i=1; i<pairs.length; i++) {
            if(pairs[i][0] > prevEnd) {
                maxLen++;
                prevEnd = pairs[i][1];
            }
        }

        System.out.println("max chain length = "+ maxLen);
    }
}
