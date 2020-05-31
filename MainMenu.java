package FinalBankProject;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {


        User adilet = new User(Bank.genUniqueId(),"Adilet", "Isakov", "Adi","1994");
        Account kgs = new Account(Bank.genUniqueId(), 1000, "som", adilet);
        Account USD = new Account(Bank.genUniqueId(),200, "USD", adilet);
        List<Account> adiletAccount = new ArrayList<>();
        adiletAccount.add(kgs);
        adiletAccount.add(USD);
        adilet.setAccountList(adiletAccount);

        User aza = new User(Bank.genUniqueId(),"Azamat", "Baimatov","aza", "1993");
        Account kgs1 = new Account(Bank.genUniqueId(), 2000,"KGS", aza);
        Account USD1 = new Account(Bank.genUniqueId(), 1232, "USD", aza);
        List<Account> azaAccount = new ArrayList<>();
        azaAccount.add(kgs1);
        azaAccount.add(USD1);
        aza.setAccountList(azaAccount);

        User aiba = new User(Bank.genUniqueId(),"Aibek", "Akmatov","aiba", "1992");
        Account kgsAiba = new Account(Bank.genUniqueId(), 3000,"KGS", aiba);
        Account USDAiba = new Account(Bank.genUniqueId(), 300, "USD", aiba);
        List<Account> aibaAccount = new ArrayList<>();
        aibaAccount.add(kgsAiba);
        aibaAccount.add(USDAiba);
        aiba.setAccountList(aibaAccount);

        List<User> userList = new ArrayList<>();
        userList.add(adilet);
        userList.add(aza);
        userList.add(aiba);
        List<Account> accountList = new ArrayList<>();
        accountList.add(kgs);
        accountList.add(kgs1);
        accountList.add(USD);
        accountList.add(USD1);
        accountList.add(kgsAiba);
        accountList.add(USDAiba);

        Bank bank = new Bank("Bank",userList, accountList);
        Scanner scanner = new Scanner(System.in);
        GetInfo.mainMenu(bank, scanner);


    }
}
