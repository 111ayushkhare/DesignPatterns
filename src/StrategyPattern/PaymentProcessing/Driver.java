package strategy.paymentprocessing;


import strategy.paymentprocessing.enums.PaymentModes;


public class Driver {
	public static void main(String[] args) {
		PaymentContext paymentContext = new PaymentContext();

		// UPI transfer		
		paymentContext.doTransfer(PaymentModes.UPI, "ABC", 1200.23);

		// Credit Card transfer
		paymentContext.doTransfer(PaymentModes.CREDIT_CARD, "PQR", 3000.98);

		// Invalid Mode
		paymentContext.doTransfer(PaymentModes.CASH, "PQR", 6700.80);
	}
}