package singleton.chocolateboiler;

public class ChocolateBoilerThreadSafe {
	private boolean empty; 
	private boolean bioled; 
	private static ChocolateBoilerThreadSafe uniqueInstance; 

	private ChocolateBoilerThreadSafe() {
		empty = true;
		bioled = false;
	} 

	public static synchronized ChocolateBoilerThreadSafe getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new ChocolateBoilerThreadSafe(); 
		} 
		return uniqueInstance; 
	} 

	public void fill() {
		if (isEmpty()) {
			empty = false; 
			bioled = false; 

			System.out.println("Bioler is FULL");
		} else {
			System.out.println("Bioler is ALREADY FULL");
		}
	} 

	public void drain() {
		if (!isEmpty() && isBoiled()) {
			empty = true; 
			bioled = false; 

			System.out.println("Bioler DRAINED"); 
		} else {
			System.out.println("Bioler is EMPTY or MILD"); 
		}
	} 

	public void boil() {
		if (!isEmpty() && !isBoiled()) {
			bioled = true; 

			System.out.println("Bioler is HOT"); 
		} else {
			System.out.println("Bioler is ALREADY HOT or EMPTY");
		} 
	} 

	public boolean isEmpty() {
		return empty; 
	} 
	public boolean isBoiled() {
		return bioled; 
	} 
} 
