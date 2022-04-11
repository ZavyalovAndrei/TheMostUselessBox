public class Main {

    private static final int USER_ATTEMPT_DELAY = 2000;
    private static final int BOX_SWITCH_DELAY = 100;
    private static final int ATTEMPTS = 6;
    private static volatile boolean toggleSwitch = false;

    public static boolean isToggleSwitch() {
        return toggleSwitch;
    }

    public static void setToggleSwitch(boolean toggleSwitch) {
        Main.toggleSwitch = toggleSwitch;
    }

    public static void main(String[] args) {
        User user = new User(USER_ATTEMPT_DELAY, ATTEMPTS);
        Box box = new Box(BOX_SWITCH_DELAY);
        box.setDaemon(true);
        box.start();
        user.start();
//        while (true) {
//            if (user.isInterrupted()) {
//                box.interrupt();
//                break;
//            }
//        }
    }
}
