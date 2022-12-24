/**
 * Lecture 8
 * Copy Constrcutors
 */
public class CopyConstructor {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "shradha";
        s1.rollNo = 456;
        s1.pswd = "abcd";

        s1.marks[0] = 100;
        s1.marks[1] = 90;
        s1.marks[2] = 80;

        Student s2 = new Student(s1); // copy
        s1.pswd = "xyz";
        s1.marks[2] = 100;
        for (int i = 0; i < 3; i++) {
            System.out.println(s2.marks[i]);
        }

    }
}

class Student {
    String name;
    int rollNo;
    String pswd;
    int marks[];

    class Address {
        String city;
    }

    Student(Student s1) {
        marks = new int[3];
        this.name = s1.name;
        this.rollNo = s1.rollNo;
        this.marks = s1.marks;
    }

    // Non-Parameterised Constructors
    Student() {
        marks = new int[3];
        System.out.println("Constructor is called...");
    }

    // Parametrised Constructor
    Student(String name) {
        marks = new int[3];
        name = this.name;
    }

    // Parametrised Constructor
    Student(int rollNo) {
        marks = new int[3];
        rollNo = this.rollNo;
    }

}