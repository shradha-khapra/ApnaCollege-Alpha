/**
 * Lecture 6
 * Types of Constructor
 * 
 */

public class TypeOfConstructor {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student("Shradha");
        Student s3 = new Student(35);
        // Student s3 = new Student("aman",35); wrong
    }
}

class Student {
    String name;
    int rollNo;

    // Non-Parameterised Constructors
    Student() {
        System.out.println("Constructor is called...");
    }

    // Parametrised Constructor
    Student(String name) {
        name = this.name;
    }

    // Parametrised Constructor
    Student(int rollNo) {
        rollNo = this.rollNo;
    }

}