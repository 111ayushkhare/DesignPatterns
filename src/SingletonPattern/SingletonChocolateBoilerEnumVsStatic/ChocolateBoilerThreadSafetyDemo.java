package singleton.chocolateboilerenumvsstatic;

public class ChocolateBoilerThreadSafetyDemo {
	public static void main(String[] args) throws InterruptedException {
		Runnable classicTask = () -> {
			ChocolateBoiler instance = ChocolateBoiler.getInstance(); 
			System.out.println("Classic Singleton: " + System.identityHashCode(instance));
		}; 

		Runnable enumTask = () -> {
			ChocolateBoilerEnum instance = ChocolateBoilerEnum.INSTANCE; 
			System.out.println("Enum Singleton: " + System.identityHashCode(instance)); 
		}; 

		// Launch multiple threads for Classic Singleton
		testThreads(classicTask, "CLASSIC");

        // Launch multiple threads for Classic Singleton
        testThreads(classicTask, "ENUM");
	} 

	private static void testThreads(Runnable taskType, String type) {
		try {
			System.out.println("Testing " + type + " Singleton:"); 
	        Thread[] threads = new Thread[5];
	        for (int i = 0; i < 5; i++) {
	        	threads[i] = new Thread(taskType);
	        	threads[i].start();
	        }
	        for (Thread t: threads) {
	        	t.join();
	        }
	        System.out.println();
		} catch (Exception e) {
			e.printStackTrace(); 
		}
	}
}