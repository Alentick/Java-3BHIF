package accountmanagement;

/**
 * Jugendsparbuch ist ein spezielles Sparbuch, dem bei
 * Eröffnung 20 Euro gutgeschrieben werden
 * @author java@htl-leonding
 */
public class YouthAccount extends  Account {
    private int age;

    /**
     * Überladener Konstruktor mit neuem Parameter age
     * @param accountNumber
     * @param age
     */
    public YouthAccount(int accountNumber, int age)  {
        this(accountNumber,DEFAULT_INTEREST_RATE,age);
    }

    /**
     * Alle Angaben im Konstruktor
     * @param accountNumber
     * @param interestRate
     * @param age
     */
    public YouthAccount(int accountNumber, double interestRate, int age)  {
        super(accountNumber,interestRate);
        this.age = age;
        if(age<=18){
            this.setAmount(20);
        }
    }


    public int getAge() {
        return age;
    }
    
    /**
     *  Kontostand ausgeben
     * @return 
     */
    @Override
    public String toString()
    {
        return "Youthaccount: " + super.toString();
    }

}
