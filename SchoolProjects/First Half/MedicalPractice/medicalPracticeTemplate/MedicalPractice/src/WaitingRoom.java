

import java.util.*;

/**
 *
 * @author java@htl-leonding
 */
public class WaitingRoom {

    private final PriorityQueue<Patient> waitingQueue = new PriorityQueue<Patient>();
    
    public static void main(String[] args) {
        
        System.out.printf("\n");
        WaitingRoom wr = new WaitingRoom();
        Calendar c = Calendar.getInstance(Locale.GERMANY);
        c.set(2011, Calendar.OCTOBER, 21, 9, 15);
        wr.comesIn(new Patient("Antonia Adam", c.getTime(), false));
        c.set(2011, Calendar.OCTOBER, 21, 9, 30);
        wr.comesIn(new Patient("Bert Bauer", c.getTime(), false));
        wr.comesIn(new Patient("anonym", new Date(), true));
        c.set(2011, Calendar.OCTOBER, 21, 8, 30);
        wr.comesIn(new Patient("Cäcilia Chlum", c.getTime(), false));
        System.out.printf("Warteschlange: \n%s", wr.toString());
        Patient pat = wr.getNextPatient();
        String text = "Nächster Patient: " + pat.toString()+"\n";
        System.out.printf(text);
    }

    public void comesIn(Patient patient) {
        if(waitingQueue.peek() == null || patient.compareTo(waitingQueue.peek()) == -1)
        waitingQueue.offer(patient);
        
        else if(patient.compareTo(waitingQueue.peek()) == 1){
            waitingQueue.offer(patient);
        }
        else
            waitingQueue.offer(patient);
    }

    public Patient getNextPatient() {
        return waitingQueue.poll();
        
    }

}
