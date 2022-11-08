public class interfaces{
    public static void main(String args[]){
     Queen q=new Queen();
     q.moves();
    }
}
interface ChessPlayer{
    void moves();
}
interface Herbivore{

}
interface Carnivore{

}
class Bear implements Herbivore,Carnivore{

}
class Queen implements ChessPlayer{

    public void moves() {
        System.out.println("up down left right diagonal (in all 4dirns)");
    }
}
class Rook implements ChessPlayer{
    public void moves(){
        System.out.println("up down left right");
    }
}
class King implements ChessPlayer{
    public void moves(){
        System.out.println("up down left right diagonal-(by 1 step)");
    }
}
