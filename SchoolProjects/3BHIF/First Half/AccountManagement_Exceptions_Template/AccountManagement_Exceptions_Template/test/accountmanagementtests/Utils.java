package accountmanagementtests;

import accountmanagement.Account;
import accountmanagement.YouthAccount;


/**
 * Hilfsklasse für Testdaten
 * @author java@htl-leonding
 */
public class Utils {

    public static Account[] getAccounts() {
        Account[] accounts = new Account[]{
            new Account(4711),
            new Account(815),
            new Account(42),
            new Account(47),
            new YouthAccount(11, 16)
        };

        accounts[0].depositMoney(75.0);
        accounts[0].setInterestRate(0.25);

        accounts[1].depositMoney(700.25);
        accounts[1].setInterestRate(0.75);

        accounts[2].depositMoney(7238.0);
        accounts[2].setInterestRate(1.49);

        accounts[3].depositMoney(325.0);
        accounts[3].setInterestRate(0.03);

        accounts[4].depositMoney(321);
        accounts[4].setInterestRate(0.98);

        return accounts;
    }

    public static YouthAccount[] getYouthAccounts() {
        YouthAccount[] accounts = new YouthAccount[]{
            new YouthAccount(4711, 0.25, 14),
            new YouthAccount(815, 0.75, 16),
            new YouthAccount(42, 1.49, 14),
            new YouthAccount(47, 0.03, 21),
            new YouthAccount(11, 0.98, 16)
        };

        accounts[0].depositMoney(75.0);
        accounts[1].depositMoney(700.25);
        accounts[2].depositMoney(7238.0);
        accounts[3].depositMoney(325.0);
        accounts[4].depositMoney(321);


        return accounts;
    }
}
