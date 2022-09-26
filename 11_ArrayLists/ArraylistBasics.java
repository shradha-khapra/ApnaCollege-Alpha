import java.util.ArrayList;
public class ArraylistBasics {
    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<Boolean> list3 = new ArrayList<>();

        //Add Operation
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        System.out.println(list);

        //Get Operation
        System.out.println(list.get(0));

        //Delete Operation
        list.remove(1); // 1 is index
        System.out.println(list);

        //Modify Operation
        list.set(0, 2);
        System.out.println(list);

        //Contains Operation
        System.out.println(list.contains(3));
        System.out.println(list.contains(4));

        //Size of list
        System.out.println(list.size());

        //Iteration
        for(int i=0; i<list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
    }
}