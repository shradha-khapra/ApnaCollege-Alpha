/**
 * Lecture 5
 * Constructor in Java
 * Java has its own default constructor
 * It invokes automatically
 */

public class Constructor {
    public static void main(String[] args) {
        Student s1 = new Student("Shradha");
        System.out.println(s1.name);
    }

}

class Student {
    String name;
    int rollNo;

    Student(String name) {
        name = this.name;
        System.out.println("Constructor is called...");
    }

}