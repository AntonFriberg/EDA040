package lift;

/**
 * Created by Anton Friberg on 02/10/16.
 */
public class PersonThread implements Runnable{

    private LiftMonitor lm;

    public PersonThread(LiftMonitor lm) {
        this.lm = lm;
    }


    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep((int) (1000 * Math.random() * 46));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int start = (int) (Math.random() * 7); // random starting floor
            int destination = ((start + 1 ) + (int) (Math.random() * 5)) % 7; // random end floor different from start
            lm.ride(start, destination);
        }
    }
}
