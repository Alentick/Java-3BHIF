package accountmanagement;


import java.util.Comparator;

/**
 * Comparator für das Alter des Kontobesitzers
 *  vergleicht zwei Jugendkonten nach dem Alter und bei gleichem
 * Alter nach der Kontonummer (beides aufsteigend)
 * @author java@htl-leonding
 */
public class YouthAccountAgeComparator implements Comparator<YouthAccount> {

    @Override
    public int compare(YouthAccount account1, YouthAccount account2) {
        if(Integer.compare(account1.getAge(), account2.getAge()) == 0){
            return Integer.compare(account1.getAccountNumber(), account2.getAccountNumber());
        }
        else{
            return Integer.compare(account1.getAge(), account2.getAge());
        }
    }
}
