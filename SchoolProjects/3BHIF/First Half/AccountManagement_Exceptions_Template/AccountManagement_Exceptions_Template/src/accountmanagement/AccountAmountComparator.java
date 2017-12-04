package accountmanagement;


import java.util.Comparator;

/**
 * Comparator für den Betrag (Saldo) des Kontos
 * @author java@htl-leonding
 */
public class AccountAmountComparator implements Comparator<Account> {

    @Override
    public int compare(Account account1, Account account2) {
        return (int) (account1.getAmount() - account2.getAmount());
    }
}
