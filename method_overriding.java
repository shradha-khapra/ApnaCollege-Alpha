class method_overriding{
    public static void main(String args[]){
        Deer d=new Deer();
        d.eat();
    }

}
class Animal3 {
    void eat(){
        System.out.println("eats anything");
    }
}
class Deer extends Animal{
    void eat(){
        System.out.println("eats grass");
    }
}