import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String choiceString;
        int choice = 0;
        Method method = new Method();
        CheckingAccount checkingAccount = new CheckingAccount();
        SavingAccount savingAccount = new SavingAccount();

        do {
            method.DisplayMenu();
            System.out.print("Enter your choice: ");
            choiceString = sc.nextLine();
            boolean validationCases = Pattern.matches("[0-9]{1,2}", choiceString);
            if (validationCases) {
                choice = Integer.parseInt(choiceString);
                switch (choice) {
                    case 1:{
                        method.createAccount(checkingAccount,savingAccount);
                        break;
                    }
                    case 2:{
                        method.deposit(checkingAccount,savingAccount);
                        break;
                    }
                    case 3:{
                        method.withdraw(checkingAccount,savingAccount);
                        break;
                    }
                    case 4:{
                        method.transfer(checkingAccount,savingAccount);
                    }
                    case 5:{
                        method.displayAccount(checkingAccount,savingAccount);
                        break;
                    }
                    case 6:{

                    }
                    case 7:{
                        System.out.println("Bye Bye");
                        break;
                    }
                    default:{
                        System.out.println(Method.RED+"Invalid choice"+Method.RED);
                    }
                }
            }else {
                System.out.println(Method.RED+"Invalid choice"+Method.RED);
            }
        }while (choice!=7);
    }
}