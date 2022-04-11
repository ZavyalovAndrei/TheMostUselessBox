public class User extends Thread {
    private final int delay;
    private final int attempts;

    public User(int delay, int attempts) {
        this.delay = delay;
        this.attempts = attempts;
    }

    @Override
    public void run() {
        int attemptNumber = 1;
        try {
            while (attemptNumber <= attempts) {
                if (!Main.isToggleSwitch()) {
                    Thread.sleep(delay);
                    Main.setToggleSwitch(true);
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