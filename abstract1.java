public class abstract1{
    public static void main(String args[]){
//        Horse h=new Horse();
//        h.eat();
//        h.walk();
//        System.out.println(h.color);
//        Chicken c=new Chicken();
//        c.eat();
//        c.walk();
    Mustang myHorse=new Mustang();
        // Animal4 a =new Animal4(); can't create object of abstract class
    }

}
abstract class Animal4{
    Animal4(){
        System.out.println("animal constructor called");
    }
   String color;
//    Animal4(){
//        color="brown";
//    }
    void eat(){
        System.out.println("animal eats");
    }
    abstract void walk();
}
class Horse extends Animal4{
    Horse(){
        System.out.println("horse constructor called");
    }
    void changeColor(){
        color="dark brown";
    }
    void walk(){
        System.out.println("walks on 4 legs");
    }
}
class Mustang extends Horse{
    Mustang(){
        System.out.println("Mustang constructor called");
    }
}
class Chicken extends Animal4{
    void walk(){
        System.out.println("walks on 2 legs");
    }
}