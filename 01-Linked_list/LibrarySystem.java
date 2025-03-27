class Book {
    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    Book next, prev;

    // Constructor to initialize book details
    Book(int bookId, String title, String author, String genre, boolean isAvailable) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = isAvailable;
        this.next = this.prev = null;
    }
}

class LibraryManagement {
    private Book head, tail;

    // Add a book at the beginning
    void addBookAtBeginning(int bookId, String title, String author, String genre, boolean isAvailable) {
        Book newBook = new Book(bookId, title, author, genre, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }

    // Add a book at the end
    void addBookAtEnd(int bookId, String title, String author, String genre, boolean isAvailable) {
        Book newBook = new Book(bookId, title, author, genre, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    // Remove a book by Book ID
    void removeBook(int bookId) {
        Book temp = head;
        while (temp != null && temp.bookId != bookId) {
            temp = temp.next;
        }
        if (temp == null) return;
        if (temp == head) head = temp.next;
        if (temp == tail) tail = temp.prev;
        if (temp.prev != null) temp.prev.next = temp.next;
        if (temp.next != null) temp.next.prev = temp.prev;
    }

    // Search for a book by Title or Author
    void searchBook(String key) {
        Book temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(key) || temp.author.equalsIgnoreCase(key)) {
                System.out.println("Book Found: " + temp.title + " by " + temp.author + " (Genre: " + temp.genre + ", Available: " + temp.isAvailable + ")");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found.");
    }

    // Update book availability status
    void updateAvailability(int bookId, boolean isAvailable) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.isAvailable = isAvailable;
                return;
            }
            temp = temp.next;
        }
    }

    // Display books in forward order
    void displayBooksForward() {
        Book temp = head;
        while (temp != null) {
            System.out.println("Book ID: " + temp.bookId + ", Title: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre + ", Available: " + temp.isAvailable);
            temp = temp.next;
        }
    }

    // Display books in reverse order
    void displayBooksReverse() {
        Book temp = tail;
        while (temp != null) {
            System.out.println("Book ID: " + temp.bookId + ", Title: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre + ", Available: " + temp.isAvailable);
            temp = temp.prev;
        }
    }

    // Count total books in library
    int countBooks() {
        int count = 0;
        Book temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        LibraryManagement library = new LibraryManagement();

        // Adding books
        library.addBookAtBeginning(1, "The Great Gatsby", "F. Scott Fitzgerald", "Fiction", true);
        library.addBookAtEnd(2, "To Kill a Mockingbird", "Harper Lee", "Fiction", true);
        library.addBookAtEnd(3, "1984", "George Orwell", "Dystopian", false);

        // Display books forward
        System.out.println("Library Collection:");
        library.displayBooksForward();

        // Updating availability
        System.out.println("\nUpdating Availability of Book ID 2");
        library.updateAvailability(2, false);
        library.displayBooksForward();

        // Searching for a book
        System.out.println("\nSearching for '1984':");
        library.searchBook("1984");

        // Counting total books
        System.out.println("\nTotal Books in Library: " + library.countBooks());

        // Removing a book
        System.out.println("\nRemoving Book ID 1");
        library.removeBook(1);
        library.displayBooksForward();
    }
}
