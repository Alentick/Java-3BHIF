package accountmanagementtests;


import accountmanagement.Account;
import accountmanagement.AccountAmountComparator;
import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author java@htl-leonding
 */
public class AccountTest {

    /**
     * Test of zahleEin method, of class Account.
     */
    @Test
    public void testDepositMoney_CorrectValue_ShouldReturnCorrectAmount() {
        Account myAccountBook = new Account(4711);
        myAccountBook.depositMoney(100);
        assertEquals(100, myAccountBook.getAmount(), 0.1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDepositMoney_NegativeValue_ShouldThrowException() {
        Account myAccountBook = new Account(4711);
        myAccountBook.depositMoney(-100);
    }

    @Test
    public void testSetOverdrawing_overdrawMax_ShouldBeOk() {
        Account account = new Account(1, 4.5);
        account.setMaxOverdrawing(100);
        assertTrue(account.withdrawMoney(100));
        assertEquals(-100, account.getAmount(), 0.01);
    }

    @Test
    public void testSetOverdrawing_overdrawTooMuch_ShouldNotBeOk() {
        Account account = new Account(1, 4.5);
        account.setMaxOverdrawing(100);
        assertFalse(account.withdrawMoney(100.1));
        assertEquals(0, account.getAmount(), 0.01);
    }

    @Test
    public void testSortAccounts_SortUtilAccounts_ShouldReturnSortedAccounts() {
        Account[] accounts = Utils.getAccounts();
        System.out.println(" + Unsortiert");
        int[] kontoNrUnsortiert = new int[accounts.length];
        for (int i = 0; i < accounts.length; i++) {
            kontoNrUnsortiert[i] = accounts[i].getAccountNumber();
        }
        assertArrayEquals("Unsortiertes Array nicht korrekt",
                new int[]{4711, 815, 42, 47, 11},
                kontoNrUnsortiert);
        System.out.println(" + Sortiert");
        // Array sortieren
        Arrays.sort(accounts);
        // int-Zahlen aus Array auslesen (Sortierung wird beibehalten)
        int[] kontoNrSortiert = new int[accounts.length];
        for (int i = 0; i < accounts.length; i++) {
            kontoNrSortiert[i] = accounts[i].getAccountNumber();
        }
        assertArrayEquals("Sortiertes Array nicht korrekt",
                new int[]{11, 42, 47, 815, 4711},
                kontoNrSortiert);

    }

    @Test(expected = NullPointerException.class)
    public void testComparer_NullAccount_ShouldReturnException() {
        Account a = null;
        Account b = new Account(1, 0.5);
        b.compareTo(a);
    }

    @Test
    public void testComparer_firstGTsecond_ShouldReturnGT0() {
        Account first = new Account(2);
        Account second = new Account(1, 0.5);
        assertTrue(first.compareTo(second)>0);
    }

    @Test
    public void testComparer_firstLTsecond_ShouldReturnLT0() {
        Account first = new Account(1);
        Account second = new Account(2, 0.5);
        assertTrue(first.compareTo(second)<0);
    }

    @Test
    public void testComparer_AmountComparer_AccountsShouldBeSortedByAmount() {
        Account[] accounts = Utils.getAccounts();
        // nach Betrag sortieren
        Arrays.sort(accounts, new AccountAmountComparator());
        double[] accountsSortedByAmount = new double[accounts.length];
        for (int i = 0; i < accounts.length; i++) {
            accountsSortedByAmount[i] = accounts[i].getAmount();
        }
        // ACHTUNG: Beim Jugendkonto gibt's 20 extra --> 341 Euro
        double[] amountExpected = new double[]{75.0, 321.0, 325.0, 700.25, 7238.0};
        for (int i = 0; i < amountExpected.length; i++) {
            assertEquals("Sortierung nach Betrag falsch", amountExpected[i], accountsSortedByAmount[i], 0.01);
        }
    }
}

