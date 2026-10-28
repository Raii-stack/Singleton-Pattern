public class QueuingSystem {
    private static QueuingSystem instance;
    private int currentQueueNumber;

    // Private constructor prevents direct instantiation
    private QueuingSystem() {
        this.currentQueueNumber = 0;
    }

    // Thread-safe singleton accessor
    public static synchronized QueuingSystem getInstance() {
        if (instance == null) {
            instance = new QueuingSystem();
        }
        return instance;
    }

    // Issues the next sequential queue number
    public synchronized int getNextQueueNumber() {
        return ++currentQueueNumber;
    }

    // Returns current queue number in real-time
    public synchronized int getCurrentQueueNumber() {
        return currentQueueNumber;
    }

    // Resets queue number to an inputted value
    public synchronized void resetQueueNumber(int newNumber) {
        this.currentQueueNumber = newNumber;
    }
}
