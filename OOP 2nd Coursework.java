import java.util.Scanner;

class ContactList {
    private Contact[] contactArray;
    private int nextIndex;
    private int size;
    private int loadFactor;

    ContactList(int size, int loadFactor) {
        contactArray = new Contact[size];
        nextIndex = 0;
        this.size = size;
        this.loadFactor = loadFactor;
    }

    private boolean isFull() {
        return nextIndex == size;
    }

    private void extendArrays() {
        Contact[] tempcontactArray = new Contact[size + loadFactor];
        System.arraycopy(contactArray, 0, tempcontactArray, 0, contactArray.length);
        contactArray = tempcontactArray;
        size += loadFactor;
    }

    public void add(Contact contact) {
        if (isFull()) {
            extendArrays();
        }
        contactArray[nextIndex++] = contact;
    }

    public void showList() {
        System.out.println("===================List Of Contacts===================");
        System.out.println("+-----------------------------------------------------+");
        System.out.println("|Name|Number|Company Name|Salary|Birthday|");
        System.out.println("+-----------------------------------------------------+");
        for (int i = 0; i < nextIndex; i++) {
            System.out.printf("|%-12s|%-12s|%-12s|%-12s|%-12s|\n", contactArray[i].getName(), contactArray[i].getNumber(), contactArray[i].getCompany(), contactArray[i].getSalary(), contactArray[i].getBirthday());
        }
    }

    public Contact[] getContactArray() {
        return contactArray;
    }

    public int getNextIndex() {
        return nextIndex;
    }
}

class Contact {
    private String name;
    private String number;
    private String company;
    private double salary;
    private double birthday;

    Contact(String name, String number, String company, double salary, double birthday) {
        this.name = name;
        this.number = number;
        this.company = company;
        this.salary = salary;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getCompany() {
        return company;
    }

    public double getSalary() {
        return salary;
    }

    public double getBirthday() {
        return birthday;
    }
}

public class Main {
    private static final Scanner input = new Scanner(System.in);
    private static final ContactList contactList = new ContactList(100, 50);

    public static void main(String[] args) {
        homepage();
    }

    public static void homepage() {
        System.out.println("........................IFRIEND CONTACTS ORGANIZER.............................");
        System.out.println("[01]Add Contacts\n[02]Update Contacts\n[03]Delete Contacts\n[04]Search Contacts\n[05]List Contacts\n[06]Exit");
        System.out.print("Enter an option to continue:");
        int option = input.nextInt();
        switch (option) {
            case 1:
                addContacts();
                break;
            case 2:
                updateContacts();
                break;
            case 3:
                deleteContacts();
                break;
            case 4:
                searchContacts();
                break;
            case 5:
                listContacts();
                break;
            default:
                System.out.println("Invalid Option");
        }
    }

    public static void addContacts() {
        input.nextLine(); // Consume newline character
        do {
            System.out.println("........................Add Customer......................................");
            System.out.println("Name:");
            String contactName = input.nextLine();
            System.out.println("Number:");
            String contactNumber = input.nextLine();
            while (!isValidNumber(contactNumber)) {
                System.out.println("Invalid Number");
                System.out.println("Do you want to input number again?\n1.Yes\n2.No\nYour Choice?");
                int ch = input.nextInt();
                if (ch == 1) {
                    input.nextLine(); // Consume newline character
                    System.out.println("Number:");
                    contactNumber = input.nextLine();
                } else {
                    return;
                }
            }
            System.out.println("Company Name:");
            String companyName = input.nextLine();
            System.out.println("Salary:");
            double customerSalary = input.nextDouble();
            System.out.println("BirthDay:");
            double customerBirthday = input.nextDouble();
            Contact contact = new Contact(contactName, contactNumber, companyName, customerSalary, customerBirthday);
            contactList.add(contact);
            System.out.println("Customer Added Successfully....");
            System.out.println("Do you want to add another customer?\n1.Yes\n2.No");
            int ch = input.nextInt();
            if (ch == 2) {
                homepage();
                break;
            }
            input.nextLine(); // Consume newline character
        } while (true);
    }

    private static boolean isValidNumber(String number) {
        return number.length() == 10;
    }

    public static void updateContacts() {
        input.nextLine(); // Consume newline character
        System.out.println("Enter the name of the contact you want to update:");
        String nameToUpdate = input.nextLine();
        boolean found = false;
        for (int i = 0; i < contactList.getNextIndex(); i++) {
            if (contactList.getContactArray()[i].getName().equalsIgnoreCase(nameToUpdate)) {
                System.out.println("Enter new details for the contact:");
                System.out.println("Name:");
                String newName = input.nextLine();
                System.out.println("Number:");
                String newNumber = input.nextLine();
                while (!isValidNumber(newNumber)) {
                    System.out.println("Invalid Number");
                    System.out.println("Do you want to input number again?\n1.Yes\n2.No\nYour Choice?");
                    int ch = input.nextInt();
                    if (ch == 1) {
                        input.nextLine(); // Consume newline character
                        System.out.println("Number:");
                        newNumber = input.nextLine();
                    } else {
                        return;
                    }
                }
                System.out.println("Company Name:");
                String newCompany = input.nextLine();
                System.out.println("Salary:");
                double newSalary = input.nextDouble();
                System.out.println("BirthDay:");
                double newBirthday = input.nextDouble();
                contactList.getContactArray()[i] = new Contact(newName, newNumber, newCompany, newSalary, newBirthday);
                System.out.println("Contact updated successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Contact not found.");
        }
        homepage();
    }

    public static void searchContacts() {
        input.nextLine(); // Consume newline character
        System.out.println("Enter the Name for Search:");
        String contactName = input.nextLine();

        boolean found = false;
        for (int i = 0; i < contactList.getNextIndex(); i++) {
            if (contactList.getContactArray()[i].getName().equalsIgnoreCase(contactName)) {
                System.out.println("Name: " + contactList.getContactArray()[i].getName());
                System.out.println("Number: " + contactList.getContactArray()[i].getNumber());
                System.out.println("Company: " + contactList.getContactArray()[i].getCompany());
                System.out.println("Salary: " + contactList.getContactArray()[i].getSalary());
                System.out.println("Birthday: " + contactList.getContactArray()[i].getBirthday());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Contact not found.");
        }
        homepage();
    }

    public static void deleteContacts() {
        input.nextLine(); // Consume newline character
        System.out.println("Enter the name of the contact you want to delete:");
        String nameToDelete = input.nextLine();
        boolean found = false;
        for (int i = 0; i < contactList.getNextIndex(); i++) {
            if (contactList.getContactArray()[i].getName().equalsIgnoreCase(nameToDelete)) {
                // Shift elements to the left to remove the contact
                for (int j = i; j < contactList.getNextIndex() - 1; j++) {
                    contactList.getContactArray()[j] = contactList.getContactArray()[j + 1];
                }
                contactList.getContactArray()[contactList.getNextIndex() - 1] = null; // Set last element to null
                contactList.nextIndex--; // Decrement nextIndex
                System.out.println("Contact deleted successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Contact not found.");
        }
        homepage();
    }

    public static void listContacts() {
        contactList.showList();
        homepage();
    }
}
