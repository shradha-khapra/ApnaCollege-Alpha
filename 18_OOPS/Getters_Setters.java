/**
 * Leccture 3
 * Getters and setters
 * this - refrence to same object
 */
public class Getters_Setters {
    public static void main(String[] args) {
        // creating object of Pen
        Pen p1 = new Pen(); // created a pen called p1 as an object
        p1.setColor("Blue");
        System.out.println(p1.getColor());
        p1.setTip(5);
        System.out.println(p1.getTip());
        p1.setColor("yellow");
    }
}

class Pen {
    private String color;
    private int tip;

    String getColor() {
        return this.color;
    }

    int getTip() {
        return this.tip;
    }

    void setColor(String newColor) {
        color = newColor;
    }

    void setTip(int Tip) {
        tip = this.tip;
    }
}