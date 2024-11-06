
import java.text.NumberFormat;
import java.util.Locale;
import java.util.List;
import java.util.Scanner;

public class LoanApp {

    private Scanner scanner;
    private LoanController controller;
    private double principalAmount;
    private double annualInterestRate;
    private int loanTerm;
    private NumberFormat numberFormat;

    public LoanApp() {
        this.scanner = new Scanner(System.in);
        this.numberFormat = NumberFormat.getNumberInstance(Locale.US);
    }

    public void start() {
        getUserInput();
        createLoanController();
        displayLoanSummary();
        displayAmortizationSchedule();
        closeScanner();
    }

    private void getUserInput() {
        principalAmount = getPrincipalAmount();
        annualInterestRate = getAnnualInterestRate();
        loanTerm = getLoanTerm();
    }

    private double getPrincipalAmount() {
        System.out.print("Enter the loan amount (you can use commas): P");
        return Double.valueOf(scanner.nextLine().replaceAll(",", ""));
    }

    private double getAnnualInterestRate() {
        System.out.print("Enter the annual interest rate (as a decimal, e.g., 0.045 for 4.5%): ");
        return Double.valueOf(scanner.nextLine());
    }

    private int getLoanTerm() {
        System.out.print("Enter the loan term in years: ");
        return Integer.valueOf(scanner.nextLine());
    }

    private void createLoanController() {
        controller = new LoanController(principalAmount, annualInterestRate, loanTerm);
    }

    private void displayLoanSummary() {
        double monthlyPayment = controller.getMonthlyPayment();
        double totalPayment = controller.getTotalPayment();
        double totalInterest = controller.getTotalInterest();

        System.out.println("\nLoan Summary:");
        System.out.println("Monthly Payment: P" + numberFormat.format(monthlyPayment));
        System.out.println("Total Payment: P" + numberFormat.format(totalPayment));
        System.out.println("Total Interest: P" + numberFormat.format(totalInterest));
    }

    private void displayAmortizationSchedule() {
        System.out.println("\nWould you like to see the full amortization schedule? (y/n)");
        String response = scanner.next();
        if (response.equalsIgnoreCase("y")) {
            List<AmortizationRow> schedule = controller.getAmortizationSchedule();
            System.out.println("\nAmortization Schedule:");
            System.out.println("Month | Principal     | Interest     | Balance");
            for (AmortizationRow row : schedule) {
                System.out.printf("%5d | %13s | %12s | %13s%n",
                        row.getMonth(),
                        numberFormat.format(row.getPrincipalPayment()),
                        numberFormat.format(row.getInterestPayment()),
                        numberFormat.format(row.getRemainingBalance()));
            }
        }
    }

    private void closeScanner() {
        scanner.close();
    }

}
