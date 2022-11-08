public class multiLevel_Inheritance {
    public static void main(String args[]){
       Dog dobby=new Dog();
       dobby.eat();
       dobby.legs=4;
        System.out.println(dobby.legs);

    }
}
//base class
class Animal1{
    String color;
    void eat(){
        System.out.println("eats");
    }
    void breathe(){
        System.out.println("breathes");
    }
}
//derived class / subclass
class Mammal extends Animal1 {
    int legs;
}
class Dog extends Mammal{
    String breed;
    }

