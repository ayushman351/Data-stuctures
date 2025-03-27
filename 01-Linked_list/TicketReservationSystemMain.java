class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    int seatNumber;
    String bookingTime;
    Ticket next;

    // Constructor to store ticket details
    Ticket(int ticketId, String customerName, String movieName, int seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class TicketReservationSystem {
    private Ticket head, tail;
    private int ticketCount;

    // Constructor
    TicketReservationSystem() {
        this.head = this.tail = null;
        this.ticketCount = 0;
    }

    // Add a new ticket reservation at the end of the circular list
    void addTicket(int ticketId, String customerName, String movieName, int seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = tail = newTicket;
            tail.next = head;
        } else {
            tail.next = newTicket;
            newTicket.next = head;
            tail = newTicket;
        }
        ticketCount++;
    }

    // Remove a ticket by Ticket ID
    void removeTicket(int ticketId) {
        if (head == null) return;
        Ticket temp = head, prev = tail;
        do {
            if (temp.ticketId == ticketId) {
                if (temp == head) head = head.next;
                if (temp == tail) tail = prev;
                prev.next = temp.next;
                ticketCount--;
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    // Display all tickets
    void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        Ticket temp = head;
        System.out.println("Booked Tickets:");
        do {
            System.out.println("Ticket ID: " + temp.ticketId + ", Customer: " + temp.customerName + ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber + ", Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    // Search ticket by Customer Name or Movie Name
    void searchTicket(String query) {
        if (head == null) return;
        Ticket temp = head;
        boolean found = false;
        do {
            if (temp.customerName.equalsIgnoreCase(query) || temp.movieName.equalsIgnoreCase(query)) {
                System.out.println("Found Ticket -> ID: " + temp.ticketId + ", Customer: " + temp.customerName + ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) System.out.println("No matching tickets found.");
    }

    // Get total number of booked tickets
    void totalTickets() {
        System.out.println("Total Booked Tickets: " + ticketCount);
    }
}

public class TicketReservationSystemMain {
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();

        // Adding tickets
        system.addTicket(1, "Alice", "Inception", 12, "10:00 AM");
        system.addTicket(2, "Bob", "Interstellar", 15, "2:00 PM");
        system.addTicket(3, "Charlie", "Inception", 8, "6:00 PM");

        // Display tickets
        system.displayTickets();
        
        // Search tickets
        system.searchTicket("Inception");
        
        // Remove a ticket
        system.removeTicket(2);
        system.displayTickets();
        
        // Total booked tickets
        system.totalTickets();
    }
}
