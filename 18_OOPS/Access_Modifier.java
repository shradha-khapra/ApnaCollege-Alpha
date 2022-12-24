/**
 * Lecture 2
 * Access Modifier lecture
 * Bank is a class
 */
public class Access_Modifier {
    public static void main(String[] args) {
        // creating object of BankAccount
        BankAccount myAcc = new BankAccount();
        myAcc.username = "Saksham";
        myAcc.setPassword("abcd");
    }
}

class BankAccount {
    public String username;
    private String password;

    // setter function to set password
    public void setPassword(String pwd) {
        password = pwd;
    }
}