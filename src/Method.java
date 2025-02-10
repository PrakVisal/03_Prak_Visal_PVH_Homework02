
import java.util.Scanner;
import java.util.regex.Pattern;
import java.time.LocalDate;
public class Method {
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String YELLOW = "\u001B[33m";
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    Scanner sc = new Scanner(System.in);
    String choiceString;
    int choice;
    private String username;
    private String gender;
    private String phoneNumber;
    private String dateOfBirth;
    private String accountType;
    private double balance;
    private String regexDigit = "[0-9]+";
    private boolean CheckingAccountActive = true;
    private boolean SavingAccountActive = true;

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
                 System.out.print("Enter Gender(M/F): ");
                 gender = sc.nextLine();
                 boolean validGender = Pattern.matches("^[MmFf]$", gender);
                 if (validGender){
                     break;
                 }else {
                     System.out.println(RED+"Invalid Gender"+RESET);
                 }
             }
             while (true){
                 System.out.print("Enter Date of birth(dd-MM-yyyy): ");
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
                     System.out.println(RED+"Invalid Phone Number it must start from 0 and 9-10 digits"+RESET);
                 }
             }
             account.setUsername(username);
             account.setGender(gender);
             account.setDateOfBirth(dateOfBirth);
             account.setPhoneNumber(phoneNumber);
             account.setBalance(balance);
             System.out.println(GREEN+"======================================="+RESET);
             System.out.println(GREEN+"Your "+ accountType +" has been created"+RESET);
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
                        while (true){
                            if(checkingAccount.getUsername()!=null){
                                System.out.print("Enter amount to deposit: ");
                                String amountString = sc.nextLine();
                                boolean validationDigits = Pattern.matches(regexDigit, amountString);
                                if (validationDigits){
                                    double amount = Double.parseDouble(amountString);
                                    checkingAccount.deposit(amount);
                                    break;
                                }else {
                                    System.out.println(RED+"Invalid amount"+RESET);
                                }

                            }else {
                                System.out.println(RED+"You are not logged in to Checking Account"+RESET);
                                break;
                            }
                        }
                        break;
                    }
                    case 2:{
                        while (true){
                            if(savingAccount.getUsername()!=null){
                                System.out.print("Enter amount to deposit: ");
                                String amountString = sc.nextLine();
                                boolean validationDigits = Pattern.matches(regexDigit, amountString);
                                if (validationDigits){
                                    double amount = Double.parseDouble(amountString);
                                    savingAccount.deposit(amount);
                                    break;
                                }else {
                                    System.out.println(RED+"Invalid amount"+RESET);
                                }
                            }
                            else {
                                System.out.println(RED+"You are not logged in to Saving Account"+RESET);
                                break;
                            }
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
    public void withdraw(CheckingAccount checkingAccount, SavingAccount savingAccount) {
        do {
            checkingOrsaving("Withdraw");
            choiceString = sc.nextLine();
            boolean validationCases = Pattern.matches("[0-9]{1,2}", choiceString);
            if(validationCases){
                choice = Integer.parseInt(choiceString);
                switch (choice){
                    case 1:{
                        if(checkingAccount.getBalance()!=0){
                            while (true){
                                System.out.print("Enter amount to withdraw: ");
                                String amountString = sc.nextLine();
                                boolean validationWithdrawal = Pattern.matches("[0-9]+",amountString);
                                if(validationWithdrawal){
                                    double amount = Double.parseDouble(amountString);
                                    checkingAccount.withdraw(amount);
                                    break;
                                }else {
                                    System.out.println(RED+"Invalid amount"+RESET);
                                }
                            }
                        }else {
                            System.out.println(RED+"You are not logged in to Checking Account or Your balance is $0"+Method.RESET);
                            System.out.println();
                        }
                        break;
                    }
                    case 2:{
                        if(savingAccount.getBalance()!=0){
                            while (true){
                                System.out.print("Enter amount to withdraw: ");
                                String amountString = sc.nextLine();
                                boolean validationWithdrawal = Pattern.matches("[0-9]+",amountString);
                                if(validationWithdrawal){
                                    double amount = Double.parseDouble(amountString);
                                    savingAccount.withdraw(amount);
                                    break;
                                }else {
                                    System.out.println(RED+"Invalid amount"+RESET);
                                }
                            }
                        }else {
                            System.out.println(RED+"You are not logged in to Saving Account or Your balance is $0"+Method.RESET);
                            System.out.println();
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
    public void transfer(CheckingAccount checkingAccount, SavingAccount savingAccount) {
        do {
            System.out.println(CYAN+"===|> Transfer Account"+RESET);
            System.out.println("1- Checking Account -> Saving Account");
            System.out.println("2- Saving Account -> Checking Account");
            System.out.println("3- Exiting Program");
            System.out.println(CYAN+"======================================="+RESET);
            System.out.println("What type of account do you want to transfer?");
            System.out.print("=> Choose type of account : ");
            choiceString = sc.nextLine();
            boolean validationCases = Pattern.matches("[0-9]{1,2}", choiceString);
            if(validationCases){
                choice = Integer.parseInt(choiceString);
                if(checkingAccount.getUsername()!=null && savingAccount.getUsername()!=null){
                    switch (choice){
                        case 1:{
                            if(checkingAccount.getBalance()!=0){
                                System.out.print("Enter amount to transfer: ");
                                String amountString = sc.nextLine();
                                boolean validationDigit = Pattern.matches(regexDigit, amountString);
                                if(validationDigit){
                                    double amount = Double.parseDouble(amountString);
                                    checkingAccount.transfer(amount,savingAccount);
                                    break;
                                }else {
                                    System.out.println(RED+"Invalid amount"+RESET);
                                    continue;
                                }
                            }else {
                                System.out.println(RED+"Your Balance is $0"+RESET);
                            }
                            break;
                        }
                        case 2:{
                            if(savingAccount.getBalance()!=0){
                                System.out.print("Enter amount to transfer: ");
                                String amountString = sc.nextLine();
                                boolean validationDigit = Pattern.matches(regexDigit, amountString);
                                if(validationDigit){
                                    double amount = Double.parseDouble(amountString);
                                    savingAccount.transfer(amount,checkingAccount);
                                    break;
                                }else {
                                    System.out.println(RED+"Invalid amount"+RESET);
                                    continue;
                                }
                            }else {
                                System.out.println(RED+"Your Balance is $0"+RESET);
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
                }else if(choice==3){
                    System.out.println(YELLOW+"Exiting Program...."+RESET);
                }else{
                    System.out.println(RED+"You must have both account Checking Account and Saving Account to Transfer"+RESET);
                }
            }else {
                System.out.println(RED+"Invalid choice please enter number option"+RESET);
            }
        }while (choice!=3);
    }
    public void deleteAccount(CheckingAccount checkingAccount, SavingAccount savingAccount) {
        do {
            checkingOrsaving("Delete");
            choiceString = sc.nextLine();
            boolean validationCases = Pattern.matches("[0-9]{1,2}", choiceString);
            if(validationCases){
                choice = Integer.parseInt(choiceString);
                if(checkingAccount.getUsername()!=null && savingAccount.getUsername()!=null){
                        switch (choice){
                            case 1:{
                                while (true){
                                    System.out.println("Are you sure you want to delete this account?(Y/N)");
                                    System.out.print("=> ");
                                    String YesorNo = sc.nextLine();
                                    boolean vallidationYN = Pattern.matches("[yYnN]",YesorNo);
                                    if(vallidationYN){
                                        if(YesorNo.equalsIgnoreCase("y")){
                                            checkingAccount.deleteAccount();
                                            checkingAccount.transfer(checkingAccount.getBalance(),savingAccount);
                                            System.out.println(GREEN+"All money transfer to saving account $"+checkingAccount.getBalance()+RESET);
                                            System.out.println(GREEN+"Account deleted successfully"+RESET);
                                            CheckingAccountActive = true;
                                            break;
                                        }else if(YesorNo.equalsIgnoreCase("n")){
                                            break;
                                        }
                                    }else {
                                        System.out.println(RED+"Invalid! Enter (Y/N)"+RESET);
                                        continue;
                                    }
                                    break;
                                }
                                break;
                            }
                            case 2:{
                                while (true){
                                    System.out.println("Are you sure you want to delete this account?(Y/N)");
                                    System.out.print("=> ");
                                    String YesorNo = sc.nextLine();
                                    boolean vallidationYN = Pattern.matches("[yYnN]",YesorNo);
                                    if(vallidationYN){
                                        if(YesorNo.equalsIgnoreCase("y")){
                                            savingAccount.deleteAccount();
                                            savingAccount.transfer(savingAccount.getBalance(),checkingAccount);
                                            System.out.println(GREEN+"All money transfer to checking account"+RESET);
                                            System.out.println(GREEN+"Account deleted successfully"+RESET);
                                            SavingAccountActive = true;
                                            break;
                                        }else if(YesorNo.equalsIgnoreCase("n")){
                                            break;
                                        }
                                    }else {
                                        System.out.println(RED+"Invalid! Enter (Y/N)"+RESET);
                                        continue;
                                    }
                                    break;
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
                    System.out.println(RED+"You don't have any Account to delete"+RESET);
                }
            }else {
                System.out.println(RED+"Invalid choice please enter number option"+RESET);
            }
        }while (choice!=3);
    }

}
