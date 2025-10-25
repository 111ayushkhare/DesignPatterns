package SingletonChocolateBoilerEnum; 

public class ChocolateBoilerDemo {
	public static void main(String[] args) {
		ChocolateBoilerEnum boiler = ChocolateBoilerEnum.INSTANCE;

		boiler.fill();
		boiler.drain();
		boiler.boil();
	} 
} 

enum ChocolateBoilerEnum {
	INSTANCE; 

	private boolean empty; 
	private boolean bioled; 

	ChocolateBoilerEnum() {
		empty = true;
		bioled = false;
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