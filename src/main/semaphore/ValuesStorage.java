package main.semaphore;

import java.util.ArrayList;

public class ValuesStorage {

    ArrayList<String> values;

    public ValuesStorage() {
        this.values = new ArrayList<>();
    }

    public ValuesStorage add(String value) {

        System.out.println(value);

        this.values.add(value);

        return this;
    }

    public void printValues() {
        int index = 0;
        while (index < this.values.size()) {
            System.out.println(this.values.get(index));
            index++;
        }
    }
}
