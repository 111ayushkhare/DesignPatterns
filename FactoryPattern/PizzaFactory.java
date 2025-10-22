import java.util.List; 
import java.util.ArrayList; 

public class PizzaFactory {
	public static void main(String[] args) {
		PizzaStore nyPizzaStore = new NYPizzaStore();
		PizzaStore chicagoPizzaStore = new ChicagoPizzaStore();

		Pizza pizza = nyPizzaStore.orderPizza(PizzaTypes.CHEESE);
		System.out.println("Ethan ordered a " + pizza.getName() + "\n");

		pizza = chicagoPizzaStore.orderPizza(PizzaTypes.PEPPERONI);
		System.out.println("Joe ordered a " + pizza.getName() + "\n");
	}
}


// Abstract Pizza 
abstract class Pizza {
	String name;
	String dough;
	String sauce;
	List<String> toppings = new ArrayList<String>();

	void prepare() {
		System.out.println("Preparing: " + name);
		System.out.println("Tossing dough...");
		System.out.println("Adding sauce...");
		System.out.println("Adding toppings: ");
		for (String topping: toppings) {
			System.out.println(" " + topping);
		}
	}

	void bake() {
		System.out.println("Baking for 25 minutes at 350");
	}

	void cut() {
		System.out.println("Cutting the pizza into diagonal slices");
	} 

	void box() {
		System.out.println("Place pizza in official PizzaStore box");
	} 

	public String getName() {
		return name;
	}
}

// Abstract PizzaStore 
abstract class PizzaStore {
	public Pizza orderPizza(PizzaTypes type) {
		Pizza pizza;

		pizza = createPizza(type);

		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();

		return pizza;
	}

	protected abstract Pizza createPizza(PizzaTypes type);
} 


// Pizza types enum
enum PizzaTypes {
	CHEESE, 
	PEPPERONI, 
	VEGGIE, 
	CLAM;
}


// Different Pizzas

// NY Style 
class NYStyleCheesePizza extends Pizza {
	public NYStyleCheesePizza() {
		name = "NY Style Sauce and Cheese Pizza";
		dough = "Thin Crust Dough";
		sauce = "Marinara Sauce";

		toppings.add("Grated Reggiano Cheese");
	}
} 
class NYStylePepperoniPizza extends Pizza {
	public NYStylePepperoniPizza() {
		name = "NY Style Sauce and Pepperoni Pizza";
		dough = "Thin Crust Dough";
		sauce = "Marinara Sauce";

		toppings.add("Grated Reggiano Pepperoni");
	}
} 
class NYStyleVeggiePizza extends Pizza {
	public NYStyleVeggiePizza() {
		name = "NY Style Sauce and Veggie Pizza";
		dough = "Thin Crust Dough";
		sauce = "Marinara Sauce";

		toppings.add("Grated Reggiano Veggie");
	}
} 
class NYStyleClamPizza extends Pizza {
	public NYStyleClamPizza() {
		name = "NY Style Sauce and Clam Pizza";
		dough = "Thin Crust Dough";
		sauce = "Marinara Sauce";

		toppings.add("Grated Reggiano Clam");
	}
} 

// Chicago Style
class ChicagoStyleCheesePizza extends Pizza {
	public ChicagoStyleCheesePizza() {
		name = "Chicago Style Sauce and Cheese Pizza";
		dough = "Thick Crust Dough";
		sauce = "Plum Tomato Sauce";

		toppings.add("Grated Mozzarella Cheese");
	}

	@Override
	void cut() {
		System.out.println("Cutting the pizza into square slices");
	}
} 
class ChicagoStylePepperoniPizza extends Pizza {
	public ChicagoStylePepperoniPizza() {
		name = "Chicago Style Sauce and Pepperoni Pizza";
		dough = "Thick Crust Dough";
		sauce = "Plum Tomato Sauce";

		toppings.add("Grated Mozzarella Pepperoni");
	}

	@Override
	void cut() {
		System.out.println("Cutting the pizza into square slices");
	}
} 
class ChicagoStyleVeggiePizza extends Pizza {
	public ChicagoStyleVeggiePizza() {
		name = "Chicago Style Sauce and Veggie Pizza";
		dough = "Thick Crust Dough";
		sauce = "Plum Tomato Sauce";

		toppings.add("Grated Mozzarella Veggie");
	}

	@Override
	void cut() {
		System.out.println("Cutting the pizza into square slices");
	}
} 
class ChicagoStyleClamPizza extends Pizza {
	public ChicagoStyleClamPizza() {
		name = "Chicago Style Sauce and Clam Pizza";
		dough = "Thick Crust Dough";
		sauce = "Plum Tomato Sauce";

		toppings.add("Grated Mozzarella Clam");
	} 

	@Override
	void cut() {
		System.out.println("Cutting the pizza into square slices");
	}
} 


// Different Pizza Stores 

// NY Store
class NYPizzaStore extends PizzaStore {
	protected Pizza createPizza(PizzaTypes item) {
		switch(item) {
			case PizzaTypes.CHEESE: 
				return new NYStyleCheesePizza(); 
			case PizzaTypes.PEPPERONI: 
				return new NYStylePepperoniPizza();
			case PizzaTypes.VEGGIE: 
				return new NYStyleVeggiePizza(); 
			case PizzaTypes.CLAM: 
				return new NYStyleClamPizza();
			default: 
				return null;
		}
	}
}

// Chicago Store 
class ChicagoPizzaStore extends PizzaStore {
	protected Pizza createPizza(PizzaTypes item) {
		switch(item) {
			case PizzaTypes.CHEESE: 
				return new ChicagoStyleCheesePizza(); 
			case PizzaTypes.PEPPERONI: 
				return new ChicagoStylePepperoniPizza();
			case PizzaTypes.VEGGIE: 
				return new ChicagoStyleVeggiePizza(); 
			case PizzaTypes.CLAM: 
				return new ChicagoStyleClamPizza();
			default: 
				return null;
		}
	}
} 
