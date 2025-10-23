package AbstractFactoryPattern;

public class PizzaAbstractFactory {
	public static void main(String[] args) {
		PizzaStore nyPizzaStore = new NYPizzaStore();
		PizzaStore chicagoPizzaStore = new ChicagoPizzaStore();

		Pizza pizza = nyPizzaStore.orderPizza(PizzaTypes.CHEESE);
		System.out.println("Ethan ordered a " + pizza.getName() + "\n");

		pizza = chicagoPizzaStore.orderPizza(PizzaTypes.PEPPERONI);
		System.out.println("Joe ordered a " + pizza.getName() + "\n"); 

		pizza = chicagoPizzaStore.orderPizza(PizzaTypes.VEGGIE);
		System.out.println("Max ordered a " + pizza.getName() + "\n");
	}
} 

// Ingredients  
interface DoughI {
	PizzaIngredients getName();
}
interface SauceI {
	PizzaIngredients getName();
} 
interface CheeseI {
	PizzaIngredients getName();
} 
interface PepperoniI {
	PizzaIngredients getName();
} 
interface VeggiesI {
	PizzaIngredients getName();
}
interface ClamsI {
	PizzaIngredients getName();
} 

// Ingredients factory 
interface PizzaIngredientFactoryI {
	public DoughI createDough(); 
	public SauceI createSauce(); 
	public CheeseI createCheese(); 
	public VeggiesI[] createVeggies(); 
	public PepperoniI createPepperoni(); 
	public ClamsI createClam(); 
}


// Ingredients - Dough 
class ThinCrustDough implements DoughI {
	private final PizzaIngredients name; 

	public ThinCrustDough(PizzaIngredients name) {
		this.name = name;
	}

	@Override
	public PizzaIngredients getName() {
		return name;
	}
} 
class ThickCrustDough implements DoughI {
	private final PizzaIngredients name; 

	public ThickCrustDough(PizzaIngredients name) {
		this.name = name;
	}

	@Override
	public PizzaIngredients getName() {
		return name;
	}
} 

// Ingredients - Sauce 
class MarinaraSauce implements SauceI {
	private final PizzaIngredients name; 

	public MarinaraSauce(PizzaIngredients name) {
		this.name = name;
	}

	@Override
	public PizzaIngredients getName() {
		return name;
	}
} 
class PlumTomatoSauce implements SauceI {
	private final PizzaIngredients name; 

	public PlumTomatoSauce(PizzaIngredients name) {
		this.name = name;
	}

	@Override
	public PizzaIngredients getName() {
		return name;
	}
} 

// Ingredients - Cheese 
class ReggianoCheese implements CheeseI { 
	private final PizzaIngredients name; 
	public ReggianoCheese(PizzaIngredients name) {
		this.name = name;
	}

	@Override
	public PizzaIngredients getName() {
		return name;
	}
} 
class MozarellaCheese implements CheeseI {
	private final PizzaIngredients name; 

	public MozarellaCheese(PizzaIngredients name) {
		this.name = name;
	}

	@Override
	public PizzaIngredients getName() {
		return name;
	}
} 

// Ingredients - VeggiesI 
class Garlic implements VeggiesI {
	private final PizzaIngredients name; 

	public Garlic(PizzaIngredients name) {
		this.name = name;
	}

	@Override
	public PizzaIngredients getName() {
		return name;
	}
} 
class Onion implements VeggiesI {
	private final PizzaIngredients name; 

	public Onion(PizzaIngredients name) {
		this.name = name;
	}

	@Override
	public PizzaIngredients getName() {
		return name;
	}
} 
class RedPepper implements VeggiesI {
	private final PizzaIngredients name; 

	public RedPepper(PizzaIngredients name) {
		this.name = name;
	}

	@Override
	public PizzaIngredients getName() {
		return name;
	}
} 
class BlackOlives implements VeggiesI {
	private final PizzaIngredients name; 

	public BlackOlives(PizzaIngredients name) {
		this.name = name;
	}

	@Override
	public PizzaIngredients getName() {
		return name;
	}
}
class Spinach implements VeggiesI {
	private final PizzaIngredients name; 

	public Spinach(PizzaIngredients name) {
		this.name = name;
	}

	@Override
	public PizzaIngredients getName() {
		return name;
	}
} 
class EggPlant implements VeggiesI {
	private final PizzaIngredients name; 

	public EggPlant(PizzaIngredients name) {
		this.name = name;
	}

	@Override
	public PizzaIngredients getName() {
		return name;
	}
} 

// Ingredients - PepperoniI  
class SlicedPepperoni implements PepperoniI {
	private final PizzaIngredients name; 

	public SlicedPepperoni(PizzaIngredients name) {
		this.name = name;
	}

	@Override
	public PizzaIngredients getName() {
		return name;
	}
}

// Ingredients - PepperoniI 
class FreshClams implements ClamsI {
	private final PizzaIngredients name; 

	public FreshClams(PizzaIngredients name) {
		this.name = name;
	}

	@Override
	public PizzaIngredients getName() {
		return name;
	}
} 
class FrozenClams implements ClamsI {
	private final PizzaIngredients name; 

	public FrozenClams(PizzaIngredients name) {
		this.name = name;
	}

	@Override
	public PizzaIngredients getName() {
		return name;
	}
} 


// Ingredients factory classes
class NYIngredientFactory implements PizzaIngredientFactoryI {
	@Override
	public DoughI createDough() {
		return new ThinCrustDough(PizzaIngredients.THIN_CRUST_DOUGH);
	} 

	@Override
	public SauceI createSauce() {
		return new MarinaraSauce(PizzaIngredients.MARINARA_SAUCE);
	} 

	@Override
	public CheeseI createCheese() {
		return new ReggianoCheese(PizzaIngredients.REGGIANO_CHEESE); 
	} 

	@Override
	public VeggiesI[] createVeggies() {
		VeggiesI[] veggies = { 
			new Garlic(PizzaIngredients.GARLIC), 
			new Onion(PizzaIngredients.ONION), 
			new RedPepper(PizzaIngredients.RED_PEPPER) 
		}; 

		return veggies; 
	} 

	@Override
	public PepperoniI createPepperoni() {
		return new SlicedPepperoni(PizzaIngredients.SLICED_PEPPERONI); 
	} 

	@Override
	public ClamsI createClam() {
		return new FreshClams(PizzaIngredients.FRESH_CLAMS); 
	} 
} 

class ChicagoIngredientFactory implements PizzaIngredientFactoryI {
	@Override
	public DoughI createDough() {
		return new ThickCrustDough(PizzaIngredients.THICK_CRUST_DOUGH);
	} 

	@Override
	public SauceI createSauce() {
		return new PlumTomatoSauce(PizzaIngredients.PLUM_TOMATO_SAUCE);
	} 

	@Override
	public CheeseI createCheese() {
		return new MozarellaCheese(PizzaIngredients.MOZARELLA_CHEESE); 
	} 

	@Override
	public VeggiesI[] createVeggies() {
		VeggiesI[] veggies = { 
			new BlackOlives(PizzaIngredients.BLACK_OLIVES), 
			new Spinach(PizzaIngredients.SPINACH), 
			new EggPlant(PizzaIngredients.EGG_PLANT) 
		}; 

		return veggies;
	} 

	@Override
	public PepperoniI createPepperoni() {
		return new SlicedPepperoni(PizzaIngredients.SLICED_PEPPERONI); 
	} 

	@Override
	public ClamsI createClam() {
		return new FrozenClams(PizzaIngredients.FROZEN_CLAMS); 
	} 
} 


// Abstract Pizza 
abstract class Pizza {
	String name; 

	DoughI dough; 
	SauceI sauce; 
	VeggiesI[] veggies; 
	CheeseI cheese; 
	PepperoniI pepperoni; 
	ClamsI clams; 

	abstract void prepare(); 

	void bake() {
		System.out.println("Baking for 25 minutes at 350");
	}

	void cut() {
		System.out.println("Cutting the pizza into diagonal slices");
	} 

	void box() {
		System.out.println("Place pizza in official PizzaStore box");
	} 

	void setName(String name) {
		this.name = name; 
	} 

	String getName() {
		return name; 
	} 
} 

// Pizza types enum
enum PizzaTypes {
	CHEESE, 
	PEPPERONI, 
	VEGGIE, 
	CLAM;
} 

// Pizza Ingredients
enum PizzaIngredients {
	THIN_CRUST_DOUGH, 
	THICK_CRUST_DOUGH, 

	MARINARA_SAUCE, 
	PLUM_TOMATO_SAUCE, 

	REGGIANO_CHEESE, 
	MOZARELLA_CHEESE, 

	SLICED_PEPPERONI, 

	FRESH_CLAMS, 
	FROZEN_CLAMS, 

	GARLIC, 
	ONION, 
	RED_PEPPER, 
	BLACK_OLIVES, 
	SPINACH, 
	EGG_PLANT;
}


// Pizza Categories 
class CheesePizza extends Pizza {
	PizzaIngredientFactoryI ingredientFactory; 

	public CheesePizza(PizzaIngredientFactoryI ingredientFactory) {
		this.ingredientFactory = ingredientFactory; 
	} 

	void prepare() { 
		System.out.println("Preparing " + name); 
		dough = ingredientFactory.createDough(); 
		sauce = ingredientFactory.createSauce(); 
		cheese = ingredientFactory.createCheese(); 
		System.out.println("Used: " + dough.getName() + ", " + sauce.getName() + ", " + cheese.getName()); 
	} 
} 

class VeggiePizza extends Pizza {
	PizzaIngredientFactoryI ingredientFactory; 

	public VeggiePizza(PizzaIngredientFactoryI ingredientFactory) {
		this.ingredientFactory = ingredientFactory; 
	} 

	void prepare() { 
		System.out.println("Preparing " + name); 
		dough = ingredientFactory.createDough(); 
		sauce = ingredientFactory.createSauce(); 
		cheese = ingredientFactory.createCheese(); 
		veggies = ingredientFactory.createVeggies(); 
		System.out.print("Used: " + dough.getName() + ", " + sauce.getName() + ", " + cheese.getName()); 
		for (VeggiesI veggy: veggies) {
			System.out.print(", " + veggy.getName()); 
		}
		System.out.println(); 
	} 
} 

class PepperoniPizza extends Pizza {
	PizzaIngredientFactoryI ingredientFactory; 

	public PepperoniPizza(PizzaIngredientFactoryI ingredientFactory) {
		this.ingredientFactory = ingredientFactory; 
	} 

	void prepare() { 
		System.out.println("Preparing " + name); 
		dough = ingredientFactory.createDough(); 
		sauce = ingredientFactory.createSauce(); 
		cheese = ingredientFactory.createCheese(); 
		pepperoni = ingredientFactory.createPepperoni(); 
		System.out.println("Used: " + dough.getName() + ", " + sauce.getName() + ", " + cheese.getName() + ", " + pepperoni.getName()); 
	} 
} 

class ClamPizza extends Pizza {
	PizzaIngredientFactoryI ingredientFactory; 

	public ClamPizza(PizzaIngredientFactoryI ingredientFactory) {
		this.ingredientFactory = ingredientFactory; 
	} 

	void prepare() { 
		System.out.println("Preparing " + name); 
		dough = ingredientFactory.createDough(); 
		sauce = ingredientFactory.createSauce(); 
		cheese = ingredientFactory.createCheese(); 
		clams = ingredientFactory.createClam(); 
		System.out.println("Used: " + dough.getName() + ", " + sauce.getName() + ", " + cheese.getName() + ", " + clams.getName()); 
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

// Pizza Stores 
class NYPizzaStore extends PizzaStore {
	protected Pizza createPizza(PizzaTypes item) {
		Pizza pizza = null;
		PizzaIngredientFactoryI ingredientFactory = new NYIngredientFactory(); 

		switch(item) {
			case PizzaTypes.CHEESE: 
				pizza = new CheesePizza(ingredientFactory); 
				pizza.setName("NY Style CHEESE Pizza"); 
				break;
			case PizzaTypes.PEPPERONI: 
				pizza = new PepperoniPizza(ingredientFactory); 
				pizza.setName("NY Style PEPPERONI Pizza"); 
				break;
			case PizzaTypes.VEGGIE: 
				pizza = new VeggiePizza(ingredientFactory); 
				pizza.setName("NY Style VEGGIE Pizza"); 
				break; 
			case PizzaTypes.CLAM: 
				pizza = new ClamPizza(ingredientFactory); 
				pizza.setName("NY Style CLAM Pizza"); 
				break;
			default: 
				break; 
		} 

		return pizza; 
	}
} 

class ChicagoPizzaStore extends PizzaStore {
	protected Pizza createPizza(PizzaTypes item) {
		Pizza pizza = null;
		PizzaIngredientFactoryI ingredientFactory = new ChicagoIngredientFactory(); 

		switch(item) {
			case PizzaTypes.CHEESE: 
				pizza = new CheesePizza(ingredientFactory); 
				pizza.setName("Chicago Style CHEESE Pizza"); 
				break;
			case PizzaTypes.PEPPERONI: 
				pizza = new PepperoniPizza(ingredientFactory); 
				pizza.setName("Chicago Style PEPPERONI Pizza"); 
				break;
			case PizzaTypes.VEGGIE: 
				pizza = new VeggiePizza(ingredientFactory); 
				pizza.setName("Chicago Style VEGGIE Pizza"); 
				break; 
			case PizzaTypes.CLAM: 
				pizza = new ClamPizza(ingredientFactory); 
				pizza.setName("Chicago Style CLAM Pizza"); 
				break;
			default: 
				break; 
		} 

		return pizza; 
	} 
} 
