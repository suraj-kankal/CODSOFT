public class ATM {
    private BankAC userAccount;

    public ATM(BankAC account) {
        this.userAccount = account;
    }

    public void checkBalance() {
        IO.printf("Current Balance: $%.2f\n", userAccount.getBalance());
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            IO.println("Invalid deposit amount.");
        } else {
            userAccount.deposit(amount);
            IO.printf("Successfully deposited $%.2f\n", amount);
            checkBalance();
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            IO.println("Invalid withdrawal amount.");
        } else if (userAccount.withdraw(amount)) {
            IO.printf("Successfully withdrew $%.2f\n", amount);
            checkBalance();
        } else {
            IO.println("Transaction Failed: Insufficient funds.");
        }
    }
}