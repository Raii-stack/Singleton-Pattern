public class HelpDeskStation {
    private final String stationName;
    private final QueuingSystem queuingSystem;

    public HelpDeskStation(String stationName) {
        this.stationName = stationName;
        this.queuingSystem = QueuingSystem.getInstance();
    }

    public int serveNextCustomer() {
        int nextNumber = queuingSystem.getNextQueueNumber();
        System.out.println(stationName + " is now serving Queue No: " + nextNumber);
        return nextNumber;
    }

    public void resetQueue(int newNumber) {
        System.out.println(stationName + " requested queue reset to: " + newNumber);
        queuingSystem.resetQueueNumber(newNumber);
    }

    public String getStationName() {
        return stationName;
    }
}
