package StrategyPaymentProcessing.strategies; 

public class UPITransfer implements PaymentStrategyI {
	private final String bankName;

	public UPITransfer(String bankName) {
		this.bankName = bankName;
	}

	@Override
	public void makePayment(double amount) {
		System.out.println("Payment of " + amount + " successful via " + this.bankName + " UPI transfer"); 
	}
}