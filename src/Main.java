import java.util.concurrent.atomic.AtomicBoolean;

public class Main {

    private static final int USER_ATTEMPT_DELAY = 2000;
    private static final int BOX_SWITCH_DELAY = 100;
    private static final int ATTEMPTS = 6;


    public static void main(String[] args) throws InterruptedException {
        AtomicBoolean toggleSwitch = new AtomicBoolean(false);
        Box box = new Box(BOX_SWITCH_DELAY, toggleSwitch);
        User user = new User(USER_ATTEMPT_DELAY, ATTEMPTS, toggleSwitch);
        box.start();
        user.start();
        while (true) {
            if (user.isInterrupted()) {
                box.interrupt();
                break;
            }
        }

    }
}
