# Centralized Queuing System for Pag-ibig Office

The Pag-ibig office implements a centralized queuing system for three help desk stations. Individuals visiting the office obtain a queue number from this centralized system. Additionally, there's an online monitoring system that displays the current queued number in real-time for individuals monitoring the queue remotely.

Each help desk station has an option to reset the queuing number based on an inputted number, allowing flexibility in managing the queue during specific situations, such as reorganization or technical issues. This queuing system ensures a single centralized queue number for all help desk stations, while the reset option offers control and adjustment in exceptional circumstances.

This approach aims to maintain an organized queuing process for individuals visiting the office and provides the flexibility to handle queue adjustments as needed.

## UML Class Diagram

```mermaid
classDiagram
    class QueuingSystem {
        -QueuingSystem instance$
        -int currentQueueNumber
        -QueuingSystem()
        +getInstance() QueuingSystem$
        +getNextQueueNumber() int
        +getCurrentQueueNumber() int
        +resetQueueNumber(int newNumber) void
    }

    class HelpDeskStation {
        -String stationName
        -QueuingSystem queuingSystem
        +HelpDeskStation(String stationName)
        +serveNextCustomer() int
        +resetQueue(int newNumber) void
        +getStationName() String
    }

    class OnlineMonitoringSystem {
        -QueuingSystem queuingSystem
        +OnlineMonitoringSystem()
        +displayCurrentQueue() void
        +getCurrentQueue() int
    }

    class PagIbigApp {
        +main(String[] args) void
    }

    HelpDeskStation --> QueuingSystem : uses
    OnlineMonitoringSystem --> QueuingSystem : monitors
    PagIbigApp --> HelpDeskStation : uses
    PagIbigApp --> OnlineMonitoringSystem : uses
```
