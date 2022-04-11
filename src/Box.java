public class Box extends Thread {
    private final int delay;

    public Box(int delay) {
        this.delay = delay;
    }

    @Override
    public void run() {
        System.out.println("Игрушка включена.");
        try {
            while (!isInterrupted()) {
                Thread.sleep(delay);
                if (Main.isToggleSwitch()) {
                    Main.setToggleSwitch(false);
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