/**
 * Leacture 1 - Classes and Objects
 * Classes name starts with Capital letters as a conventions
 * new keyword - allocates memory in heap
 * public- its a access modifier
 */
public class Oops {
    public static void main(String[] args) {
        // creating objects
        Pen p1 = new Pen(); // created a pen called p1 as an object
        p1.setColor("Blue");
        System.out.println(p1.color);
        p1.setTip(5);
        System.out.println(p1.tip);
        p1.color = "yellow";
    }
}

// only one class can be puclic and it should be on top of all
class Pen {
    String color;
    int tip;

    void setColor(String newColor) {
        color = newColor;
    }

    void setTip(int newTip) {
        tip = newTip;
    }
}

class Student {
    String name;
    int age;
    float percentage; // cgpa

    void calcPercentage(int phy, int chem, int mth) {
        percentage = (phy + chem + mth) / 3;
    }
}