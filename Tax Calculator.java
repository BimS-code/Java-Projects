import java.util.Scanner;
public class Main{
    public static void main(String[] args) {

        System.out.println("1.WithHolding Tax\n2.Payable Tax\n3.Income Tax\n4.SSCL Tax\n5.Leasing Payment\n6.Exit");
        Scanner scanner = new Scanner(System.in);
        String repeat = "yes";
        while (repeat.equalsIgnoreCase("yes")) {
            System.out.print("Your Selection:");
            int type = scanner.nextInt();
            switch (type) {
                case 1:
                    System.out.println("1.Rent Tax\n2.Bank Interet Tax\n3.Dividened Tax");
                    Scanner x1 = new Scanner(System.in);
                    System.out.print("Your Selection:");
                    int type1 = x1.nextInt();
                    if (type1 == 1) {
                        Scanner R = new Scanner(System.in);
                        System.out.print("Enter Your Rent:");
                        double Rent = R.nextDouble();
                        double PayRent = Rent * 0.1;
                        if (Rent > 100000) {
                            System.out.println("You have to pay Tax:" + PayRent);
                        } else {
                            System.out.println("You do not have To Pay Tax ");
                        }
                    }

                    if (type1 == 2) {
                        Scanner I = new Scanner(System.in);
                        System.out.print("Enter Your Bank Interest Per Year:");
                        double Interest = I.nextDouble();
                        double PayInterest = Interest * 0.05;
                        System.out.println("You have to pay Bank Interest Tax:" + PayInterest);
                    }
                    if (type1 == 3) {
                        Scanner D = new Scanner(System.in);
                        System.out.print("Enter Your Total Dividened PEr Year:");
                        double Dividend = D.nextDouble();
                        double PayDiv = Dividend * 0.14;
                        if (Dividend > 100000) {
                            System.out.println("You have to pay Dividend Tax:" + PayDiv);
                        } else {
                            System.out.println("You do not have To Pay Dividend Tax ");
                        }


                    }
                    Scanner RP = new Scanner(System.in);

                    System.out.print("Do you want to calculate another tax?\n1.Yes\n2.No\n");
                    repeat = RP.nextLine();
                    break;


                case 2:
                    Scanner P = new Scanner(System.in);
                    while (true) {
                        System.out.print("Enter Your employee payment per month:");
                        double Payable = P.nextDouble();
                        double PayCon1 = Payable * 0.6;
                        double PayCon2 = Payable * 0.12;
                        double PayCon3 = Payable * 0.18;
                        double PayCon4 = Payable * 0.24;
                        double PayCon5 = Payable * 0.30;
                        double PayCon6 = Payable * 0.36;
                        if (Payable > 100000 && Payable <= 141667) {
                            System.out.println("You have to pay payable Tax per month:" + PayCon1);
                        } else if (Payable > 141667 && Payable <= 183333) {
                            System.out.println("You have to pay payable Tax per month:" + PayCon2);
                        } else if (Payable > 183333 && Payable <= 225000) {
                            System.out.println("You have to pay payable Tax per month:" + PayCon3);
                        } else if (Payable > 225000 && Payable <= 266667) {
                            System.out.println("You have to pay payable Tax per month:" + PayCon4);
                        } else if (Payable > 266667 && Payable <= 308333) {
                            System.out.println("You have to pay payable Tax per month:" + PayCon5);
                        } else if (Payable > 308333) {
                            System.out.println("You have to pay payable Tax per month:" + PayCon6);
                        } else {
                            System.out.println("You do not have to pay Tax");
                        }


                    Scanner RP1 = new Scanner(System.in);

                    System.out.print("Do you want to calculate another tax?\n1.Yes\n2.No\n");
                    repeat = RP1.nextLine();
                    break;
                    }
                    break;

                case 3:
                    Scanner IC = new Scanner(System.in);
                    while(true) {
                        System.out.print("Enter Your total income per year:");
                        double PayIncome = IC.nextDouble();
                        double PayIn1 = PayIncome * 0.6;
                        double PayIn2 = PayIncome * 0.12;
                        double PayIn3 = PayIncome * 0.18;
                        double PayIn4 = PayIncome * 0.24;
                        double PayIn5 = PayIncome * 0.30;
                        double PayIn6 = PayIncome * 0.36;
                        if (PayIncome > 1200000 && PayIncome <= 1700000) {
                            System.out.println("You have to pay Income Tax per month:" + PayIn1);
                        } else if (PayIncome > 1700000 && PayIncome <= 2200000) {
                            System.out.println("You have to pay Income Tax per month:" + PayIn2);
                        } else if (PayIncome > 2200000 && PayIncome <= 2700000) {
                            System.out.println("You have to pay Income Tax per month:" + PayIn3);
                        } else if (PayIncome > 2700000 && PayIncome <= 3200000) {
                            System.out.println("You have to pay Income Tax per month:" + PayIn4);
                        } else if (PayIncome > 3200000 && PayIncome <= 3700000) {
                            System.out.println("You have to pay Income Tax per month:" + PayIn5);
                        } else if (PayIncome > 3700000) {
                            System.out.println("You have to pay Income Tax per month:" + PayIn6);
                        } else {
                            System.out.println("You do not have to pay Income Tax");
                        }


                    Scanner RP3 = new Scanner(System.in);

                    System.out.print("Do you want to calculate another tax?\n1.Yes\n2.No\n");
                    repeat = RP3.nextLine();
                    break;
                    }
                    break;

                case 4:
                    Scanner SSCL = new Scanner(System.in);
                    System.out.print("Enter Value of Good or Service:");
                    double SSCLTAX = SSCL.nextDouble();
                    double SaleTax = SSCLTAX * 0.025;
                    double VAT = SaleTax * 0.15;
                    double TotalSSCL = SaleTax + VAT;
                    System.out.println("You have to total SSCL Tax:" + TotalSSCL);
                    //Repeat
                    Scanner RP4 = new Scanner(System.in);
                    System.out.print("Do you want to calculate another tax?\n1.Yes\n2.No\n");
                    repeat = RP4.nextLine();
                    break;
                case 5:
                    System.out.println("1.Monthly Installment\n2.Serch Leasing Category\n3.Leasing Amount");
                    Scanner x5 = new Scanner(System.in);
                    System.out.print("Your Selection:");
                    int Ltype1 = x5.nextInt();
                    if (Ltype1 == 1) {
                        Scanner MII1 = new Scanner(System.in);
                        System.out.print("Enter Lease amount:");
                        double LeaseAmount = MII1.nextDouble();
                        Scanner MII2 = new Scanner(System.in);
                        System.out.print("Enter annual interest rate:");
                        double Rate = MII2.nextDouble();
                        Scanner MII3 = new Scanner(System.in);
                        System.out.print("Enter number of years:");
                        int NoOfYears = MII3.nextInt();
                        double M = 12 * NoOfYears;
                        if (NoOfYears > 5) {
                            System.out.println("Invalid No of years.....Try again");
                        } else {
                            double i = Rate / 12;
                            double Power = (int) Math.pow((1 + i), M);
                            double PayMI = (LeaseAmount * i) / (1 - (1 / Power));
                            System.out.println("Your monthly installment:" + PayMI);
                        }
                    }
                    if (Ltype1 == 2) {
                        Scanner SII1 = new Scanner(System.in);
                        System.out.print("Enter Lease amount:");
                        double LeaseAmount = SII1.nextDouble();
                        Scanner SII2 = new Scanner(System.in);
                        System.out.print("Enter annual interest rate:");
                        double Rate = SII2.nextDouble();
                        double i = Rate / 12;
                        double Power1 = (int) Math.pow((1 + i), 36);
                        double Power2 = (int) Math.pow((1 + i), 48);
                        double Power3 = (int) Math.pow((1 + i), 60);

                        double PayMI3 = (LeaseAmount * i) / (1 - (1 / Power1));
                        double PayMI4 = (LeaseAmount * i) / (1 - (1 / Power2));
                        double PayMI5 = (LeaseAmount * i) / (1 - (1 / Power3));
                        System.out.println("Your monthly installment for 3 year leasing plan:" + PayMI3);
                        System.out.println("Your monthly installment for 4 year leasing plan:" + PayMI4);
                        System.out.println("Your monthly installment for 5 year leasing plan:" + PayMI5);
                    }
                    if (Ltype1 == 3) {
                        Scanner FII1 = new Scanner(System.in);
                        System.out.print("Enter the monthly lease amount that you can afford:");
                        double MLeaseAmount = FII1.nextDouble();
                        Scanner FII2 = new Scanner(System.in);
                        System.out.print("Enter annual interest rate:");
                        double Rate = FII2.nextDouble();
                        Scanner FII3 = new Scanner(System.in);
                        System.out.print("Enter number of years:");
                        int NoOfYears = FII3.nextInt();
                        double M = 12 * NoOfYears;
                        double i = Rate / 12;
                        double Power = (int) Math.pow((1 + i), M);
                        double LA = (MLeaseAmount * (1 - (1 / Power))) / i;
                        System.out.println("You can get lease Amount:" + LA);
                    }
                    Scanner RP5 = new Scanner(System.in);

                    System.out.print("Do you want to calculate another tax?\n1.Yes\n2.No\n");
                    repeat = RP5.nextLine();
                    break;

                case 6:
                    break;
            }

        }
    }}

