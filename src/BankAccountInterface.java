public interface BankAccountInterface {
    String fetchBalance(String password);
    String addMoney(double Amount);
    String withdrawMoney(double Amount,String password);
    String changePassword(String oldPassword,String newPassword);
    double calculateInterest(int year);
}
