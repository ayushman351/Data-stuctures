 class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie next;
    Movie prev;

    // Constructor to initialize movie details
    public Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

class MovieList {
    private Movie head;
    private Movie tail;

    // Add a movie at the beginning of the list
    public void addMovieAtBeginning(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    // Add a movie at the end of the list
    public void addMovieAtEnd(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    // Remove a movie by title
    public void removeMovie(String title) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equals(title)) {
                if (temp.prev != null) temp.prev.next = temp.next;
                if (temp.next != null) temp.next.prev = temp.prev;
                if (temp == head) head = temp.next;
                if (temp == tail) tail = temp.prev;
                return;
            }
            temp = temp.next;
        }
    }

    // Search for a movie by director or rating
    public void searchMovie(String director, Double rating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.director.equals(director) || temp.rating == rating) {
                System.out.println("Found Movie: " + temp.title + " by " + temp.director + " (" + temp.year + ") - Rating: " + temp.rating);
            }
            temp = temp.next;
        }
    }

    // Display movies in forward order
    public void displayForward() {
        Movie temp = head;
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Director: " + temp.director + ", Year: " + temp.year + ", Rating: " + temp.rating);
            temp = temp.next;
        }
    }

    // Display movies in reverse order
    public void displayReverse() {
        Movie temp = tail;
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Director: " + temp.director + ", Year: " + temp.year + ", Rating: " + temp.rating);
            temp = temp.prev;
        }
    }

    // Update movie rating by title
    public void updateMovieRating(String title, double newRating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equals(title)) {
                temp.rating = newRating;
                return;
            }
            temp = temp.next;
        }
    }
}

public class MovieManagementSystem {
    public static void main(String[] args) {
        MovieList movieList = new MovieList();
        
        // Adding movies
        movieList.addMovieAtBeginning("Inception", "Christopher Nolan", 2010, 8.8);
        movieList.addMovieAtEnd("Interstellar", "Christopher Nolan", 2014, 8.6);
        movieList.addMovieAtEnd("The Dark Knight", "Christopher Nolan", 2008, 9.0);
        
        // Display movies in forward order
        System.out.println("Movies in forward order:");
        movieList.displayForward();
        
        // Updating a movie rating
        System.out.println("\nUpdating Interstellar's rating to 9.0");
        movieList.updateMovieRating("Interstellar", 9.0);
        movieList.displayForward();
        
        // Removing a movie
        System.out.println("\nRemoving The Dark Knight");
        movieList.removeMovie("The Dark Knight");
        movieList.displayForward();
        
        // Display movies in reverse order
        System.out.println("\nMovies in reverse order:");
        movieList.displayReverse();
    }

 
    
}
