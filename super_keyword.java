public class super_keyword{
    public static void main(String args[]){
        Horse1 h=new Horse1();
        System.out.println(h.color);
    }

}
class Animal5{
    String color;
    Animal5(){
        System.out.println("animal constructor is called");
    }
}
class Horse1 extends Animal5{
    Horse1(){
        super.color="brown";
        System.out.println("horse constructor is called");
    }
}