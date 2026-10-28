public class QueuingSystem {
    private static QueuingSystem instance;
    private int currentQueueNumber;

    private QueuingSystem() {
        this.currentQueueNumber = 0;
    }

    public static synchronized QueuingSystem getInstance() {
        if (instance == null) {
            instance = new QueuingSystem();
        }
        return instance;
    }

    public synchronized int getNextQueueNumber() {
        return ++currentQueueNumber;
    }

    public synchronized int getCurrentQueueNumber() {
        return currentQueueNumber;
    }

    public synchronized void resetQueueNumber(int newNumber) {
        this.currentQueueNumber = newNumber;
    }
}
