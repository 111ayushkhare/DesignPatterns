package StrategyPaymentProcessing.strategies;
 
public class CreditCardTransfer implements PaymentStrategyI {
	private final String cardName;

	public CreditCardTransfer(String cardName) {
		this.cardName = cardName;
	}

	@Override
	public void makePayment(double amount) {
		System.out.println("Payment of " + amount + " successful via " + this.cardName + " credit card."); 
	}
}