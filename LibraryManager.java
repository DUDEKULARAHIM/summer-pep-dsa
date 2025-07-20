// import java.io.*;
// import java.util.*;

// class Book {
//     int id;
//     String title;
//     String author;
//     String checkInDate;
//     String checkOutDate;

//     public Book(int id, String title, String author, String checkInDate, String checkOutDate) {
//         this.id = id;
//         this.title = title;
//         this.author = author;
//         this.checkInDate = checkInDate;
//         this.checkOutDate = checkOutDate;
//     }

//     public String toString() {
//         return id + "," + title + "," + author + "," + checkInDate + "," + checkOutDate;
//     }
// }

// class BookQueue {
//     private Book[] queue;
//     private int front = -1, rear = -1, size;

//     public BookQueue(int size) {
//         this.size = size;
//         queue = new Book[size];
//     }

//     public void enqueue(Book book) {
//         if (rear == size - 1) {
//             System.out.println("Queue full. Cannot add more books.");
//             return;
//         }
//         if (front == -1) front = 0;
//         queue[++rear] = book;
//     }

//     public Book dequeue() {
//         if (front == -1 || front > rear) {
//             System.out.println("Queue is empty.");
//             return null;
//         }
//         return queue[front++];
//     }

//     public void display() {
//         if (front == -1 || front > rear) {
//             System.out.println("Queue is empty.");
//             return;
//         }
//         for (int i = front; i <= rear; i++) {
//             System.out.println(queue[i]);
//         }
//     }

//     public Book[] getBooks() {
//         return Arrays.copyOfRange(queue, front, rear + 1);
//     }
// }

// public class LibraryManager {
//     static final String FILE_PATH = "library_books.txt";

//     public static void main(String[] args) throws IOException {
//         Scanner sc = new Scanner(System.in);
//         BookQueue bookQueue = new BookQueue(100);
//         loadFromFile(bookQueue);

//         while (true) {
//             System.out.println("\n1. Add Book\n2. Delete Book\n3. Search Book by Title\n4. Display All Books\n5. Exit");
//             System.out.print("Choose: ");
//             String choice = sc.nextLine();

//             switch (choice) {
//                 case "1":
//                     try {
//                         System.out.print("Enter ID: ");
//                         int id = Integer.parseInt(sc.nextLine());

//                         System.out.print("Enter Title: ");
//                         String title = sc.nextLine();

//                         System.out.print("Enter Author: ");
//                         String author = sc.nextLine();

//                         System.out.print("Enter Check-In Date (yyyy-mm-dd): ");
//                         String in = sc.nextLine();

//                         System.out.print("Enter Check-Out Date (yyyy-mm-dd): ");
//                         String out = sc.nextLine();

//                         Book newBook = new Book(id, title, author, in, out);
//                         bookQueue.enqueue(newBook);
//                         saveToFile(bookQueue.getBooks());
//                         System.out.println("Book Added.");
//                     } catch (Exception e) {
//                         System.out.println("Invalid input. Please try again.");
//                     }
//                     break;

//                 case "2":
//                     Book removed = bookQueue.dequeue();
//                     if (removed != null) {
//                         saveToFile(bookQueue.getBooks());
//                         System.out.println("Book Deleted: " + removed);
//                     }
//                     break;

//                 case "3":
//                     Book[] books = bookQueue.getBooks();
//                     mergeSort(books, 0, books.length - 1);
//                     System.out.print("Enter Title to Search: ");
//                     String searchTitle = sc.nextLine();
//                     int index = binarySearch(books, searchTitle);
//                     if (index != -1) System.out.println("Found: " + books[index]);
//                     else System.out.println("Book Not Found.");
//                     break;

//                 case "4":
//                     bookQueue.display();
//                     break;

//                 case "5":
//                     System.out.println("Exiting...");
//                     return;

//                 default:
//                     System.out.println("Invalid choice. Please enter between 1-5.");
//             }
//         }
//     }

//     // --- Merge Sort by Title ---
//     public static void mergeSort(Book[] books, int l, int r) {
//         if (l < r) {
//             int m = (l + r) / 2;
//             mergeSort(books, l, m);
//             mergeSort(books, m + 1, r);
//             merge(books, l, m, r);
//         }
//     }

//     public static void merge(Book[] books, int l, int m, int r) {
//         int n1 = m - l + 1;
//         int n2 = r - m;

//         Book[] L = new Book[n1];
//         Book[] R = new Book[n2];

//         for (int i = 0; i < n1; ++i) L[i] = books[l + i];
//         for (int j = 0; j < n2; ++j) R[j] = books[m + 1 + j];

//         int i = 0, j = 0, k = l;
//         while (i < n1 && j < n2) {
//             if (L[i].title.compareToIgnoreCase(R[j].title) <= 0) books[k++] = L[i++];
//             else books[k++] = R[j++];
//         }
//         while (i < n1) books[k++] = L[i++];
//         while (j < n2) books[k++] = R[j++];
//     }

//     // --- Binary Search ---
//     public static int binarySearch(Book[] books, String title) {
//         int l = 0, r = books.length - 1;
//         while (l <= r) {
//             int mid = (l + r) / 2;
//             int cmp = books[mid].title.compareToIgnoreCase(title);
//             if (cmp == 0) return mid;
//             else if (cmp < 0) l = mid + 1;
//             else r = mid - 1;
//         }
//         return -1;
//     }

//     // --- File Handling ---
//     public static void saveToFile(Book[] books) {
//         try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
//             for (Book b : books) {
//                 bw.write(b.toString());
//                 bw.newLine();
//             }
//         } catch (IOException e) {
//             System.out.println("Error writing to file.");
//         }
//     }

//     public static void loadFromFile(BookQueue bookQueue) {
//         try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
//             String line;
//             while ((line = br.readLine()) != null) {
//                 String[] parts = line.split(",", 5);
//                 if (parts.length == 5) {
//                     int id = Integer.parseInt(parts[0]);
//                     String title = parts[1];
//                     String author = parts[2];
//                     String in = parts[3];
//                     String out = parts[4];
//                     bookQueue.enqueue(new Book(id, title, author, in, out));
//                 }
//             }
//         } catch (IOException e) {
//             System.out.println("No existing file. Starting fresh.");
//         }
//     }
// }








import java.io.*;
import java.util.*;

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
    static final String FILE_NAME = "library_data.txt";

    public static void main(String[] args) {
        loadFromFile();
        Scanner sc = new Scanner(System.in);
        // System.out.println("hello");

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add a new book");
            System.out.println("2. Search for a book");
            System.out.println("3. Issue a book");
            System.out.println("4. Return a book");
            System.out.println("5. Delete a book");
            System.out.println("6. List all books");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1 -> addBook(sc);
                    case 2 -> searchBook(sc);
                    case 3 -> issueBook(sc);
                    case 4 -> returnBook(sc);
                    case 5 -> deleteBook(sc);
                    case 6 -> listAllBooks();
                    case 7 -> {
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

    // --- Add Book ---
    static void addBook(Scanner sc) {
        if (bookCount >= MAX_BOOKS) {
            System.out.println("Library is full.");
            return;
        }
        try {
            System.out.print("Enter book ID: ");
            int id = Integer.parseInt(sc.nextLine());

            System.out.print("Enter book title: ");
            String title = sc.nextLine();

            System.out.print("Enter book author: ");
            String author = sc.nextLine();

            books[bookCount++] = new Book(id, title, author, "Available");
            saveToFile();
            System.out.println("Book added successfully.");
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter correct details.");
        }
    }

    // --- Search Book ---
    static void searchBook(Scanner sc) {
        System.out.print("Enter book ID or title: ");
        String query = sc.nextLine().trim();
        boolean found = false;

        for (int i = 0; i < bookCount; i++) {
            if (String.valueOf(books[i].id).equals(query) || books[i].title.equalsIgnoreCase(query)) {
                displayBook(books[i]);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Book not found.");
        }
    }

    // --- Issue Book ---
    static void issueBook(Scanner sc) {
        System.out.print("Enter book ID: ");
        try {
            int id = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < bookCount; i++) {
                if (books[i].id == id && books[i].status.equals("Available")) {
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter issue date (yyyy-mm-dd): ");
                    String date = sc.nextLine();
                    issueQueue.add(new Issue(id, name, date));
                    books[i].status = "Issued";
                    saveToFile();
                    System.out.println("Book issued.");
                    return;
                }
            }
            System.out.println("Book not available or already issued.");
        } catch (Exception e) {
            System.out.println("Invalid ID.");
        }
    }

    // --- Return Book ---
    static void returnBook(Scanner sc) {
        System.out.print("Enter book ID: ");
        try {
            int id = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < bookCount; i++) {
                if (books[i].id == id && books[i].status.equals("Issued")) {
                    if (!issueQueue.isEmpty()) issueQueue.poll(); // remove the top issued book
                    books[i].status = "Available";
                    saveToFile();
                    System.out.println("Book returned.");
                    return;
                }
            }
            System.out.println("Book not found or not issued.");
        } catch (Exception e) {
            System.out.println("Invalid input.");
        }
    }

    // --- Delete Book ---
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

    // --- List All Books (Merge Sort by Title) ---
    static void listAllBooks() {
        mergeSort(books, 0, bookCount - 1);
        System.out.println("\nAll Books:");
        for (int i = 0; i < bookCount; i++) {
            displayBook(books[i]);
        }
    }

    static void displayBook(Book b) {
        System.out.println("Book ID: " + b.id);
        System.out.println("Title: " + b.title);
        System.out.println("Author: " + b.author);
        System.out.println("Status: " + b.status);
    }

    // --- Merge Sort ---
    static void mergeSort(Book[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    static void merge(Book[] arr, int l, int m, int r) {
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

    // --- File I/O ---
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
                    books[bookCount++] = new Book(id, data[1], data[2], data[3]);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }
}
