package StrategyPaymentProcessing.strategies;

public class NetBankingTransfer implements PaymentStrategyI {
	private final String bankName;

	public NetBankingTransfer(String bankName) {
		this.bankName = bankName;
	}

	@Override
	public void makePayment(double amount) {
		System.out.println("Payment of " + amount + " successful via " + this.bankName + " NetBanking"); 
	}
}