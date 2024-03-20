/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

class ActivityStore {
    private HashMap<String, HashSet<String>> store;

    public ActivityStore() {
        this.store = new HashMap<>();
    }

    public ActivityStore(String fileName) throws IOException {
        this();
        loadActivitiesFromFile(fileName);
    }

    public void add(String key, String item) {
        if (this.store.containsKey(key)) {
            this.store.get(key).add(item);
        } else {
            HashSet<String> items = new HashSet<>();
            items.add(item);
            this.store.put(key, items);
        }
    }

    public String getRandomItem(String key) {
        if (this.store.containsKey(key)) {
            HashSet<String> items = this.store.get(key);
            if (!items.isEmpty()) {
                Random rand = new Random();
                int index = rand.nextInt(items.size());
                for (String item : items) {
                    if (index-- == 0) {
                        return item;
                    }
                }
            }
        }
        return null;
    }

    private void loadActivitiesFromFile(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    String[] parts = line.split(":");
                    if (parts.length == 2) {
                        String key = parts[0].trim();
                        String item = parts[1].trim();
                        add(key, item);
                    }
                }
            }
        }
    }
}

public class BirthdayPlannerTest2 {
    private ActivityStore store;

    public BirthdayPlannerTest2() {
        this.store = new ActivityStore();
    }

    public void testAdd() {
        this.store.add("b", "balloons");
        assert this.store.getRandomItem("b").equals("balloons");
    }

    public void testGetRandomItem() {
        this.store.add("c", "cake");
        assert this.store.getRandomItem("c").equals("cake");
    }

    public void runTests() {
        testAdd();
        testGetRandomItem();
        System.out.println("All tests passed successfully.");
    }

    public static void main(String[] args) {
        BirthdayPlannerTest2 tester = new BirthdayPlannerTest2();
        tester.runTests();
    }
}

