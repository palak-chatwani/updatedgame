/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

// Online Java Compiler
// Use this editor to write, compile and run your Java code online

import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

class ActivityStore {
    private HashMap<String, HashSet<String>> store;

    public ActivityStore() {
        this.store = new HashMap<>();
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
}

public class BirthdayPlannerTest {
    private ActivityStore store;

    public BirthdayPlannerTest() {
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
        BirthdayPlannerTest tester = new BirthdayPlannerTest();
        tester.runTests();
    }
}

