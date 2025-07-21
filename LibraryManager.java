




import java.io.*;
import java.util.*;
import java.util.regex.*;

class Book {
    int id;
    String title;
    String author;
    String status; // Available or Issued

    public Book(int id, String title, String author, String status) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.status = status;
    }

    @Override
    public String toString() {
        return id + "," + title + "," + author + "," + status;
    }
}

class Issue {
    int bookId;
    String studentName;
    String issueDate;

    public Issue(int bookId, String studentName, String issueDate) {
        this.bookId = bookId;
        this.studentName = studentName;
        this.issueDate = issueDate;
    }
}

public class LibraryManager {
    static final int MAX_BOOKS = 100;
    static Book[] books = new Book[MAX_BOOKS];
    static int bookCount = 0;
    static Queue<Issue> issueQueue = new LinkedList<>();
    static HashMap<Integer, Book> bookMap = new HashMap<>();
    static final String FILE_NAME = "library_data.txt";

    public static void main(String[] args) {
        loadFromFile();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add a new book");
            System.out.println("2. Search for a book");
            System.out.println("3. Issue a book");
            System.out.println("4. Return a book");
            System.out.println("5. Delete a book");
            // System.out.println("6. List all books sorted by title");
            System.out.println("7. List all books sorted by ID");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1 -> addBook(sc);
                    case 2 -> searchBook(sc);
                    case 3 -> issueBook(sc);
                    case 4 -> returnBook(sc);
                    case 5 -> deleteBook(sc);
                    // case 6 -> {
                    //     mergeSortByTitle(books, 0, bookCount - 1);
                    //     listAllBooks();
                    // }
                    case 7 -> {
                        sortById();
                        listAllBooks();
                    }
                    case 8 -> {
                        System.out.println("Exiting...");
                        return;
                    }
                    default -> System.out.println("Invalid choice. Try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: Please enter valid input.");
            }
        }
    }

    static void addBook(Scanner sc) {
        if (bookCount >= MAX_BOOKS) {
            System.out.println("Library is full.");
            return;
        }
        try {
            System.out.print("Enter book ID: ");
            int id = Integer.parseInt(sc.nextLine());
            if (bookMap.containsKey(id)) {
                System.out.println("Book ID already exists.");
                return;
            }

            System.out.print("Enter book title: ");
            String title = sc.nextLine();
            if (!title.matches("[a-zA-Z0-9! ]+")) {
                System.out.println("Invalid title. Use letters, digits and spaces only.");
                return;
            }

            System.out.print("Enter book author: ");
            String author = sc.nextLine();
            if (!author.matches("[a-zA-Z ]+")) {
                System.out.println("Invalid author name. Use letters and spaces only.");
                return;
            }

            Book newBook = new Book(id, title.trim(), author.trim(), "Available");
            books[bookCount++] = newBook;
            bookMap.put(id, newBook);
            saveToFile();
            System.out.println("Book added successfully.");
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter correct details.");
        }
    }

    static void searchBook(Scanner sc) {
        System.out.print("Enter book ID or title: ");
        String query = sc.nextLine().trim();
        boolean found = false;

        try {
            int id = Integer.parseInt(query);
            Book b = bookMap.get(id);
            if (b != null) {
                displayBook(b);
                found = true;
            }
        } catch (NumberFormatException e) {
            for (int i = 0; i < bookCount; i++) {
                if (books[i].title.equalsIgnoreCase(query)) {
                    displayBook(books[i]);
                    found = true;
                    break;
                }
            }
        }

        if (!found) System.out.println("Book not found.");
    }

    static void issueBook(Scanner sc) {
        sortById();
        listAllBooks();
        System.out.print("Enter book ID: ");

        try {
            int id = Integer.parseInt(sc.nextLine());
            Book book = bookMap.get(id);
            if (book != null && book.status.equals("Available")) {

                System.out.print("Enter student name: ");
                String name = sc.nextLine();
                if (!name.matches("[a-zA-Z ]+")) {
                    System.out.println("Invalid name. Only letters and spaces allowed.");
                    return;
                }

                System.out.print("Enter issue date (yyyy-mm-dd): ");
                String date = sc.nextLine();
                if (!date.matches("\\d{4}-\\d{2}-\\d{2}")) {
                    System.out.println("Invalid date format.");
                    return;
                }

                issueQueue.add(new Issue(id, name.trim(), date));
                book.status = "Issued";
                saveToFile();
                System.out.println("Book issued.");
            } else {
                System.out.println("Book not available or already issued.");
            }
        } catch (Exception e) {
            System.out.println("Invalid input.");
        }
    }

    static void returnBook(Scanner sc) {
        System.out.print("Enter book ID: ");
        try {
            int id = Integer.parseInt(sc.nextLine());
            Book book = bookMap.get(id);
            if (book != null && book.status.equals("Issued")) {
                if (!issueQueue.isEmpty()) issueQueue.poll();
                book.status = "Available";
                saveToFile();
                System.out.println("Book returned.");
            } else {
                System.out.println("Book not found or not issued.");
            }
        } catch (Exception e) {
            System.out.println("Invalid input.");
        }
    }

    static void deleteBook(Scanner sc) {
        System.out.print("Enter book ID: ");
        try {
            int id = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < bookCount; i++) {
                if (books[i].id == id) {
                    for (int j = i; j < bookCount - 1; j++) {
                        books[j] = books[j + 1];
                    }
                    books[--bookCount] = null;
                    bookMap.remove(id);
                    saveToFile();
                    System.out.println("Book deleted.");
                    return;
                }
            }
            System.out.println("Book not found.");
        } catch (Exception e) {
            System.out.println("Invalid input.");
        }
    }

    static void listAllBooks() {
        System.out.println("\nAll Books:");
        for (int i = 0; i < bookCount; i++) {
            displayBook(books[i]);
        }
    }

    static void displayBook(Book b) {
        System.out.println("----------------------------");
        System.out.println("Book ID : " + b.id);
        System.out.println("Title   : " + b.title);
        System.out.println("Author  : " + b.author);
        System.out.println("Status  : " + b.status);
    }

    static void mergeSortByTitle(Book[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSortByTitle(arr, l, m);
            mergeSortByTitle(arr, m + 1, r);
            mergeByTitle(arr, l, m, r);
        }
    }

    static void mergeByTitle(Book[] arr, int l, int m, int r) {
        int n1 = m - l + 1, n2 = r - m;
        Book[] L = new Book[n1];
        Book[] R = new Book[n2];

        for (int i = 0; i < n1; ++i) L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j) R[j] = arr[m + 1 + j];

        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i].title.compareToIgnoreCase(R[j].title) <= 0) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    static void sortById() {
        Arrays.sort(books, 0, bookCount, Comparator.comparingInt(b -> b.id));
    }

    static void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (int i = 0; i < bookCount; i++) {
                bw.write(books[i].toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }

    static void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null && bookCount < MAX_BOOKS) {
                String[] data = line.split(",", 4);
                if (data.length == 4) {
                    int id = Integer.parseInt(data[0]);
                    Book newBook = new Book(id, data[1], data[2], data[3]);
                    books[bookCount++] = newBook;
                    bookMap.put(id, newBook);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }

    }
}