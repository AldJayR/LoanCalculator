
public class Loan {

    private double principalAmount;
    private double annualInterestRate;
    private int loanTerm;

    public Loan(double principalAmount, double annualInterestRate, int loanTerm) {
        this.principalAmount = principalAmount;
        this.annualInterestRate = annualInterestRate;
        this.loanTerm = loanTerm;
    }

    public double getPrincipalAmount() {
        return this.principalAmount;
    }

    public double getAnnualInterestRate() {
        return this.annualInterestRate;
    }

    public int getLoanTerm() {
        return this.loanTerm;
    }
}
