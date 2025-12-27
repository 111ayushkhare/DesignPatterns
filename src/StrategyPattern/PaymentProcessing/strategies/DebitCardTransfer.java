package strategy.paymentprocessing.strategies;

public class DebitCardTransfer implements PaymentStrategyI {
	private final String cardName;

	public DebitCardTransfer(String cardName) {
		this.cardName = cardName;
	}

	@Override
	public void makePayment(double amount) {
		System.out.println("Payment of " + amount + " processed via " + this.cardName + " DebitCard.");
	}
}