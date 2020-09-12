import java.util.Scanner;
import java.text.NumberFormat;

public class FutureValueWithMethodApp {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		while (!choice.equalsIgnoreCase("n")) {
			// get the input from the user
			System.out.print("Enter monthly investment:   ");
			double monthlyInvestment = sc.nextDouble();
			System.out.print("Enter yearly interest rate: ");
			double interestRate = sc.nextDouble();
			System.out.print("Enter number of years:      ");
			int years = sc.nextInt();

			// convert yearly values to monthly values
			double monthlyInterestRate = interestRate / 12 / 100;
			int months = years * 12;

			// call the future value method
			System.out.println("About to call calculateFutureValue");
			double futureValue = calculateFutureValue(monthlyInvestment, monthlyInterestRate, months);

			// format and display the result
			NumberFormat currency = NumberFormat.getCurrencyInstance();
			System.out.println("Future value:               " + currency.format(futureValue));
			System.out.println();

			// see if the user wants to continue
			System.out.print("Continue? (y/n): ");
			choice = sc.next();
			System.out.println();
		}
	}

	public static double calculateFutureValue(double monthlyInv, double monthlyInterestRate, int months) {
		System.out.println("In calculateFutureValue");
		double futureValue = 0.0;
		for (int i = 1; i <= months; i++) {
			futureValue = (futureValue + monthlyInv) * (1 + monthlyInterestRate);
		}
		System.out.println("Returning " + futureValue);
		return futureValue;
	}
}