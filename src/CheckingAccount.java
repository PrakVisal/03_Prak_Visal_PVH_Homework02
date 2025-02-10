import java.util.Random;
import java.util.Scanner;


public class CheckingAccount implements Account{
    private String username;
    private String gender;
    private String phoneNumber;
    private String dateOfBirth;
    private String accountType = "Checking Account";
    private double balance;
    Random rand = new Random();

//    Method method = new Method();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance += balance;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;

}

    @Override
    public void withdraw(double amount) {
        balance -= amount;
    }

    @Override
    public void transfer(double amount, Account targetAccount) {
        balance -= amount;
        targetAccount.setBalance(amount);
    }
    CheckingAccount(){

    }

    @Override
    public void displayAccountInfo() {
        System.out.println(Method.YELLOW+"--------------------------------------"+Method.RESET);
        System.out.println(Method.CYAN+"===|> "+accountType+Method.RESET);
        System.out.println("Account Type: "+accountType);
        System.out.println("Account Number: "+rand.nextInt(1000000000));
        System.out.println("Username: "+username);
        System.out.println("Date of Birth: "+dateOfBirth);
        System.out.println("Gender: "+dateOfBirth);
        System.out.println("Phone Number: "+phoneNumber);
        System.out.println(Method.GREEN+"Balance: $"+balance+Method.RESET);
        System.out.println(Method.YELLOW+"--------------------------------------"+Method.RESET);
    }
}
