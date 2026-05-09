public class FinalELC {
    public static void main(String[] args) throws java.io.IOException {
        BankAC myAccount = new BankAC(500.00);
        ATM atm = new ATM(myAccount);

        boolean quit = false;
        IO.println("Welcome to the ATM Services");

        while (!quit) {
            displayMenu();
            int choice = readInt("Choose an option: ");

            quit = switch (choice) {
                case 1 -> {
                    atm.checkBalance();
                    yield false;
                }
                case 2 -> {
                    double amount = Double.parseDouble(IO.readln("Enter amount to deposit: "));
                    atm.deposit(amount);
                    yield false;
                }
                case 3 -> {
                    double amount = Double.parseDouble(IO.readln("Enter amount to withdraw: "));
                    atm.withdraw(amount);
                    yield false;
                }
                case 4 -> {
                    IO.println("Thank you for using our ATM. Goodbye!");
                    yield true;
                }
                default -> {
                    IO.println("Invalid choice. Try again.");
                    yield false;
                }
            };
        }
    }

    private static void displayMenu() {
        IO.println("\n--- ATM MENU ---");
        IO.println("1. Check Balance");
        IO.println("2. Deposit");
        IO.println("3. Withdraw");
        IO.println("4. Exit");
    }

    private static int readInt(String prompt) throws java.io.IOException {
        while (true) {
            String input = getUserInput(prompt);
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                IO.println("Invalid choice. Please enter a whole number.");
            }
        }
    }

    private static double readDouble(String prompt) throws java.io.IOException {
        while (true) {
            String input = getUserInput(prompt);
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                IO.println("Invalid amount. Please enter a number.");
            }
        }
    }

    private static String getUserInput(String prompt) throws java.io.IOException {
        IO.print(prompt);
        java.io.Console console = System.console();
        if (console != null) {
            String line = console.readLine();
            return line == null ? "" : line;
        }
        return new java.io.BufferedReader(new java.io.InputStreamReader(System.in)).readLine();
    }
}