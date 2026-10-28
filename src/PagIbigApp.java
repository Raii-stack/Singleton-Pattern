public class PagIbigApp {
    public static void main(String[] args) {
        System.out.println("=== Pag-IBIG Centralized Queuing System ===\n");

        HelpDeskStation station1 = new HelpDeskStation("Help Desk Station 1");
        HelpDeskStation station2 = new HelpDeskStation("Help Desk Station 2");
        HelpDeskStation station3 = new HelpDeskStation("Help Desk Station 3");

        OnlineMonitoringSystem monitor = new OnlineMonitoringSystem();

        monitor.displayCurrentQueue();
        System.out.println();

        station1.serveNextCustomer();
        station2.serveNextCustomer();
        station3.serveNextCustomer();
        System.out.println();

        monitor.displayCurrentQueue();
        System.out.println();

        station1.serveNextCustomer();
        monitor.displayCurrentQueue();
        System.out.println();

        station2.resetQueue(50);
        monitor.displayCurrentQueue();
        System.out.println();

        station3.serveNextCustomer();
        station1.serveNextCustomer();
        System.out.println();

        monitor.displayCurrentQueue();

        QueuingSystem qs1 = QueuingSystem.getInstance();
        QueuingSystem qs2 = QueuingSystem.getInstance();
        if (qs1 != qs2) {
            throw new AssertionError("Singleton pattern violation: multiple instances detected!");
        }
        System.out.println("\n[Verification] Singleton instance integrity verified successfully.");
    }
}
