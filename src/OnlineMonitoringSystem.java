public class OnlineMonitoringSystem {
    private final QueuingSystem queuingSystem;

    public OnlineMonitoringSystem() {
        this.queuingSystem = QueuingSystem.getInstance();
    }

    public void displayCurrentQueue() {
        System.out.println("[Online Monitoring] Real-Time Current Queue Number: " + queuingSystem.getCurrentQueueNumber());
    }

    public int getCurrentQueue() {
        return queuingSystem.getCurrentQueueNumber();
    }
}
