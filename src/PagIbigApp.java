public class PagIbigApp {
    public static void main(String[] args) {
        System.out.println("=== Pag-IBIG Centralized Queuing System ===\n");

        // Initialize Help Desk Stations
        HelpDeskStation station1 = new HelpDeskStation("Help Desk Station 1");
        HelpDeskStation station2 = new HelpDeskStation("Help Desk Station 2");
        HelpDeskStation station3 = new HelpDeskStation("Help Desk Station 3");

        // Initialize Online Monitoring System
        OnlineMonitoringSystem monitor = new OnlineMonitoringSystem();

        // Initial status
        monitor.displayCurrentQueue();
        System.out.println();

        // Stations serving customers sequentially from the centralized queue
        station1.serveNextCustomer();
        station2.serveNextCustomer();
        station3.serveNextCustomer();
        System.out.println();

        // Online monitoring shows real-time queue number
        monitor.displayCurrentQueue();
        System.out.println();

        station1.serveNextCustomer();
        monitor.displayCurrentQueue();
        System.out.println();

        // Help Desk Station 2 resets the queue due to reorganization / technical issue
        station2.resetQueue(50);
        monitor.displayCurrentQueue();
        System.out.println();

        // Subsequent queue operations continue from the reset number
        station3.serveNextCustomer();
        station1.serveNextCustomer();
        System.out.println();

        monitor.displayCurrentQueue();

        // Self-check: verify Singleton guarantee
        QueuingSystem qs1 = QueuingSystem.getInstance();
        QueuingSystem qs2 = QueuingSystem.getInstance();
        if (qs1 != qs2) {
            throw new AssertionError("Singleton pattern violation: multiple instances detected!");
        }
        System.out.println("\n[Verification] Singleton instance integrity verified successfully.");
    }
}
