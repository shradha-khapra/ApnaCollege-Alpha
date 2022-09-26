import java.util.*;

public class Basics {
    public static void main(String args[]) {
        int n = 5; //rows
        int m = 3; //cols
        int marks[][] = new int [n][m];

        //Taking Input
        Scanner sc = new Scanner(System.in);
        
        for(int i=0; i<n; i++) {
            System.out.println("Enter marks of student " + i);
            for(int j=0; j<m; j++) {
                marks[i][j] = sc.nextInt(); // marks of ith student
            }
        }

        //Printing Output
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                System.out.print(marks[i][j] +" ");
            }
            System.out.println();
        }
    }
}