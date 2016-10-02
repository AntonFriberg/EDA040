package lift;

import javafx.util.Pair;

/**
 * Created by Anton Friberg and Joakim Magnusson on 02/10/16.
 */
public class LiftThread implements Runnable{

    private LiftMonitor lm;
    private LiftView lv;

    public LiftThread(LiftMonitor lm, LiftView lv) {
        this.lm = lm;
        this.lv = lv;
    }

    @Override
    public void run() {
        while (true) {
            int[] floors = lm.move();
            int here = floors[0];
            int next = floors[1];
            lv.moveLift(here, next);
        }
    }
}
