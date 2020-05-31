package FinalBankProject;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private String bankName;
    private List<User> customers;
    private List<Account> accounts;

    public Bank() {}

    public Bank(String bankName, List<User> customers, List<Account> accounts) {
        this.bankName = bankName;
        this.customers = customers;
        this.accounts = accounts;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public List<User> getCustomers() {
        return customers;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    private static ArrayList<Integer> ids = new ArrayList<>();

    /**
     * происходит генерация нового уникального id
     * @return возвращает новую id
     */
    public static int genUniqueId(){
        int id = 0;
        while (true) {
            id = 100000+(int)(Math.random()*999999);
            if (checkForDuplicates(id)) {
                ids.add(id);
                break;
            }
        }
        return id;
    }

    /**
     * происходит проверка нового id на отсутствие дубликата
     * @param id новое сгенерированное id которую мы проверяем на уникальность
     * @return false если дубликат найден
     * @return true если дубликата нет
     */
    public static boolean checkForDuplicates(int id){
        for (int i:ids) {
            if (i == id){
                return false;
            }
        }
        return true;
    }
}
