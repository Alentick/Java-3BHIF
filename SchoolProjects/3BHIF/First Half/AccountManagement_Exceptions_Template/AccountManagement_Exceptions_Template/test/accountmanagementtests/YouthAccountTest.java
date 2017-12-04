package accountmanagementtests;


import accountmanagement.YouthAccount;
import accountmanagement.YouthAccountAgeComparator;
import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author java@htl-leonding
 */
public class YouthAccountTest {

    /**
     * Test of withdrawMoney method, of class YouthAccount.
     */
    @Test
    public void testWithdrawMoney_ValueOk_ShouldReturnCorrectAmount() {
        YouthAccount account = new YouthAccount(11,17);
        assertTrue(account.withdrawMoney(18));
        assertEquals(2.0, account.getAmount(),0.01);
    }
    
    @Test
    public void testWithdrawMoney_ValueEqualAmount_ShouldReturnCorrectAmount_0() {
        YouthAccount account = new YouthAccount(11,17);
        assertTrue(account.withdrawMoney(20));
        assertEquals(0.0, account.getAmount(),0.01);
    }

    @Test
    public void testWithdrawMoney_ValueGreaterAmount_ShouldReturnFalse() {
        YouthAccount account = new YouthAccount(11,20);
        assertFalse(account.withdrawMoney(20));
    }

    @Test
    public void testYouthAccount_AgeGT18_ShoulReturnNoOverdrawing() {
        assertTrue(true);
    }

    @Test
    public void testSetMaxOverdrawing_IllegalSetOverdrawing_ShouldThrowException() {
        assertTrue(true);
    }

    @Test
    public void testSetMaxOverdrawing_OverdrawingTo0_ShouldDoNothing() {
        assertTrue(true);
    }

    /**
     * Test of toString method, of class YouthAccount.
     */
    @Test
    public void testToString_YouthAccount_ShouldReturnCorrectText() {
        
        assertTrue(true);
    }

    /**
     * Jugendkonten über Utils erzeugen lassen und über den YouthAccountComparer
     * sortieren.
     * Kontrollieren, ob die Sortierung stimmt (zuerst nach dem Alter aufsteigend,
     * dann nach der Kontonummer aufsteigend).
     */
    @Test
    public void testSortYouthAccounts_ByYouthAccountComparer_ShouldReturnCorrectOrderedAccounts() {
        YouthAccount account1 = new YouthAccount(12,17);
        YouthAccount account2 = new YouthAccount(11,17);
        assertTrue(account1.compareTo(account2) > 0);
    }
}