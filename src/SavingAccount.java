import java.util.Random;

public class SavingAccount implements Account {

    private String username;
    private String gender;
    private String phoneNumber;
    private String dateOfBirth;
    private String accountType = "Saving Account";
    private double balance;
    private double interestRate = 0.05;
    Random rand = new Random();
    final private int accountNumber = rand.nextInt(1000000000);

    SavingAccount(){
    }
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
        if(amount > 0){
            balance += amount;
            if(balance >= 200){
                balance += balance * interestRate;
            }
            System.out.println(Method.GREEN+"Deposited successfully $"+amount+Method.RESET);
            System.out.println(Method.GREEN+"Total balance: $"+getBalance()+Method.RESET);
            System.out.println();
        }else {
            System.out.println(Method.RED+"You don't have enough money to deposit"+Method.RESET);
        }
    }

    @Override
    public void withdraw(double amount) {
        double withdrawalLimit = balance * 0.80;
        if(amount <= withdrawalLimit) {
            balance -= amount;
            System.out.println(Method.GREEN+"Successfully withdrawn $"+amount+Method.RESET);
            System.out.println(Method.GREEN+"Total balance: $"+getBalance()+Method.RESET);
            System.out.println();
        }else{
            System.out.println(Method.RED+"Insufficient Balance (Withdrawal must be lower than or equal to 80%)"+Method.RESET);
        }
    }

    @Override
    public void transfer(double amount, Account targetAccount) {
        if (amount >0 && amount <= balance) {
            balance -= amount;
            targetAccount.setBalance(amount);
            System.out.println(Method.GREEN+"Successfully Transferred $"+amount+Method.RESET);
            System.out.println(Method.GREEN+"Total balance: $"+getBalance()+Method.RESET);
            System.out.println();
        }else {
            System.out.println(Method.RED+"Insufficient balance"+Method.RESET);
        }

    }

    @Override
    public void displayAccountInfo() {
                System.out.println(Method.YELLOW+"--------------------------------------"+Method.RESET);
                System.out.println(Method.CYAN+"===|> "+accountType+Method.RESET);
                System.out.println("Account Type: "+accountType);
                System.out.println("Account Number: "+accountNumber);
                System.out.println("Username: "+username);
                System.out.println("Date of Birth: "+dateOfBirth);
                System.out.println("Gender: "+dateOfBirth);
                System.out.println("Phone Number: "+phoneNumber);
                System.out.println(Method.GREEN+"Balance: $"+balance+Method.RESET);
                System.out.println(Method.YELLOW+"--------------------------------------"+Method.RESET);
            }
    public void deleteAccount(){
        setUsername(null);
        setGender(null);
        setPhoneNumber(null);
        setDateOfBirth(null);
        setAccountType(null);
    }
}
