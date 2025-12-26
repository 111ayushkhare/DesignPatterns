package strategypaymentprocessing;

import strategypaymentprocessing.strategies.*;
import strategypaymentprocessing.enums.PaymentModes;


class PaymentContext {
	private PaymentStrategyI strategy;

	private void setStrategy(PaymentStrategyI strategy) {
		this.strategy = strategy;
	} 

	private void executeStrategy(PaymentStrategyI strategy, double amount) {
		this.setStrategy(strategy);
		this.strategy.makePayment(amount);
	}

	void doTransfer(PaymentModes paymentMode, String bank, double amount) {
		switch (paymentMode) {
			case PaymentModes.UPI -> this.executeStrategy(new UPITransfer(bank), amount);
			case PaymentModes.CREDIT_CARD -> this.executeStrategy(new CreditCardTransfer(bank), amount);
			case PaymentModes.DEBIT_CARD -> this.executeStrategy(new DebitCardTransfer(bank), amount);
			case PaymentModes.NET_BANKING -> this.executeStrategy(new NetBankingTransfer(bank), amount);
			default -> System.out.println("Invalid payment mode");
		};
	}
}
