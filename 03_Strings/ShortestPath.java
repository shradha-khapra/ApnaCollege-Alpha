import java.util.*;
//Problem : Print the displacement (Shortest Path)
public class ShortestPath {
    public static float shortestPath(String path) {
        int x = 0, y = 0;
        for(int i=0; i<path.length(); i++) {
            if(path.charAt(i) == 'N') {
                y++;
            }
            else if(path.charAt(i) == 'S') {
                y--;
            }
            else if(path.charAt(i) == 'E') {
                x++;
            }
            else {
                x--;
            }
        }
        int X2 = (x-0) * (x-0);
        int Y2 = (y-0) * (y-0);
        return (float)Math.sqrt(X2 + Y2);
    }
    public static void main(String args[]) {
        String path = "WNEENESENNN";
        System.out.println(shortestPath(path));
    }
}
