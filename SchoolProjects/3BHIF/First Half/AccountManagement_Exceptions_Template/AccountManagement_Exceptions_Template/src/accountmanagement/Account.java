package accountmanagement;


/**
 * Basisklasse für alle Sparkonten
 *
 * @author java@htl-leonding
 */
public class Account implements Comparable<Account>{

    private int accountNumber;
    private double amount;          // aktueller Kontostand
    private double interestRate;    // Zinssatz
    private double maxOverdrawing;  // maximaler Überziehungsrahmen

    final static double DEFAULT_OVERDRAWING = -1000;     // Standardüberziehungsrahmen
    static final double DEFAULT_INTEREST_RATE = 1.5;    // Standardzinsen

    /**
     * Konstruktor, mit dem ein Sparkonto angelegt wird
     * @param accountNumber
     */
    public Account(int accountNumber)  {
        this.accountNumber = accountNumber;
    }

    /**
     * Weiterer Konstruktor, bei dem auch der Zinssatz angegeben wird
     * @param accountNumber
     * @param interestRate
     */
    public Account(int accountNumber, double interestRate)  {
        this.accountNumber = accountNumber;
        this.interestRate = interestRate;
    }

    /**
     * Weiterer Konstruktor, bei dem auch der Zinssatz angegeben wird
     * @param accountNumber
     * @param interestRate
     * @param maxOverdrawing
     */
    public Account(int accountNumber, double interestRate, double maxOverdrawing)  {
        this.accountNumber = accountNumber;
        this.interestRate = interestRate;
        this.maxOverdrawing = maxOverdrawing;
    }
    /**
     * Einzahlung abwickeln
     * @param payment  Betrag der eingezahlt wird
     */
    public void depositMoney(double payment)  {
        if(payment < 0){
            throw new IllegalArgumentException();
        }
        this.amount += payment;
    }
    
    /**
     * Abhebung vom Sparkonto
     * @param value Betrag der abgehoben wurde
     * @return Ging die Abhebung gut
     */
    public boolean withdrawMoney(double value) {
         if(value < 0){
             throw new IllegalArgumentException();
         }
         else if(amount - value < -maxOverdrawing){
             return false;
         }
         amount -= value;
         return true;
    }

    /**
     * Aktuellen Kontostand auslesen
     * @return Kontostand
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Aktuelle Zinsen auslesen
     * @return Zisnsatz
     */
    public double getInterestRate() {
        return interestRate;
    }

    /**
     * Zinssatz setzen
     * @param interestRate
     */
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    protected void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Kontonummer auslesen
     * @return
     */
    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * Überziehungsrahmen lesen
     * @return
     */
    public double getMaxOverdrawing() {
        return maxOverdrawing;
    }

    /**
     * Überziehungsrahmen setzen
     * @param maxOverdrawing
     */
    public void setMaxOverdrawing(double maxOverdrawing) {
        this.maxOverdrawing = maxOverdrawing;
    }


    @Override
    public int compareTo(Account other) {
        return Integer.compare(this.getAccountNumber(), other.getAccountNumber());
    }
    /**
     * Ausgabe der Kontodaten
     * @return Text für das Konto mit aktuellem Kontostand
     */
    @Override
    public String toString() {
        return "Account{" + "accountNumber=" + accountNumber + ", amount=" + amount + '}';
    }
}
