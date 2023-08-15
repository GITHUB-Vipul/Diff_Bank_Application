import java.util.UUID;

public class SBIAccount implements BankAccountInterface {
    private String name;
    final int minbalance=500;
    private String password;
    private String accountNo;
    final double rateOfInterest=6.5;
    private double balance;
    final String IFSCcode="SBI00000372";

    public SBIAccount() {
    }

    public SBIAccount(String name, String password, double balance) {
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

    public int getMinbalance() {
        return minbalance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getRateOfInterest() {
        return rateOfInterest;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getIFSCcode() {
        return IFSCcode;
    }

    @Override
    public String fetchBalance(String password) {
        if(this.password.equals(password))
        {
            return "your balance is "+this.balance;
        }
        return "Incorrect password";
    }

    @Override
    public String addMoney(double Amount) {
        this.balance+=Amount;
        return " Money deposited successfully";
    }

    @Override
    public String withdrawMoney(double Amount, String password) {
        if(this.password.equals(password))
        {
            if(Amount>this.balance)
            {
                return "Insufficient Fund";
            }
            else if((this.balance-Amount)<this.minbalance)
            {
                return "Can't withdraw Money reached minBalance limit";
            }
            this.balance-=Amount;
            return " Take your money....."+"Current balance"+this.balance;
        }
        return "Incorrect Password";
    }

    @Override
    public String changePassword(String oldPassword, String newPassword) {
        if(this.password.equals(oldPassword))
        {
            this.password=newPassword;
                    return " Password changed successfully";
        }
        return "Incorrect Password";
    }

    @Override
    public double calculateInterest(int year) {
        return 0;
    }

    @Override
    public String toString() {
        return "SBIAccount{" +
                "name='" + name + '\'' +
                ", minbalance=" + minbalance +
                ", password='" + password + '\'' +
                ", accountNo='" + accountNo + '\'' +
                ", rateOfInterest=" + rateOfInterest +
                ", balance=" + balance +
                ", IFSCcode='" + IFSCcode + '\'' +
                '}';
    }
}
