void main() {

    Bank bank = new Bank();

    Account account = bank.createAcc("Lina",4000);
    Account account1 = bank.createAcc("Michael",9000);
    Account account2 = bank.createAcc("             Pepe",109);

    account.display();

    account.deposit(2000);

    account.display();

    account.withdraw(1500);

    account.display();

    account1.display();

    bank.transfer(account.getAccNum(),account1.getAccNum(),1000);

    account.display();
    account1.display();

    bank.listAllAccounts();

    Account found = bank.findAccountByNumber("11");

    if (found != null){
        found.display();
    }

    Account foundByName = bank.findAccountByOwner("Michal ");

    if (foundByName != null){
        foundByName.display();
    }

    account2.display();

    for (int i = 0; i < account.transactionHistory.size(); i++) {
        System.out.println(account.transactionHistory.get(i));
    }

    System.out.println();

    for (int i = 0; i < account1.transactionHistory.size(); i++) {
        System.out.println(account1.transactionHistory.get(i));
    }

}