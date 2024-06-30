import java.util.*;
import java.time.*;

class Contact {
    private String id;
    private String name;
    private String phoneNumber;
    private String companyName;
    private double salary;
    private String birthday;

    public Contact(String id, String name, String phoneNumber, String companyName, double salary, String birthday) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.companyName = companyName;
        this.salary = salary;
        this.birthday = birthday;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return String.format("| %-12s| %-12s| %-16s| %-12s| %-12.2f| %-12s|",
                id, name, phoneNumber, companyName, salary, birthday);
    }
}

public class Example {
    private static List<Contact> contacts = new LinkedList<>();

    // Clear console method
    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        homepage();
    }

    // Generate ID method
    public static String generateId() {
        if (contacts.isEmpty()) {
            return "C0001";
        }
        String lastId = contacts.get(contacts.size() - 1).getId();
        int lastNo = Integer.parseInt(lastId.substring(1));
        return String.format("C%04d", lastNo + 1);
    }

    // Home page method
    public static void homepage() {
        Scanner input = new Scanner(System.in);
        System.out.println("=======================iFRIEND CONTACT ORGANIZER============================");
        System.out.println("\n[01] Add Contacts");
        System.out.println("\n[02] Update Contacts");
        System.out.println("\n[03] Delete Contacts");
        System.out.println("\n[04] Search Contacts");
        System.out.println("\n[05] List Contacts");
        System.out.println("\n[06] Exit");
        System.out.print("\nEnter option to continue : ");
        int option = input.nextInt();
        clearConsole();
        switch (option) {
            case 1: addContacts(); break;
            case 2: updateContacts(); break;
            case 3: deleteContacts(); break;
            case 4: searchContacts(); break;
            case 5: listContacts(); break;
            case 6: exit(); break;
            default: System.out.println("Invalid option..."); break;
        }
    }

    // Validate phone number method
    public static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.length() == 10 && phoneNumber.charAt(0) == '0' && phoneNumber.chars().allMatch(Character::isDigit);
    }

    // Validate salary method
    public static boolean isValidSalary(double salary) {
        return salary > 0;
    }

    // Validate birthday method
    public static boolean isValidBirthday(String birthday) {
        try {
            LocalDate.parse(birthday);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Add contacts method
    public static void addContacts() {
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("======================ADD CONTACTS================");
            String id = generateId();
            System.out.println("\n" + id);
            System.out.println("=============");
            System.out.print("Name : ");
            String name = input.next();

            String phoneNumber;
            do {
                System.out.print("Phone Number : ");
                phoneNumber = input.next();
                if (!isValidPhoneNumber(phoneNumber)) {
                    System.out.println("\n\tInvalid phone number...");
                }
            } while (!isValidPhoneNumber(phoneNumber));

            System.out.print("Company Name : ");
            String companyName = input.next();

            double salary;
            do {
                System.out.print("Salary : ");
                salary = input.nextDouble();
                if (!isValidSalary(salary)) {
                    System.out.println("\n\tInvalid salary...");
                }
            } while (!isValidSalary(salary));

            String birthday;
            do {
                System.out.print("Birthday : ");
                birthday = input.next();
                if (!isValidBirthday(birthday)) {
                    System.out.println("\n\tInvalid birthday...");
                }
            } while (!isValidBirthday(birthday));

            Contact newContact = new Contact(id, name, phoneNumber, companyName, salary, birthday);
            contacts.add(newContact);

            System.out.println("\n\tContact has been added successfully...");
            System.out.print("\nDo you want to add another contact (Y/N): ");
            char ch = input.next().charAt(0);
            if (ch == 'Y' || ch == 'y') {
                clearConsole();
            } else {
                clearConsole();
                homepage();
                break;
            }
        } while (true);
    }

    // Search contacts by name or phone number
    public static int searchByNameOrPhoneNumber(String nameOrPhone) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equals(nameOrPhone) || contacts.get(i).getPhoneNumber().equals(nameOrPhone)) {
                return i;
            }
        }
        return -1;
    }

    // Print details of a contact
    public static void printDetails(int index) {
        System.out.println(contacts.get(index));
    }

    // Search contacts method
    public static void searchContacts() {
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("=====================SEARCH CONTACTS======================");
            System.out.print("\nSearch contact by name or phone number: ");
            String nameOrPhone = input.next();
            int index = searchByNameOrPhoneNumber(nameOrPhone);

            if (index == -1) {
                System.out.println("\n\tNo contact found for " + nameOrPhone);
                System.out.print("\nDo you want to try a new search (Y/N): ");
                char ch = input.next().charAt(0);
                if (ch == 'Y' || ch == 'y') {
                    clearConsole();
                } else {
                    clearConsole();
                    homepage();
                    break;
                }
            } else {
                printDetails(index);
                System.out.print("\nDo you want to search another contact (Y/N): ");
                char ch = input.next().charAt(0);
                if (ch == 'Y' || ch == 'y') {
                    clearConsole();
                } else {
                    clearConsole();
                    homepage();
                    break;
                }
            }
        } while (true);
    }

    // Update contact methods
    public static void updateName(int index) {
        Scanner input = new Scanner(System.in);
        System.out.print("\nInput new name: ");
        String newName = input.next();
        contacts.get(index).setName(newName);
    }

    public static void updatePhoneNumber(int index) {
        Scanner input = new Scanner(System.in);
        System.out.print("\nInput new phone number: ");
        String newPhoneNumber = input.next();
        contacts.get(index).setPhoneNumber(newPhoneNumber);
    }

    public static void updateCompanyName(int index) {
        Scanner input = new Scanner(System.in);
        System.out.print("\nInput new company name: ");
        String newCompanyName = input.next();
        contacts.get(index).setCompanyName(newCompanyName);
    }

    public static void updateSalary(int index) {
        Scanner input = new Scanner(System.in);
        System.out.print("\nInput new salary: ");
        double newSalary = input.nextDouble();
        contacts.get(index).setSalary(newSalary);
    }

    // Update contacts method
    public static void updateContacts() {
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("=======================UPDATE CONTACTS================");
            System.out.print("\nSearch contact by name or phone number: ");
            String nameOrPhone = input.next();
            int index = searchByNameOrPhoneNumber(nameOrPhone);

            if (index == -1) {
                System.out.println("\n\tNo contact found for " + nameOrPhone);
                System.out.print("\nDo you want to try a new search (Y/N): ");
                char ch = input.next().charAt(0);
                if (ch == 'Y' || ch == 'y') {
                }
            }
        }
    }
}
