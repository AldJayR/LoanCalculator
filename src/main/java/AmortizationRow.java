
public class AmortizationRow {

    private int month;
    private double principalPayment;
    private double interestPayment;
    private double remainingBalance;

    public AmortizationRow(int month, double principalPayment, double interestPayment, double remainingBalance) {
        this.month = month;
        this.principalPayment = principalPayment;
        this.interestPayment = interestPayment;
        this.remainingBalance = remainingBalance;
    }

    public int getMonth() {
        return month;
    }

    public double getPrincipalPayment() {
        return principalPayment;
    }

    public double getInterestPayment() {
        return interestPayment;
    }

    public double getRemainingBalance() {
        return remainingBalance;
    }

    @Override
    public String toString() {
        return "Month: " + month + "\nPrincipal Payment: " + principalPayment + "\nInterest Payment: " + interestPayment + "\nRemaining Balance: " + remainingBalance;
    }
}
