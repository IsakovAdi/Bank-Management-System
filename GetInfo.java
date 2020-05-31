package FinalBankProject;
import java.util.Scanner;

public class GetInfo {

    public static void mainMenu(Bank bank, Scanner scanner) {
        while (true) {
            System.out.println("Please choose an option");
            System.out.println("1. log in");
            System.out.println("2. Exit...");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    User.authorization(bank, scanner);
                case 2:

                    System.out.println("Quitting...");
                    System.exit(0);
            }
        }
    }

    public static void signInMenu(Bank bank, Scanner scanner){
        while (true) {
            System.out.println("You are in the main menu");
            System.out.println("1. See information");
            System.out.println("2. Finance");
            System.out.println("3. See the transactions");
            System.out.println("4. Settings");
            System.out.println("5. Log out");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    User.seeInfo();
                    signInMenu(bank, scanner);
                case 2:
                    System.out.println("1. Refill");
                    System.out.println("2. Withdrawal from account");
                    System.out.println("3. Make a transfer to another account");
                    choice = scanner.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println("Which account would you like to refill?");
                            System.out.println("1. KGS");
                            System.out.println("2. USD");
                            choice = scanner.nextInt();
                            switch (choice) {
                                case 1:
                                    User.refillSom(bank, scanner);
                                    signInMenu(bank, scanner);
                                case 2:
                                    User.refilUSD(bank, scanner);
                                    signInMenu(bank, scanner);
                            }
                        case 2:
                            System.out.println("Which account would you like to withdraw from?");
                            System.out.println("1. KGS");
                            System.out.println("2. USD");
                            choice = scanner.nextInt();
                            switch (choice) {
                                case 1:
                                    User.withdrawKGS(bank, scanner);
                                    signInMenu(bank, scanner);
                                case 2:
                                    User.withdrawUSD(bank, scanner);
                                    signInMenu(bank, scanner);
                            }
                        case 3:
                            User.transfer(bank, scanner);
                            signInMenu(bank, scanner);
                    }

                case 3:
                        signInMenu(bank, scanner);
                case 4:

                    System.out.println("1. Change first name");
                    System.out.println("2. Change last name");
                    System.out.println("3. Change login");
                    System.out.println("4. Change password");
                    System.out.println("5. Main menu");
                    choice = scanner.nextInt();
                    switch (choice) {
                        case 1:
                            User.changeFirstName(scanner);
                            signInMenu(bank, scanner);
                        case 2:
                            User.changeLastName(scanner);
                            signInMenu(bank, scanner);
                        case 3:
                            User.changeLogin(bank, scanner);
                            signInMenu(bank, scanner);
                        case 4:
                            User.changePassword(bank, scanner);
                            signInMenu(bank, scanner);
                        case 5:
                            signInMenu(bank, scanner);
                    }
                case 5:
                    mainMenu(bank, scanner);
                    break;
            }
        }
    }
}
