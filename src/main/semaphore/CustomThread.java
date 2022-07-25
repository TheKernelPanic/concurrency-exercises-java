package main.semaphore;

import java.util.concurrent.Semaphore;

public class CustomThread extends Thread {

    ValuesStorage storage;
    Semaphore semaphore;

    public CustomThread(String name, ValuesStorage storage, Semaphore semaphore) {
        super(name);
        this.storage = storage;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {

            semaphore.acquire();
            this.storage.add("Add value from thread "  + this.getName());
            System.out.println("Show added values from thread " + this.getName());
            this.storage.printValues();

            Thread.sleep(1);

        } catch (InterruptedException ignored) {}
        finally {
            semaphore.release();
        }
    }
}
