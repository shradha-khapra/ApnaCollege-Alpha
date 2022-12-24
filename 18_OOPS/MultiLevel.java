import javax.annotation.processing.SupportedOptions;

/**
 * Lecture 12
 * MultiLevel Inheritance
 */
public class MultiLevel {
    public static void main(String[] args) {
        Dog dobby = new Dog();
        dobby.eat();
        dobby.legs = 4;
        System.out.println(dobby.legs);
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
}

class Dog extends Mammal {
    String breed;
}
