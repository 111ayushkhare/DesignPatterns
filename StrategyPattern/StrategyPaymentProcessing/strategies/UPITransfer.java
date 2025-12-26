package strategypaymentprocessing.strategies; 

public class UPITransfer implements PaymentStrategyI {
	private final String bankName;

	public UPITransfer(String bankName) {
		this.bankName = bankName;
	}

	@Override
	public void makePayment(double amount) {
		System.out.println("Payment of " + amount + " processed via " + this.bankName + " UPI.");
	}
}