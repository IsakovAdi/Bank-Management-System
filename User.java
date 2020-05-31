package FinalBankProject;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {

    private int id;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private List<Account> accountList;
    private static User logedUser;

    public User() {
    }

    public User(int id, String firstName, String lastName, String login, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.accountList = new ArrayList<>();
    }

    public static void setLogedUser(User logedUser) {
        User.logedUser = logedUser;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }


    public static void seeInfo() {
        System.out.println("currency is: " + logedUser.getAccountList().get(0).getName() + " | Balance is: " + (int) logedUser.getAccountList().get(0).getBalance() + " | ID: " + logedUser.getAccountList().get(0).getId() + " | Holder is: " + logedUser.getAccountList().get(0).getAccountHolder().getFirstName() + " " + logedUser.getAccountList().get(0).getAccountHolder().getLastName());
        System.out.println("currency is: " + logedUser.getAccountList().get(1).getName() + " | Balance is: " + (int) logedUser.getAccountList().get(1).getBalance() + " | ID: " + logedUser.getAccountList().get(1).getId() + " | Holder is: " + logedUser.getAccountList().get(1).getAccountHolder().getFirstName() + " " + logedUser.getAccountList().get(1).getAccountHolder().getLastName());
    }

    public static void changeFirstName(Scanner scanner){
        String oldUserName = logedUser.getFirstName();
        System.out.println("Your name is: "+logedUser.getFirstName());
        System.out.println("Please, enter your new name");
        String userName = scanner.next();
        logedUser.setFirstName(userName);
        System.out.println("You changed your name from <<"+ oldUserName+ ">> to <<" + userName+ ">>");
    }

    public static void changeLastName(Scanner scanner){
        String oldUserName = logedUser.getLastName();
        System.out.println("Your last name is: "+logedUser.getLastName());
        System.out.println("Please, enter your new last name");
        String userName = scanner.next();
        logedUser.setLastName(userName);
        System.out.println("You changed your last name from <<"+ oldUserName+ ">> to <<" + userName+ ">>");
    }

    public static void changeLogin(Bank bank, Scanner scanner){
        List<User> userList = bank.getCustomers();
        String oldUserLogin = logedUser.getLogin();
        System.out.println("Your login is: "+logedUser.getLogin());
        System.out.println("Please, enter your new login");
        String userLogin = scanner.next();
        for (User u: userList) {
            if (userLogin.equals(u.getLogin())){
                System.out.println("Such login is already exists");
                GetInfo.signInMenu(bank, scanner);
            }
            else {

                logedUser.setLogin(userLogin);
                System.out.println("You changed your login from <<"+ oldUserLogin+ ">> to <<" + userLogin+ ">>");
            }
        }

    }

    public static void changePassword(Bank bank, Scanner scanner){
        String oldUserPassword = logedUser.getPassword();
        System.out.println("Your password is: "+logedUser.getPassword());
        System.out.println("Please, enter your new password");
        String userPassword = scanner.next();
        System.out.println("Please confirm your new password");
        String userPassword1 = scanner.next();
        if (userPassword1.equals(userPassword)) {
            logedUser.setPassword(userPassword);
            System.out.println("You changed your password from <<" + oldUserPassword + ">> to <<" + userPassword + ">>");
        }
        else {
            System.out.println("Incorrect date");
            GetInfo.signInMenu(bank, scanner);
        }
    }



    public static void authorization(Bank bank, Scanner scanner) {
        int counter = 0;
        String userLogin;
        System.out.println("Please, enter your login");
        userLogin = scanner.next();
        while (counter <= 2) {
            if (userLogin.isEmpty()) {
                System.out.println("You entered nothing, please enter your login");
                userLogin = scanner.next();
                counter++;
                if (counter == 2) {
                    System.out.println("You entered empty line 3 times, program is closing...");
                    System.exit(0);
                }
            } else {

                System.out.println("Please, enter your password");
                String userPassword = scanner.next();
                counter = 0;
                while (counter <= 2) {
                    if (userPassword.isEmpty()) {
                        System.out.println("You entered empty line, please enter your password");
                        userPassword = scanner.next();
                        counter++;
                        if (counter == 2) {
                            System.out.println("You entered nothing 3 times, program is closing...");
                            System.exit(0);
                        }
                    } else {
                        User user = getUser(bank, userLogin, userPassword);
                        for (User u : bank.getCustomers()) {
                            if (u == user) {
                                System.out.println("Welcome " + u.getFirstName() + " " + u.getLastName());
                                User.setLogedUser(u);
                                GetInfo.signInMenu(bank, scanner);
                            } else {
                                System.out.println("incorrect");
                                GetInfo.mainMenu(bank, scanner);
                            }
                        }
                    }
                }
            }
        }
    }


    public static User getUser(Bank bank, String login, String password) {
        List<User> userList = bank.getCustomers();
        User user = new User();
        for (User u : userList) {
            if (u.getLogin().equals(login) && u.getPassword().equals(password)) {
                user = u;
            }
        }
        return user;
    }

    public static void refillSom(Bank bank, Scanner scanner) {
        Account account = logedUser.getAccountList().get(0);
        System.out.println("How much do you want to replenish");
        int debt = scanner.nextInt();
        int counter = 0;
        while (counter <= 2) {
            if (debt > 0) {
                account.refill(debt);
                GetInfo.signInMenu(bank, scanner);
            } else {
                System.out.println("Please enter correct dates");
                counter++;
                debt = scanner.nextInt();
                if (counter == 2) {
                    System.out.println("You entered incorrect date three times");
                    GetInfo.signInMenu(bank, scanner);
                }
            }
        }
    }

    public static void refilUSD(Bank bank, Scanner scanner) {
        Account account = logedUser.getAccountList().get(1);
        System.out.println("How much do you want to replenish");
        int debt = scanner.nextInt();
        int counter = 0;
        while (counter <= 2) {
            if (debt > 0) {
                account.refill(debt);
                GetInfo.signInMenu(bank, scanner);
            } else {
                System.out.println("Please enter correct dates");
                counter++;
                debt = scanner.nextInt();
                if (counter == 2) {
                    System.out.println("You entered incorrect date three times");
                    GetInfo.signInMenu(bank, scanner);
                }
            }
        }
    }

    public static void withdrawKGS(Bank bank, Scanner scanner) {
        Account account = logedUser.getAccountList().get(0);
        System.out.println("How much do you want to replenish");
        int debt = scanner.nextInt();
        int counter = 0;
        while (counter <= 2) {
            if (debt > 0) {
                account.withdrawal(debt);
                GetInfo.signInMenu(bank, scanner);
            } else {
                System.out.println("Please enter correct dates");
                counter++;
                debt = scanner.nextInt();
                if (counter == 2) {
                    System.out.println("You entered incorrect date three times");
                    GetInfo.signInMenu(bank, scanner);
                }
            }
        }
    }

    public static void withdrawUSD(Bank bank, Scanner scanner) {
        Account account = logedUser.getAccountList().get(1);
        System.out.println("How much do you want to replenish");
        int debt = scanner.nextInt();
        int counter = 0;
        while (counter <= 2) {
            if (debt > 0) {
                account.withdrawal(debt);
                GetInfo.signInMenu(bank, scanner);
            } else {
                System.out.println("Please enter correct dates");
                counter++;
                debt = scanner.nextInt();
                if (counter == 2) {
                    System.out.println("You entered incorrect date three times");
                    GetInfo.signInMenu(bank, scanner);
                }
            }
        }
    }

    public static void transfer(Bank bank, Scanner scanner) {
        Account accountKGS = logedUser.getAccountList().get(0);
        Account accountUSD = logedUser.getAccountList().get(1);
        List<User> userList = bank.getCustomers();
        for (User u : userList) {
            System.out.println("ID: " + u.getId() + " | Name: " + u.getFirstName());
        }
        System.out.println("Enter the ID of User");
        int userID = scanner.nextInt();
        for (User u : userList) {
            if (userID == u.getId()) {
                System.out.println("Please, enter the ID of account");
                System.out.println("KGS ID is: " + u.getAccountList().get(0).getId());
                System.out.println("USD ID is: " + u.getAccountList().get(1).getId());
                userID = scanner.nextInt();
                if (userID == (u.getAccountList().get(0).getId()) || userID == (u.getAccountList().get(1).getId())) {
                    System.out.println("How much would you like to transfer?");
                    int debt = scanner.nextInt();
                    if (userID == (u.getAccountList().get(0).getId())) {
                        accountKGS.transferMines(debt);
                        u.getAccountList().get(0).transferPlus(debt);
                    } else {
                        accountUSD.transferMines(debt);
                        u.getAccountList().get(1).transferPlus(debt);
                    }

                } else {
                    System.out.println("Incorrect date");
                    GetInfo.signInMenu(bank, scanner);
                }
            } else {
                System.out.println("incorrect date...");
                GetInfo.signInMenu(bank, scanner);
            }
        }
    }


}
