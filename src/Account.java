import java.util.ArrayList;

public class Account {

    private String accNum;
    private String accOwner;
    private double balance;

    private static int initialValue = 1000;

    ArrayList<String> transactionHistory = new ArrayList<>();

    public Account(String accOwner,double initialDeposit){
        this.accOwner = accOwner;
        this.balance = initialDeposit;
        this.accNum = "ACC" + (++initialValue);
    }

    public void deposit(double amount){
        if (amount > 0){
            balance += amount;
            transactionHistory.add("Deposited: " + amount + " | Balance: " + balance);
        }
    }

    public void withdraw(double amount){
        if (balance > amount){
            balance -= amount;
            transactionHistory.add("Withdraw: " + amount + " | Balance: " + balance);
        }
    }

    public void display(){
        System.out.println(accOwner + " | " + accNum + " | " + getBalance());
    }

    public String getAccNum() {
        return accNum;
    }

    public String getAccOwner() {
        return accOwner;
    }

    public double getBalance() {
        return balance;
    }
}
