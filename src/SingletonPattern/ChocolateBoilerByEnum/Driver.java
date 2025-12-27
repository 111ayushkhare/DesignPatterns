package singleton.chocolateboilerbyenum;


import singleton.chocolateboilerbyenum.enums.ChocolateBoiler;

public class Driver {
	public static void main(String[] args) {
		ChocolateBoiler boiler = ChocolateBoiler.INSTANCE;

		boiler.fill();
		boiler.drain();
		boiler.boil();
	} 
} 
