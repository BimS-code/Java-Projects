import java.util.Scanner;
class Contact{
    private String name;
    private String number;
    private String company;
    private double salary;
    private double Birthday;

    Contact (String name,String number,String company,double salary,double Birthday){
        this.name=name;
        this.number = number;
        this.company=company;
        this.salary=salary;
        this.Birthday=Birthday;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setNumber(String number){
        this.number=number;
    }
    public void setCompany(String company){
        this.company=company;
    }
    public void setSalary(double salary){
        this.salary=salary;
    }
    public void setBirthday(double Birthday){
        this.Birthday=Birthday;
    }
    public String getName(){
        return name;

    }
    public String getNumber(){
        return number;

    }
    public String getCompany(){
        return company;

    }
    public double getSalary(){
        return salary;

    }
    public double getBirthday(){
        return Birthday;

    }

}

class example {
    //.....................Create Arrays..........................
    public static Contact[] contactArray = new Contact[0];
    public static void main(String[] args) {
        homepage();

    }
    //....................Homepage...............................
    public static void homepage() {
        Scanner input = new Scanner(System.in);
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
    //................................Extend Array...............................
    public static void extendArray(){
        Contact[] tempcontactArray= new Contact[contactArray.length+1];
        for(int i = 0; i<contactArray.length; i++){
            tempcontactArray[i]=contactArray[i];
        }
        contactArray=tempcontactArray;
    }
    //........................Decrease Array..........................
    public static void decreaseArray(){
        Scanner Userdel = new Scanner(System.in);
        int delIn = Userdel.nextInt();

        String[] tempcontactArray = new String[contactArray.length-1];


        for(int i = contactArray.length;i>=delIn;i--){
            tempcontactArray[i]=contactArray[i];
        }
        contactArray=tempcontactArray;
    }
    //...................................Number Check.................................
    public static boolean isValidNumber(
            String ContactNumber){

        return ContactNumber.length() == 10;
    }
    //..................................Show List......................................
    public static void ShowList(){
        System.out.println("===================List Of Contacts===================");
        System.out.println("+-----------------------------------------------------+");
        System.out.println("|Name|Number|Company Name|Salary|Birthday|");
        System.out.println("+-----------------------------------------------------+");
        for (int i = 0; i < contactArray.length; i++) {
            System.out.printf("|%-12s|%-12s|%-12s|%-12s|%-12s|\n", contactArray[i].getName(),contactArray[i].getNumber(),contactArray[i].getCompany(),contactArray[i].getSalary(),contactArray[i].getSalary());
        }

    }

    //#Option1....................................................................
    public static void addContacts() {
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("........................Add Customer......................................");
            System.out.println("Name:");
            String ContactName = input.next();
            String ContactNumber;
            do {
                System.out.println("Number");
                ContactNumber = input.next();
                if (!isValidNumber(ContactNumber)) {
                    System.out.println("Invalid Number");
                    System.out.println("Do you want to input number again?\n1.Yes\n2.No\nYour Choice?");
                    int ch = input.nextInt();
                    if (ch == 1) {
                        continue;
                    } else {
                        break;
                    }
                }
            } while (!isValidNumber(ContactNumber));



            System.out.println("Company Name:");
            String CompanyName = input.next();
            System.out.println("Salary:");
            double CustomerSalary = input.nextDouble();
            System.out.println("BirthDay:");
            int CustomerBirthDay = input.nextInt();




            extendArray();
            Contact contact = new Contact(ContactName,ContactNumber,CompanyName,CustomerSalary,CustomerBirthDay);
            contactArray[contactArray.length-1]=contact;
            System.out.println("Customer Added Successfully....");
            System.out.println("Do you want to add another customer?\n1.Yes\n2.No");
            int ch = input.nextInt();
            if(ch ==1){
                continue;
            }else {
                homepage();
                break;
            }

        }while(true);
    }
    //#Option2....................................................................
    public static void updateContacts() {
        searchContacts();

    }
    //#Option3....................................................................
    public static void searchContacts() {
        Scanner Search = new Scanner(System.in);
        System.out.println("Enter the Name for Search:");
        String CName = Search.next();
        int i = 0;
        for (i = 0; i < contactArray.length; i++) {
            if (contactArray[i] == CName) {
                break;
            }
        }

        System.out.println("Name:"+ contactArray[i]);
        System.out.println("Number:"+ contactArray[i]);
        System.out.println("Company:"+ contactArray[i]);
        System.out.println("Salary:"+ contactArray[i]);
        System.out.println("Birthday:"+ contactArray[i]);
    }
    //#Option4....................................................................
    public static void deleteContacts() {
        Scanner input = new Scanner(System.in);
        ShowList();
        System.out.println("Enter the Index of Contact :");
        decreaseArray();
        ShowList();
        //return
        System.out.println("Do you want go to Homepage?\n1.Yes\n2.No");
        int ch = input.nextInt();
        if(ch ==1){
            homepage();
        }else {
        }
    }

    //#Option5....................................................................
    public static void listContacts(){
        Scanner input = new Scanner(System.in);
        do{
            System.out.println("===================List Of Contacts===================");
            System.out.println("+-----------------------------------------------------+");
            System.out.println("|Name|Number|Company Name|Salary|Birthday|");
            System.out.println("+-----------------------------------------------------+");
            for(int i = 0; i<contactArray.length;i++){
                System.out.printf("|%-12s|%-12s|%-12s|%-12s|%-12s|\n",contactArray[i].getName(),contactArray[i].getNumber(),contactArray[i].getCompany(),contactArray[i].getSalary(),contactArray[i].getSalary());
            }
            System.out.println("+-----------------------------------------------------+");
            System.out.println("Do you want go to Homepage?\n1.Yes\n2.No");
            int ch = input.nextInt();
            if(ch ==1){
                homepage();
            }else {

                break;
            }
        }while(true);


    }

}