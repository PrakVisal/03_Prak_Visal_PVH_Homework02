public interface Account {

    void deposit(double amount);
    void withdraw(double amount);
    void transfer(double amount, Account targetAccount);
    void displayAccountInfo();

    void setUsername(String username);
    void setGender(String gender);
    void setPhoneNumber(String phoneNumber);
    void setDateOfBirth(String dateOfBirth);
    String getAccountType();
    String getUsername();
    String getGender();
    String getPhoneNumber();
    String getDateOfBirth();
    double getBalance();
    void setBalance(double balance);
}
