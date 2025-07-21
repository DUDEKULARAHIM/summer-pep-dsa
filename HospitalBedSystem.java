import java.io.*;
import java.util.*;

class Patient {
    int id;
    String name;
    int age;
    String disease;
    int bedNumber;

    public String toFileString() {
        return id + "," + name + "," + age + "," + disease + "," + bedNumber;
    }

    public static Patient fromFileString(String data) {
        try {
            String[] parts = data.split(",");
            if (parts.length != 5) return null;

            Patient p = new Patient();
            p.id = Integer.parseInt(parts[0]);
            p.name = parts[1];
            p.age = Integer.parseInt(parts[2]);
            p.disease = parts[3];
            p.bedNumber = Integer.parseInt(parts[4]);

            return p;
        } catch (Exception e) {
            return null; // Skip invalid entries
        }
    }
}

public class HospitalBedSystem {
    static final int TOTAL_BEDS = 100;
    static Patient[] patients = new Patient[TOTAL_BEDS];
    static boolean[] beds = new boolean[TOTAL_BEDS];
    static int patientCount = 0;
    static final String FILE_NAME = "patients.txt";
    static Scanner sc = new Scanner(System.in);

    public static boolean isValidText(String text) {
        return text.matches("[a-zA-Z ]+") && !text.trim().isEmpty();
    }

    public static boolean isValidAge(String str) {
        try {
            int age = Integer.parseInt(str);
            return age >= 0 && age <= 120;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static int getAvailableBed() {
        for (int i = 0; i < TOTAL_BEDS; i++) {
            if (!beds[i]) return i;
        }
        return -1;
    }

    public static void addPatient() {
        if (patientCount >= TOTAL_BEDS) {
            System.out.println("No beds available!");
            return;
        }

        int bedNum = getAvailableBed();
        if (bedNum == -1) {
            System.out.println("No beds available!");
            return;
        }

        Patient p = new Patient();
        p.id = patientCount + 1;

        // Clear buffer
        sc.nextLine();

        while (true) {
            System.out.print("Enter patient name: ");
            p.name = sc.nextLine();
            if (isValidText(p.name)) break;
            else System.out.println("Invalid name. Only letters and spaces allowed.");
        }

        String ageInput;
        while (true) {
            System.out.print("Enter age: ");
            ageInput = sc.nextLine();
            if (isValidAge(ageInput)) {
                p.age = Integer.parseInt(ageInput);
                break;
            } else {
                System.out.println("Invalid age. Enter number between 0 and 120.");
            }
        }

        while (true) {
            System.out.print("Enter disease: ");
            p.disease = sc.nextLine();
            if (isValidText(p.disease)) break;
            else System.out.println("Invalid disease. Only letters and spaces allowed.");
        }

        p.bedNumber = bedNum;
        beds[bedNum] = true;
        patients[patientCount] = p;
        patientCount++;

        System.out.println("Patient added. Bed number assigned: " + (bedNum + 1));
        saveToFile();
    }

    public static void viewPatients() {
        if (patientCount == 0) {
            System.out.println("No patients admitted.");
            return;
        }

        System.out.println("\n--- List of Patients ---");
        for (int i = 0; i < patientCount; i++) {
            Patient p = patients[i];
            System.out.println("ID: " + p.id + ", Name: " + p.name + ", Age: " + p.age +
                    ", Disease: " + p.disease + ", Bed: " + (p.bedNumber + 1));
        }
    }

    public static void dischargePatient() {
        System.out.print("Enter patient ID to discharge: ");
        int id;
        try {
            id = sc.nextInt();
            sc.nextLine(); // clear newline
        } catch (InputMismatchException e) {
            System.out.println("Invalid ID. Please enter a number.");
            sc.nextLine(); // clear invalid input
            return;
        }

        boolean found = false;

        for (int i = 0; i < patientCount; i++) {
            if (patients[i].id == id) {
                beds[patients[i].bedNumber] = false;
                System.out.println("Patient " + patients[i].name + " discharged. Bed " + (patients[i].bedNumber + 1) + " released.");

                for (int j = i; j < patientCount - 1; j++) {
                    patients[j] = patients[j + 1];
                    patients[j].id = j + 1;
                }

                patientCount--;
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Patient with ID " + id + " not found.");
        } else {
            saveToFile();
        }
    }

    public static void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (int i = 0; i < patientCount; i++) {
                writer.println(patients[i].toFileString());
            }
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }

    public static void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null && patientCount < TOTAL_BEDS) {
                Patient p = Patient.fromFileString(line);
                if (p != null) {
                    patients[patientCount] = p;
                    beds[p.bedNumber] = true;
                    patientCount++;
                }
            }
        } catch (FileNotFoundException e) {
            // File doesn't exist yet – safe to ignore
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            loadFromFile();

            int choice=0;
            do {
                System.out.println("\n=== Hospital Bed Booking System ===");
                System.out.println("1. Add Patient");
                System.out.println("2. View Patients");
                System.out.println("3. Discharge Patient");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                try {
                    choice = sc.nextInt();
                    sc.nextLine(); // Clear newline
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    sc.nextLine(); // Clear buffer
                    continue;
                }

                switch (choice) {
                    case 1:
                        addPatient();
                        break;
                    case 2:
                        viewPatients();
                        break;
                    case 3:
                        dischargePatient();
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } while (choice != 4);
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
