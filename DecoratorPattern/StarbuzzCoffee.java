public class StarbuzzCoffee {
	public static void main(String[] args) {
		Espresso espresso = new Espresso();
		DarkRoast darkRoast = new DarkRoast();
		
		// EspressoMochaGrande
		espresso.setSize(Size.GRANDE);
		Beverage espressoMochaGrande = new Mocha(espresso);
		System.out.println("Espresso Mocha (Grande): " + espressoMochaGrande.cost());

		// EspressoSteamedMilkVenti
		espresso.setSize(Size.VENTI);
		Beverage espressoSteamedMilkVenti = new SteamedMilk(espresso);
		System.out.println("Espresso SteamedMilk (Venti): " + espressoSteamedMilkVenti.cost());

		// DarkRoastSoyTall
		Beverage darkRoastSoyTall = new Soy(darkRoast);
		System.out.println("Dark Roast Soy (Tall): " + darkRoastSoyTall.cost());
	}
}

enum Size {
	TALL, 
	GRANDE, 
	VENTI
};

// Base class
abstract class Beverage {
	private Size size = Size.TALL;

	public void setSize(Size size) {
		this.size = size;
	}
	public Size getSize() {
		return this.size;
	}

	protected abstract double cost();
}

// Coffee categories
class HouseBlend extends Beverage {
	@Override
	protected double cost() {
		return 1.19;
	}
}
class DarkRoast extends Beverage {
	@Override
	protected double cost() {
		return 1.35;
	}
}
class Decaf extends Beverage {
	@Override
	protected double cost() {
		return 1.25;
	}
}
class Espresso extends Beverage {
	@Override
	protected double cost() {
		return 1.29;
	}
}

// Decorators
abstract class FlavourDecorator extends Beverage {
	protected Beverage coffee;

	protected double addCostBySize(double baseCost, double tallCost, double grandeCost, double ventiCost) {
		switch (this.coffee.getSize()) {
			case Size.TALL:
				baseCost += tallCost;
				break;
			case Size.GRANDE: 
				baseCost += grandeCost;
				break;
			case Size.VENTI:
				baseCost += ventiCost;
				break;
			default:
				break;
		}

		return Math.round(baseCost * 100.0) / 100.0;
	}
}

class Mocha extends FlavourDecorator {
	public Mocha(Beverage coffee) {
		this.coffee = coffee;
	}

	@Override
	protected double cost() {
		return addCostBySize(this.coffee.cost(), 0.63, 0.66, 0.69);
	}
}

class Soy extends FlavourDecorator {
	public Soy(Beverage coffee) {
		this.coffee = coffee;
	}

	@Override
	protected double cost() {
		return addCostBySize(this.coffee.cost(), 0.73, 0.76, 0.79);
	}
}

class Whip extends FlavourDecorator {
	public Whip(Beverage coffee) {
		this.coffee = coffee;
	}

	@Override
	protected double cost() {
		return addCostBySize(this.coffee.cost(), 0.53, 0.56, 0.59);
	}
}

class SteamedMilk extends FlavourDecorator {
	public SteamedMilk(Beverage coffee) {
		this.coffee = coffee;
	}

	@Override
	protected double cost() {
		return addCostBySize(this.coffee.cost(), 0.83, 0.86, 0.89);
	}
}
