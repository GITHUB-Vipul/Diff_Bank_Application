import java.util.UUID;

public class HDFCAccount implements BankAccountInterface{
    private String name;
    private String accountNo;
    final String IFSCcode="HDFC0001";
    private String password;
    private double balance;
    final double rateOfInterest=7.1;
     //default constructor
    public HDFCAccount() {
    }
    // paramaterized constructor
    public HDFCAccount(String name, String password, double balance) {
        this.name = name;
        this.password = password;
        this.balance = balance;
        this.accountNo=String.valueOf(UUID.randomUUID());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getIFSCcode() {
        return IFSCcode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getRateOfInterest() {
        return rateOfInterest;
    }

    @Override
    public String fetchBalance(String password) {
        if(this.password.equals(password))
            return "your balance is"+balance;
        else
            return "Incorrect password";
    }

    @Override
    public String addMoney(double Amount) {
        return null;
    }

    @Override
    public String withdrawMoney(double Amount, String password) {
        if(this.password.equals(password))
        {
            if(Amount>this.balance)return "insufficient balance";
            this.balance-=Amount;
            return "Take your money....."+"Balance is"+this.balance;
        }
        return "Incorrect Password";
    }

    @Override
    public String changePassword(String oldPassword, String newPassword) {
        if(this.password.equals(oldPassword))
        {
            this.password=newPassword;
            return "password changed successfully";
        }
        return "Incorrect Password";
    }

    @Override
    public double calculateInterest(int year) {
        return this.balance*year*this.rateOfInterest/100.0;
    }

    @Override
    public String toString() {
        return "HDFCAccount{" +
                "name='" + name + '\'' +
                ", accountNo='" + accountNo + '\'' +
                ", IFSCcode='" + IFSCcode + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                ", rateOfInterest=" + rateOfInterest +
                '}';
    }
}
