import java.util.concurrent.atomic.AtomicBoolean;

public class Box extends Thread {
    private static int DELAY;
    private static AtomicBoolean TOGGLE_SWITCH;

    public Box(int delay, AtomicBoolean toggleSwitch) {
        this.DELAY = delay;
        this.TOGGLE_SWITCH = toggleSwitch;
    }

    @Override
    public void run() {
        System.out.println("Игрушка включена.");
        try {
            while (!isInterrupted()) {
                Thread.sleep(DELAY);
                if (TOGGLE_SWITCH.get()) {
                    TOGGLE_SWITCH.lazySet(false);
                    System.out.println("Игрушка выключила тумблер.");
                }
            }
        } catch (InterruptedException err) {
            return;
        } finally {
            System.out.println("Игрушка завершает свою работу.");
        }
    }
}