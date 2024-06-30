import java.util.Scanner;

class example {
    //.....................Create Arrays..........................
    public static String[] nameArray = new String[0];
    public static int[] numberArray = new int[0];
    public static String[] companyArray = new String[0];
    public static double[] salaryArray = new double[0];
    public static double[] BirthdayArray = new double[0];
    public static void main(String[] args) {
        homepage();

    }

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
    //Extend Array
    public static void extendArray(){
        String[] tempContactNameArray = new String[nameArray.length+1];
        int[] tempNumberArray = new int[numberArray.length+1];
        String[] tempCompanyArray = new String[companyArray.length+1];
        double[] tempSalaryArray = new double[salaryArray.length+1];
        double[] tempBirthdayArray = new double[BirthdayArray.length+1];

        for(int i = 0; i<numberArray.length; i++){
            tempContactNameArray[i]=nameArray[i];
            tempNumberArray[i]=numberArray[i];
            tempCompanyArray[i]=companyArray[i];
            tempSalaryArray[i]=salaryArray[i];
            tempBirthdayArray[i]=BirthdayArray[i];

        }
        nameArray=tempContactNameArray;
        numberArray=tempNumberArray;
        companyArray=tempCompanyArray;
        salaryArray=tempSalaryArray;
        BirthdayArray=tempBirthdayArray;
    }
    public static void decreaseArray(){
        Scanner Userdel = new Scanner(System.in);
        int delIn = Userdel.nextInt();

        String[] tempContactNameArray = new String[nameArray.length-1];
        int[] tempNumberArray = new int[numberArray.length-1];
        String[] tempCompanyArray = new String[companyArray.length-1];
        double[] tempSalaryArray = new double[salaryArray.length-1];
        double[] tempBirthdayArray = new double[BirthdayArray.length-1];

        for(int i = nameArray.length;i==delIn;i--){
            nameArray=tempContactNameArray;
            numberArray=tempNumberArray;
            companyArray=tempCompanyArray;
            salaryArray=tempSalaryArray;
            BirthdayArray=tempBirthdayArray;


        }
        nameArray=tempContactNameArray;
        numberArray=tempNumberArray;
        companyArray=tempCompanyArray;
        salaryArray=tempSalaryArray;
        BirthdayArray=tempBirthdayArray;
    }

    public static boolean isValidNumber(
            int ContactNumber){

        return ContactNumber == 10;
    }
    public static void ShowList(){
        System.out.println("===================List Of Contacts===================");
        System.out.println("+-----------------------------------------------------+");
        System.out.println("|Name|Number|Company Name|Salary|Birthday|");
        System.out.println("+-----------------------------------------------------+");
        for (int i = 0; i < numberArray.length; i++) {
            System.out.printf("|%-12s|%-12s|%-12s|%-12s|%-12s|\n", nameArray[i], numberArray[i], companyArray[i], salaryArray[i], BirthdayArray[i]);
            }

        }


    public static void addContacts() {
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("........................Add Customer......................................");
            System.out.println("Name:");
            String ContactName = input.next();
            int ContactNumber;
            do {
                System.out.println("Number");
                ContactNumber = input.nextInt();
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
            nameArray[nameArray.length-1]= ContactName;
            numberArray[numberArray.length-1]=ContactNumber;
            companyArray[companyArray.length-1]=CompanyName;
            salaryArray[salaryArray.length-1]=CustomerSalary;
            BirthdayArray[BirthdayArray.length-1]=CustomerBirthDay;

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

    public static void updateContacts() {
        System.out.println("...............................Search Contact..................................");
        Scanner UC = new Scanner(System.in);
        System.out.println("Enter an Option:");
        String Search = UC.nextLine();


    }

    public static void searchContacts() {

    }

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


    public static void listContacts(){
        Scanner input = new Scanner(System.in);
        do{
            System.out.println("===================List Of Contacts===================");
            System.out.println("+-----------------------------------------------------+");
            System.out.println("|Name|Number|Company Name|Salary|Birthday|");
            System.out.println("+-----------------------------------------------------+");
            for(int i = 0; i<numberArray.length;i++){
                System.out.printf("|%-12s|%-12s|%-12s|%-12s|%-12s|\n",nameArray[i],numberArray[i],companyArray[i],salaryArray[i],BirthdayArray[i]);
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

