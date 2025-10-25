package SingletonChocolateBoiler;


import java.util.function.Supplier;

public class ChocolateBoilerDemo {
    public static void main(String[] args) {
        System.out.println("=== Normal Chocolate Boiler ===");
        runBoilerExample(() -> ChocolateBoiler.getInstance());

        System.out.println("\n=== Thread-Safe Chocolate Boiler ===");
        runBoilerExample(() -> ChocolateBoilerThreadSafe.getInstance());

        System.out.println("\n=== Double-Checked Locking Chocolate Boiler ===");
        runBoilerExample(() -> ChocolateBoilerLockDoubleCheck.getInstance());
    }

    private static void runBoilerExample(Supplier<Object> supplier) {
        Runnable task = () -> {
            Object instance = supplier.get(); 
            synchronized (instance) {
                System.out.println(Thread.currentThread().getName() + " got instance: " + instance.hashCode()); 

                try {
                    if (instance instanceof ChocolateBoiler) {
                        ChocolateBoiler boiler = (ChocolateBoiler) instance; 
                        boiler.fill();
                        boiler.boil();
                        boiler.drain();
                    } else if (instance instanceof ChocolateBoilerThreadSafe) {
                        ChocolateBoilerThreadSafe boiler = (ChocolateBoilerThreadSafe) instance; 
                        boiler.fill();
                        boiler.drain();
                        boiler.boil();
                    } else if (instance instanceof ChocolateBoilerLockDoubleCheck) {
                        ChocolateBoilerLockDoubleCheck boiler = (ChocolateBoilerLockDoubleCheck) instance; 
                        boiler.drain();
                        boiler.fill();
                        boiler.boil();
                    }
                } catch (Exception e) {
                    e.printStackTrace(); 
                }
            }
        }; 

        Thread t1 = new Thread(task, "Thread-1"); 
        Thread t2 = new Thread(task, "Thread-2");
        Thread t3 = new Thread(task, "Thread-3");

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join(); 
            t2.join(); 
            t3.join(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
