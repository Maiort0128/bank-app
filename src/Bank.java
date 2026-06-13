import java.util.HashMap;

public class Bank {

    HashMap<String,Account> accounts = new HashMap<>();

    public Account createAcc(String accOwner,double initialDeposit){
        String accOwnerSanit = accOwner.trim();

        if (accOwnerSanit.isEmpty()){
            throw new IllegalArgumentException("Owner name cannot be empty");
        }
        if (initialDeposit < 100){
            throw new IllegalArgumentException("Initial Deposit should be above 100 USD, You provided: $ " + initialDeposit);
        }

        Account account = new Account(accOwnerSanit,initialDeposit);
        accounts.put(account.getAccNum(),account);
        return account;
    }

    public Account findAccountByNumber(String accNum){
        Account account = accounts.get(accNum);

        if (account != null){
            return account;
        }else {
            System.out.println("No account found with Number " + accNum);
            return null;
        }

    }

    public Account findAccountByOwner(String accOwner){

        for (Account account : accounts.values()){
            if (account.getAccOwner().equals(accOwner.trim())){
                return account;
            }
        }

        System.out.println("No account found for owner: " + accOwner);
        return null;
    }

    public boolean transfer(String fromAcc,String toAcc,double amount){
        Account sender = accounts.get(fromAcc);
        Account receiver = accounts.get(toAcc);

        if (sender == null){
            System.out.println("Sender account not found");
            return false;
        }

        if (receiver == null){
            System.out.println("Receiver account not found");
            return false;
        }

        if (sender.getBalance() >= amount){
            sender.withdraw(amount);
            receiver.deposit(amount);
            sender.transactionHistory.add("Transferred: " + amount + " to " + receiver.getAccNum() + " | Balance: " + sender.getBalance());
            receiver.transactionHistory.add("Received: " + amount + " from " + sender.getAccNum() + " | Balance: " + receiver.getBalance());
            return true;
        }else {
            System.out.println("Insufficient funds");
            return false;
        }
    }

    public void listAllAccounts(){
        if (accounts.isEmpty()){
            System.out.println("No accounts found!");
            return;
        }

        for (Account account : accounts.values()){
            System.out.println(account.getAccOwner() + " | " + account.getAccNum() + " | " + account.getBalance());
        }

    }


}
