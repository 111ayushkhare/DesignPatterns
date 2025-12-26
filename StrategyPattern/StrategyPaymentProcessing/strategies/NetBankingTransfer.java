package strategypaymentprocessing.strategies;

public class NetBankingTransfer implements PaymentStrategyI {
	private final String bankName;

	public NetBankingTransfer(String bankName) {
		this.bankName = bankName;
	}

	@Override
	public void makePayment(double amount) {
		System.out.println("Payment of " + amount + " processed via " + this.bankName + " NetBanking.");
	}
}