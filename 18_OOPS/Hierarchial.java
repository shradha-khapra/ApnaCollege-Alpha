/**
 * Lecture 13
 * Hierarchial inheritance
 */
public class Hierarchial {
    public static void main(String[] args) {
        Mammal m1 = new Mammal();
        Fish f1 = new Fish();
        Bird b1 = new Bird();
        m1.breathe();
        f1.breathe();
        b1.breathe();
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

class Mammal extends Animal {
    int legs;

    void walks() {
        System.out.println("walks");
    }
}

class Fish extends Animal {
    void swim() {
        System.out.println("swimming");
    }
}

class Bird extends Animal {
    void fly() {
        System.out.println("flying");
    }
}

class Dog extends Mammal {
    String breed;
}