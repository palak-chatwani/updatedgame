import java.util.ArrayList;
import java.util.List;

class ActivityStore {
    public String getActivity(char c) {
        // Implement logic to retrieve activity based on character c
        return null; // Placeholder, replace with actual implementation
    }
}

class CafeStore {
    public String getCafe(char c) {
        // Implement logic to retrieve cafe based on character c
        return null; // Placeholder, replace with actual implementation
    }
}

class RestaurantStore {
    public String getRestaurant(char c) {
        // Implement logic to retrieve restaurant based on character c
        return null; // Placeholder, replace with actual implementation
    }
}


public class BirthdayPlanner {
    private ActivityStore activityStore;
    private CafeStore cafeStore;
    private RestaurantStore restaurantStore;

    public BirthdayPlanner(ActivityStore activityStore, CafeStore cafeStore, RestaurantStore restaurantStore) {
        this.activityStore = activityStore;
        this.cafeStore = cafeStore;
        this.restaurantStore = restaurantStore;
    }

    public List<String> generate(String input) {
        List<String> plan = new ArrayList<>();
        boolean lastWasEating = false;
        int mainActivityCount = 0;
        boolean restaurantAdded = false;

        for (char c : input.toCharArray()) {
            String activity;
            if (Character.isDigit(c)) {
                activity = activityStore.getActivity(c);
            } else if (Character.isLowerCase(c)) {
                activity = cafeStore.getCafe(c);
            } else if (Character.isUpperCase(c)) {
                if (restaurantAdded) continue; // Only allow one restaurant
                activity = restaurantStore.getRestaurant(c);
                restaurantAdded = true;
            } else {
                continue; // Ignore other characters
            }

            if (activity != null) {
                if (!lastWasEating || !activity.equals("eating")) {
                    if (activity.equals("main")) {
                        mainActivityCount++;
                        if (mainActivityCount > 2) continue; // Limit main activities to at most twice in a row
                    } else {
                        mainActivityCount = 0; // Reset main activity count if not a main activity
                    }
                    plan.add(activity);
                    lastWasEating = activity.equals("eating");
                }
            }
        }

        return plan;
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No input provided.");
            return;
        }

        String input = args[0];
        ActivityStore activityStore = new ActivityStore(); // Initialize with actual implementation
        CafeStore cafeStore = new CafeStore(); // Initialize with actual implementation
        RestaurantStore restaurantStore = new RestaurantStore(); // Initialize with actual implementation

        BirthdayPlanner planner = new BirthdayPlanner(activityStore, cafeStore, restaurantStore);
        List<String> plan = planner.generate(input);
        for (String activity : plan) {
            System.out.println(activity);
        }
    }
}
