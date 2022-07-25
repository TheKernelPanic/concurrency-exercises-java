package main.semaphore;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {

        ValuesStorage storage = new ValuesStorage();
        Semaphore semaphore = new Semaphore(4);

        ArrayList<CustomThread> threads = new ArrayList<>();

        threads.add(new CustomThread("1", storage, semaphore));
        threads.add(new CustomThread("2", storage, semaphore));
        threads.add(new CustomThread("3", storage, semaphore));
        threads.add(new CustomThread("4", storage, semaphore));

        threads.forEach(thread -> {
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
