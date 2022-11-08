public class hierarichal {
    public static void main(String args[]){
        Bird dobby1=new Bird();
        dobby1.eat();
//        dobby1.legs=4;
//        System.out.println(dobby1.legs);
        dobby1.breathe();
        dobby1.fly();

    }
}
//base class
class Animal2{
    String color;
    void eat(){
        System.out.println("eats");
    }
    void breathe(){
        System.out.println("breathes");
    }
}
//derived class / subclass
class Mammal1 extends Animal2 {
   void walk(){
       System.out.println("walks");
   }
}class Fish1 extends Animal2 {
   void swim(){
       System.out.println("swim");
   }
}class Bird extends Animal2 {
   void fly(){
       System.out.println("fly");
   }
}

