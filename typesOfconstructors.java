public class typesOfconstructors {
    //copy constructor
    public static void main(String args[]){
        Student2 s1=new Student2();
        s1.name=("shraddha");
        s1.roll=456;
        s1.password="abcd";
        s1.marks[0]=100;
        s1.marks[1]=90;
        s1.marks[2]=80;
        //Student2 s4=new Student2("aman",567);
        Student2 s2=new Student2(s1);
        s2.password="xyz";
        for(int i=0;i<3;i++){
            System.out.println(s2.marks[i]);
        }
    }
}
class Student2{
    String name;
    int roll;
    String password;
    int marks[];
//    class Address{
//        String city;
//    }

    //shallow copy constructor
//    Student2(Student2 s1){
//        marks=new int[3];
//        this.name=s1.name;
//        this.roll=s1.roll;
//        this.marks=s1.marks;
//    }
    //deep copy constructor
    Student2(Student2 s1){
        marks=new int[3];
        this.name=s1.name;
        this.roll=s1.roll;
        for(int i=0;i<marks.length;i++){
            this.marks[i]=s1.marks[i];
        }
    }
    Student2(){
        marks=new int[3];
        System.out.println("constructor is called..");
    }
    Student2(String name){
        this.name=name;
    }
    Student2(int roll){
        this.roll=roll;
    }
}