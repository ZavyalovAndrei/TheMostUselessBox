import java.util.concurrent.atomic.AtomicBoolean;

public class User extends Thread {
    private final int DELAY;
    private final int ATTEMPTS;
    private static AtomicBoolean TOGGLE_SWITCH;

    public User(int delay, int attempts, AtomicBoolean toggleSwitch) {
        this.DELAY = delay;
        this.ATTEMPTS = attempts;
        this.TOGGLE_SWITCH = toggleSwitch;
    }

    @Override
    public void run() {
        int attemptNumber = 1;
        try {
            while (attemptNumber <= ATTEMPTS) {
                if (!TOGGLE_SWITCH.get()) {
                    Thread.sleep(DELAY);
                    TOGGLE_SWITCH.lazySet(true);
                    System.out.println("Попытка №" + attemptNumber + " Пользователь включил тумблер.");
                    attemptNumber++;
                }
            }
        } catch (InterruptedException err) {
            return;
        } finally {
            System.out.println("Пользователь больше не хочет играть с игрушкой.");
            interrupt();
        }
    }
}