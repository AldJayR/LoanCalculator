
import java.util.List;

public class LoanController {

    private Loan loan;
    private LoanCalculator calculator;

    public LoanController(double principalAmount, double annualInterestRate, int loanTerm) {
        this.loan = new Loan(principalAmount, annualInterestRate, loanTerm);
        this.calculator = new LoanCalculator(loan);
    }

    public double getMonthlyPayment() {
        return calculator.calculateMonthlyPayment();
    }

    public double getTotalPayment() {
        return calculator.calculateTotalPayment();
    }

    public double getTotalInterest() {
        return calculator.calculateTotalInterest();
    }

    public List<AmortizationRow> getAmortizationSchedule() {
        return calculator.generateAmortizationSchedule();
    }
}
