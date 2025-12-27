package singleton.chocolateboiler.boilers;


public class ChocolateBoilerLockDoubleCheck{
	private boolean empty; 
	private boolean bioled; 
	private volatile static ChocolateBoilerLockDoubleCheck uniqueInstance; 

	private ChocolateBoilerLockDoubleCheck() {
		empty = true;
		bioled = false;
	} 

	public static ChocolateBoilerLockDoubleCheck getInstance() {
		if (uniqueInstance == null) {
			synchronized (ChocolateBoilerLockDoubleCheck.class) {
				if (uniqueInstance == null) {
					uniqueInstance = new ChocolateBoilerLockDoubleCheck(); 
				} 
			} 
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
