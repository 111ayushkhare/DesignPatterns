package decorator.pizza;

public class Driver {
	public static void main(String[] args) {
		// Margherita + ExtraCheese 
		BasePizza margheritaWithExtraCheesePizza = new ExtraCheese(new Margherita());
		System.out.println("Margherita With Extra Cheese Pizza: " + margheritaWithExtraCheesePizza.cost());

		// Margherita + ExtraCheese + Mushroom
		BasePizza margheritaWithExtraCheeseAndMushroomPizza = new Mushroom(new ExtraCheese(new Margherita()));
		System.out.println("Margherita Mushroom With Extra Cheese Mushroom Pizza: " + margheritaWithExtraCheeseAndMushroomPizza.cost());

		// VegDelight + ExtraChees + Corn + Musroom
		BasePizza vegDelightCornMushroomWithExtraCheesePizza = new Corn(new Mushroom(new ExtraCheese(new VegDelight())));
		System.out.println("VegDelight CornMushroom With ExtraCheese Pizza: " + vegDelightCornMushroomWithExtraCheesePizza.cost());
	}
}

// Base class
abstract class BasePizza {
	public abstract int cost();
}

// Pizza Categories
class Margherita extends BasePizza {
	@Override
	public int cost() {
		return 150;
	}
}

class Farmhouse extends BasePizza {
	@Override
	public int cost() {
		return 200;
	}
}

class VegDelight extends BasePizza {
	@Override
	public int cost() {
		return 120;
	}
}

// Decorators
abstract class ToppingDecorator extends BasePizza {}

// Toppings Flavours
class ExtraCheese extends ToppingDecorator {
	BasePizza pizza;

	public ExtraCheese(BasePizza pizza) {
		this.pizza = pizza;
	}

	@Override
	public int cost() {
		return this.pizza.cost() + 25;
	}
}

class Mushroom extends ToppingDecorator {
	BasePizza pizza;

	public Mushroom(BasePizza pizza) {
		this.pizza = pizza;
	}

	@Override
	public int cost() {
		return this.pizza.cost() + 40;
	}
}

class Corn extends ToppingDecorator {
	BasePizza pizza;

	public Corn(BasePizza pizza) {
		this.pizza = pizza;
	}

	@Override
	public int cost() {
		return this.pizza.cost() + 30;
	}
}
