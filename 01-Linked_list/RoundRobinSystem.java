class Process {
    int processId;
    int burstTime;
    int priority;
    Process next;

    // Constructor to initialize process details
    Process(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class RoundRobinScheduler {
    private Process head, tail;
    private int timeQuantum;

    // Constructor
    RoundRobinScheduler(int timeQuantum) {
        this.timeQuantum = timeQuantum;
        this.head = this.tail = null;
    }

    // Add a process at the end of the circular list
    void addProcess(int processId, int burstTime, int priority) {
        Process newProcess = new Process(processId, burstTime, priority);
        if (head == null) {
            head = tail = newProcess;
            tail.next = head;
        } else {
            tail.next = newProcess;
            newProcess.next = head;
            tail = newProcess;
        }
    }

    // Remove a process by Process ID
    void removeProcess(int processId) {
        if (head == null) return;
        Process temp = head, prev = tail;
        do {
            if (temp.processId == processId) {
                if (temp == head) head = head.next;
                if (temp == tail) tail = prev;
                prev.next = temp.next;
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    // Simulate round-robin scheduling
    void simulateScheduling() {
        if (head == null) return;
        Process temp = head;
        System.out.println("Starting Round Robin Scheduling...");
        while (head != null) {
            if (temp.burstTime > timeQuantum) {
                System.out.println("Process " + temp.processId + " executed for " + timeQuantum + " units.");
                temp.burstTime -= timeQuantum;
            } else {
                System.out.println("Process " + temp.processId + " executed completely.");
                removeProcess(temp.processId);
            }
            temp = temp.next;
            if (temp == null) temp = head;
        }
        System.out.println("All processes completed.");
    }

    // Display processes in circular queue
    void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in queue.");
            return;
        }
        Process temp = head;
        System.out.println("Current Processes:");
        do {
            System.out.println("Process ID: " + temp.processId + ", Burst Time: " + temp.burstTime + ", Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }
}

public class RoundRobinSystem {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler(4);

        // Adding processes
        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 5, 2);
        scheduler.addProcess(3, 8, 1);

        // Display processes
        scheduler.displayProcesses();

        // Simulate scheduling
        scheduler.simulateScheduling();
    }
}




//check it again