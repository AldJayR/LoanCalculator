
import java.util.List;
import java.util.ArrayList;

public class LoanCalculator {

    private Loan loan;

    public LoanCalculator(Loan loan) {
        this.loan = loan;
    }

    public double calculateMonthlyPayment() {
        double monthlyRate = loan.getAnnualInterestRate() / 12.0;
        int numberOfPayments = loan.getLoanTerm() * 12;
        double principalAmount = loan.getPrincipalAmount();

        if (monthlyRate == 0) {
            return principalAmount / numberOfPayments;
        }

        double monthlyPayment = (principalAmount * monthlyRate * Math.pow(1 + monthlyRate, numberOfPayments))
                / (Math.pow(1 + monthlyRate, numberOfPayments) - 1);

        return Math.round(monthlyPayment * 100.0) / 100.0;
    }

    public double calculateTotalPayment() {
        return Math.round(calculateMonthlyPayment() * loan.getLoanTerm() * 12 * 100.0) / 100.0;
    }

    public double calculateTotalInterest() {
        return Math.round((calculateTotalPayment() - loan.getPrincipalAmount()) * 100.0) / 100.0;
    }

    public List<AmortizationRow> generateAmortizationSchedule() {
        List<AmortizationRow> schedule = new ArrayList<>();
        double monthlyPayment = calculateMonthlyPayment();
        double remainingBalance = loan.getPrincipalAmount();
        double monthlyRate = loan.getAnnualInterestRate() / 12.0;
        int totalMonths = loan.getLoanTerm() * 12;

        for (int month = 1; month <= totalMonths; month++) {
            double interestPayment = remainingBalance * monthlyRate;
            double principalPayment = monthlyPayment - interestPayment;
            remainingBalance -= principalPayment;

            if (remainingBalance < 0.01) {
                remainingBalance = 0;
            }

            AmortizationRow row = new AmortizationRow(
                    month,
                    Math.round(principalPayment * 100.0) / 100.0,
                    Math.round(interestPayment * 100.0) / 100.0,
                    Math.round(remainingBalance * 100.0) / 100.0
            );
            schedule.add(row);
        }

        return schedule;
    }
}
