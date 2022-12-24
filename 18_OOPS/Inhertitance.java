/**
 * Lecture 10
 * Inheritance
 * One of the pillars of OOPS
 * 
 */
public class Inhertitance {
    public static void main(String[] args) {
        Fish shark = new Fish();
        shark.eat();
        shark.breathe();
        shark.swims();
    }
}

// Base Class
class Animal {
    String color;

    void eat() {
        System.out.println("eating");
    }

    void breathe() {
        System.out.println("breathing");
    }
}

// Derived Class
class Fish extends Animal {
    int fins;

    void swims() {
        System.out.println("swimming");
    }
}