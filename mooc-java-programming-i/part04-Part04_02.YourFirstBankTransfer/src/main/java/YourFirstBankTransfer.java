
public class YourFirstBankTransfer {

    public static void main(String[] args) {
        // Do not touch the code in Account.java
        // write your program here
        Account matAccount = new Account("Matthews account",1000.0);
        Account myAccount = new Account("My account",0.0);
        matAccount.withdrawal(100.0);
        myAccount.deposit(100.0);
        System.out.println(matAccount);
        System.out.println(myAccount);  
    }
}
