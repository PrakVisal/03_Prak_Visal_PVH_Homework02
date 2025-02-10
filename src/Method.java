import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Method {
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String YELLOW = "\u001B[33m";
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    Scanner sc = new Scanner(System.in);
    String choiceString;
    String optionString;
    int choice;
    private String username;
    private String gender;
    private String phoneNumber;
    private String dateOfBirth;
    private String accountType;
    private double balance;
    private boolean CheckingAccountActive = true;
    private boolean SavingAccountActive = true;
//    boolean validationCases = Pattern.matches("[0-9]{1,2}", choiceString);
//    CheckingAccount checkingAccount = new CheckingAccount();
//    SavingAccount savingAccount = new SavingAccount();

    public void DisplayMenu(){
        System.out.println(YELLOW+"===========|>Welcome to the Bank Management System<|==========="+RESET);
        System.out.println("1- Create Account");
        System.out.println("2- Deposit Money");
        System.out.println("3- Withdraw Money");
        System.out.println("4- Transfer Money");
        System.out.println("5- Display Account Information");
        System.out.println("6- Delete Account");
        System.out.println("7- Exit");
    }
    public void inputData(Account account){
             while (true){
                 System.out.print("Enter Username: ");
                 username = sc.nextLine();
                 boolean validUsername = Pattern.matches("^[a-zA-Z0-9_]{3,16}$", username);
                 if (validUsername){
                     break;
                 }else {
                     System.out.println(RED+"Invalid Username"+RESET);
                 }
             }
             while (true){
                 System.out.print("Enter Gender: ");
                 gender = sc.nextLine();
                 boolean validGender = Pattern.matches("^[MmFf]$", gender);
                 if (validGender){
                     break;
                 }else {
                     System.out.println(RED+"Invalid Gender"+RESET);
                 }
             }
             while (true){
                 System.out.print("Enter Date of birth: ");
                 dateOfBirth = sc.nextLine();
                 boolean validDateOfBirth = Pattern.matches("^[0-9]{1,2}-[0-9]{1,2}-[0-9]{4}$", dateOfBirth);
                 if (validDateOfBirth){
                     break;
                 }else {
                     System.out.println(RED+"Invalid Date of birth"+RESET);
                 }
             }
             while (true){
                 System.out.print("Enter Phone Number: ");
                 phoneNumber = sc.nextLine();
                 boolean validPhoneNumber = Pattern.matches("^(0)[0-9]{8,9}$", phoneNumber);
                 if (validPhoneNumber){
                     break;
                 }
                 else {
                     System.out.println(RED+"Invalid Phone Number"+RESET);
                 }
             }
             account.setUsername(username);
             account.setGender(gender);
             account.setDateOfBirth(dateOfBirth);
             account.setPhoneNumber(phoneNumber);
             account.setBalance(balance);
             System.out.println(GREEN+"======================================="+RESET);
             System.out.println(GREEN+"|Your "+ accountType +" has been created"+RESET);
             System.out.println(GREEN+"======================================="+RESET);
    }
    public static void checkingOrsaving(String title){
        System.out.println(GREEN+"===|> "+title+" Account"+RESET);
        System.out.println("1- Checking Account");
        System.out.println("2- Saving Account");
        System.out.println("3- Exiting Program");
        System.out.println(GREEN+"======================================="+RESET);
        System.out.println(YELLOW+"What type of account do you want to use?"+RESET);
        System.out.print("=> Choose type of account : ");
    }
    public void createAccount(CheckingAccount checkingAccount , SavingAccount savingAccount) {
        do{
            checkingOrsaving("Create");
            choiceString = sc.nextLine();
            boolean validationCases = Pattern.matches("[0-9]{1,2}", choiceString);
            if (validationCases){
                choice = Integer.parseInt(choiceString);
                switch (choice){
                    case 1:{
                        accountType = "Checking Account";
                        if (CheckingAccountActive){
                            inputData(checkingAccount);
                            CheckingAccountActive = false;
                        }
                        else {
                            System.out.println(RED+"Your "+accountType+" is already created"+RESET);
                        }
                        break;
                    }
                    case 2:{
                        accountType = "Saving Account";
                        if (SavingAccountActive){
                            inputData(savingAccount);
                            SavingAccountActive = false;
                        }else {
                            System.out.println(RED+"Your "+accountType+" is already created"+RESET);
                        }
                        break;
                    }
                    case 3:{
                        System.out.println(YELLOW+"Exiting Program...."+RESET);
                        break;
                    }
                    default:{
                        System.out.println(RED+"Invalid choice><"+RESET);
                    }
                }
            }else {
                System.out.println(RED+"Invalid choice please enter number option"+RESET);
            }

        }while (choice!=3);
    }
    public void displayAccount(CheckingAccount checkingAccount, SavingAccount savingAccount) {
        if(checkingAccount.getUsername() == null && savingAccount.getUsername() == null){
            System.out.println(Method.RED+"You are not logged in"+Method.RESET);
        }else {
            if(checkingAccount.getUsername() == null){
                savingAccount.displayAccountInfo();
            }else if(savingAccount.getUsername() == null){
                checkingAccount.displayAccountInfo();
            }else {
                checkingAccount.displayAccountInfo();
                savingAccount.displayAccountInfo();
            }
        }
    }
    public void deposit(CheckingAccount checkingAccount, SavingAccount savingAccount) {
        do {
            checkingOrsaving("Deposit");
            choiceString = sc.nextLine();
            boolean validationCases = Pattern.matches("[0-9]{1,2}", choiceString);
            if(validationCases){
                choice = Integer.parseInt(choiceString);
                switch (choice){
                    case 1:{
                        System.out.print("Enter amount to deposit: ");
                        String amountString = sc.nextLine();
                        double amount = Double.parseDouble(amountString);
                        checkingAccount.deposit(amount);
                        break;
                    }
                    case 2:{
                        System.out.print("Enter amount to deposit: ");
                        String amountString = sc.nextLine();
                        double amount = Double.parseDouble(amountString);
                        savingAccount.deposit(amount);
                        break;
                    }
                    case 3:{
                        System.out.println(YELLOW+"Exiting Program...."+RESET);
                        break;
                    }
                    default:{
                        System.out.println(RED+"Invalid choice><"+RESET);
                    }
                }
            }else {
                System.out.println(RED+"Invalid choice please enter number option"+RESET);
            }
        }while (choice!=3);
    }
    public void withdraw(CheckingAccount checkingAccount, SavingAccount savingAccount) {
        do {
            checkingOrsaving("Withdraw");
            choiceString = sc.nextLine();
            boolean validationCases = Pattern.matches("[0-9]{1,2}", choiceString);
            if(validationCases){
                choice = Integer.parseInt(choiceString);
                switch (choice){
                    case 1:{
                        System.out.print("Enter amount to withdraw: ");
                        String amountString = sc.nextLine();
                        double amount = Double.parseDouble(amountString);
                        checkingAccount.withdraw(amount);
                        break;
                    }
                    case 2:{
                        System.out.print("Enter amount to withdraw: ");
                        String amountString = sc.nextLine();
                        double amount = Double.parseDouble(amountString);
                        savingAccount.withdraw(amount);
                        break;
                    }
                    case 3:{
                        System.out.println(YELLOW+"Exiting Program...."+RESET);
                        break;
                    }
                    default:{
                        System.out.println(RED+"Invalid choice><"+RESET);
                    }
                }
            }else {
                System.out.println(RED+"Invalid choice please enter number option"+RESET);
            }
        }while (choice!=3);
    }
    public void transfer(CheckingAccount checkingAccount, SavingAccount savingAccount) {
        do {
            System.out.println("===|> Transfer Account");
            System.out.println("1- Checking Account -> Saving Account");
            System.out.println("2- Saving Account -> Checking Account");
            System.out.println("3- Exiting Program");
            System.out.println("=======================================");
            System.out.println("What type of account do you want to transfer?");
            System.out.print("=> Choose type of account : ");
            choiceString = sc.nextLine();
            boolean validationCases = Pattern.matches("[0-9]{1,2}", choiceString);
            if(validationCases){
                choice = Integer.parseInt(choiceString);
                switch (choice){
                    case 1:{
                        System.out.print("Enter amount to transfer: ");
                        String amountString = sc.nextLine();
                        double amount = Double.parseDouble(amountString);
                        checkingAccount.transfer(amount,savingAccount);
                        break;
                    }
                    case 2:{
                        System.out.print("Enter amount to transfer: ");
                        String amountString = sc.nextLine();
                        double amount = Double.parseDouble(amountString);
                        savingAccount.transfer(amount,checkingAccount);
                        break;
                    }
                    case 3:{
                        System.out.println(YELLOW+"Exiting Program...."+RESET);
                        break;
                    }
                    default:{
                        System.out.println(RED+"Invalid choice><"+RESET);
                    }
                }
            }else {
                System.out.println(RED+"Invalid choice please enter number option"+RESET);
            }
        }while (choice!=3);
    }

}
